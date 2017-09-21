package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import oracle.demo.oow.bd.to.GenreMovieTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.HBaseDB;

public class GenreDao
{
	public List<MovieTO> getMoviesInfoByGenreId(int gId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("genre");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		FilterList  filters=new FilterList();
		Filter filter = new PrefixFilter(Bytes.toBytes(gId+"_"));
		Filter filter1=new PageFilter(25);
		Filter filter2=new RandomRowFilter(0.5f);
		filters.addFilter(filter);
		filters.addFilter(filter1);
		filters.addFilter(filter2);
		scan.setFilter(filters);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			//System.out.println(result);
			if(result.getValue(Bytes.toBytes("movie"), Bytes.toBytes("movieid")) != null)
			{
				int movieId=Bytes.toInt(result.getValue(Bytes.toBytes("movie"), Bytes.toBytes("movieid")));
				MovieTO mto= mdao.getMovieInfoById(movieId);
				list.add(mto);
				//System.out.println(mto);
			}
			
			
		}
		
		tb.close();
		
		return list;
	}
	public List<GenreTO> getGenres() throws IOException{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("genre");
		List<GenreTO> list =new ArrayList<GenreTO>();
		
		Scan scan = new Scan();
		ResultScanner rs=tb.getScanner(scan);
		for(Result result:rs)
		{
			int id =0;
			if(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("id")) != null)
			{
				try{
					id=Bytes.toInt(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("id")));
				}
				catch(Exception e)
				{
					
				}
				GenreTO gto =new GenreTO();
				//System.out.println(id);
				
				gto.setId(id);
				//System.out.println(getGenreName(id));
				gto.setName(getGenreName(id));
				
				list.add(gto);
				
			}
			
		}
		tb.close();
		
		return list;
		
	}
	public String getGenreName(int Gid) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("genre");
		Get get =new Get(Bytes.toBytes(Gid));
		Result rs = tb.get(get);
		String m=Bytes.toString(rs.getValue(Bytes.toBytes("genre"), Bytes.toBytes("name")));
		tb.close();
		
		return m;
	}
	public static void main(String[] args) throws IOException
	{
		GenreDao gdao=new GenreDao();
		gdao.getRandomMovies();
		
	}
	public List<GenreMovieTO> getRandomMovies() throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("genre");
		GenreDao gdao = new GenreDao();
		Scan scan = new Scan();
		FilterList fList=new FilterList();
		Filter f1=new PageFilter(6);
		Filter f2=new RandomRowFilter(0.3f);
		fList.addFilter(f1);
		fList.addFilter(f2);
		scan.setFilter(fList);
		List<GenreMovieTO> list =new ArrayList<GenreMovieTO>();
		ResultScanner sr=tb.getScanner(scan);
		int id = 0;
		for(Result rs:sr)
		{
			if(rs.getValue(Bytes.toBytes("genre"), Bytes.toBytes("id")) != null)
			{
				
					id=Bytes.toInt(rs.getValue(Bytes.toBytes("genre"), Bytes.toBytes("id")));
					//List<MovieTO> mlist = gdao.getMoviesInfoByGenreId(id);
					GenreMovieTO gm=new GenreMovieTO();
					gm.setGenreId(id);
					GenreTO gto=new GenreTO();
					gto.setId(id);
					gto.setName(gdao.getGenreName(id));
					//gm.setMovieList(mlist);
					gm.setGenreTO(gto);
					list.add(gm);
					
				
			System.out.println(id);
			}
		}
		tb.close();
		
		return list;
	}
}
