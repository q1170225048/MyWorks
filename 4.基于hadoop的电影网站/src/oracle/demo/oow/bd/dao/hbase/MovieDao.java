package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;

import oracle.demo.oow.bd.to.CastCrewTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.CustomerTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.HBaseDB;

public class MovieDao
{

	public void insertMovie(MovieTO movieTO)
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("movie");
		Table tb = db.getTableByName("genre");
		if(table!=null)
		{
			List<Put> puts=new ArrayList();
			List<Put> puts2=new ArrayList();
			//分类
			List<GenreTO> list = movieTO.getGenres();
			
			for(GenreTO gto:list)
			{
				Put put =new Put(Bytes.toBytes(movieTO.getId()+"_"+gto.getId()));
				put.addColumn(Bytes.toBytes("genre"), Bytes.toBytes("genre_id"), Bytes.toBytes(gto.getId()));
				put.addColumn(Bytes.toBytes("genre"), Bytes.toBytes("genre_name"), Bytes.toBytes(gto.getName()));
				Put put1 =new Put(Bytes.toBytes(gto.getId()));
				put1.addColumn(Bytes.toBytes("genre"), Bytes.toBytes("id"), Bytes.toBytes(gto.getId()));
				put1.addColumn(Bytes.toBytes("genre"), Bytes.toBytes("name"), Bytes.toBytes(gto.getName()));
				Put put2 =new Put(Bytes.toBytes(gto.getId()+"_"+movieTO.getId()));
				put2.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("movieid"), Bytes.toBytes(movieTO.getId()));
				puts2.add(put1);
				puts2.add(put2);
				puts.add(put);
			}
			
			//电影信息
			Put put1 =new Put(Bytes.toBytes(movieTO.getId()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("movieid"), Bytes.toBytes(movieTO.getId()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("original_title"), Bytes.toBytes(movieTO.getTitle()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("overview"), Bytes.toBytes(movieTO.getOverview()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("poster_path"), Bytes.toBytes(movieTO.getPosterPath()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("release_date"), Bytes.toBytes(movieTO.getReleasedYear()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("vote_count"), Bytes.toBytes(movieTO.getVoteCount()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("runtime"), Bytes.toBytes(movieTO.getRunTime()));
			put1.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("popularity"), Bytes.toBytes(movieTO.getPopularity()));

			
			puts.add(put1);
			try
			{
				table.put(puts);
				tb.put(puts2);
				table.close();
				tb.close();
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public MovieTO getMovieInfoById(int movieId) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		Table tb=db.getTableByName("movie");
		Get get=new Get(Bytes.toBytes(movieId));
		CastCrewTO ccto= new CastCrewTO();
		ccto.setMovieId(movieId);
		CastDAO castDao =new CastDAO();
		CrewDAO crewDao =new CrewDAO();
		List<CastTO> castList =castDao.getCastsByMovieId(movieId);
		List<CrewTO> crewList =crewDao.getCrewsByMovieId(movieId);
		ccto.setCastList(castList);
		ccto.setCrewList(crewList);
		MovieTO mto =new MovieTO();
		ArrayList<GenreTO> list=getGenresById(movieId);
		mto.setCastCrewTO(ccto);
		mto.setGenres(list);
		try
		{
			Result rs=tb.get(get);
			int run=0;
			if(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("runtime")) != null)
			{
				run =Bytes.toInt(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("runtime")));
			}
			int date=1900;
			if(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("release_date")) != null)
			{
				date = Bytes.toInt(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("release_date")));
			}
			int vote=0;
			if(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("vote_count")) != null)
			{
				vote = Bytes.toInt(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("vote_count")));
			}
			
			mto.setDate(String.valueOf(date));
			mto.setId(movieId);
			mto.setTitle(Bytes.toString(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("original_title"))));
			mto.setRunTime(run);
			mto.setPosterPath(Bytes.toString(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("poster_path"))));
			mto.setOverview(Bytes.toString(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("overview"))));
			mto.setVoteCount(vote);
			if(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("popularity")) != null)
			{
				mto.setPopularity(Bytes.toDouble(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("popularity"))));
			}
			else
				mto.setPopularity(0.0);
			
			tb.close();
			//db.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mto;
	}
	public ArrayList<GenreTO> getGenresById(int id) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("movie");
		ArrayList<GenreTO> list =new ArrayList<GenreTO>();
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(id+"_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			if(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("genre_id")) != null)
			{
				int genreId=Bytes.toInt(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("genre_id")));
				String name = Bytes.toString(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("genre_name")));
				GenreTO gto=new GenreTO();
				gto.setId(genreId);
				gto.setName(name);
				list.add(gto);
				//System.out.println(gto);
			}
			
		}
		
		tb.close();
		//db.close();
		return list;
	}
	public static void main(String[] args) throws IOException
	{
		MovieDao mdao = new MovieDao();
		mdao.getGenresById(1947);
	}
}
