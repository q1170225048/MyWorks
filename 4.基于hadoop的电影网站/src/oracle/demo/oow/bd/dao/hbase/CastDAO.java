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
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.RandomRowFilter;
import org.apache.hadoop.hbase.util.Bytes;

import oracle.demo.oow.bd.to.CastMovieTO;
import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.HBaseDB;

public class CastDAO
{

	public void insertCastInfo(CastTO castTO) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("cast");
		Table tb = db.getTableByName("movie");
		if(table!=null)
		{
			List<Put> puts=new ArrayList();
			//crew-movies
			List<CastMovieTO> list = castTO.getCastMovieList();
			
			for(CastMovieTO movie:list)
			{
				Put put2=new Put(Bytes.toBytes(movie.getId()+"_"+castTO.getId()));
				put2.addColumn(Bytes.toBytes("cast"), Bytes.toBytes("cast_id"), Bytes.toBytes(castTO.getId()));
				tb.put(put2);
				Put put =new Put(Bytes.toBytes(castTO.getId()+"_"+movie.getId()));
				put.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("movie_id"), Bytes.toBytes(movie.getId()));
				put.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("character"), Bytes.toBytes(movie.getCharacter()));
				put.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("order"), Bytes.toBytes(movie.getOrder()));

				puts.add(put);
			}
			
			//职务信息
			Put put1 =new Put(Bytes.toBytes(castTO.getId()));
			put1.addColumn(Bytes.toBytes("cast"), Bytes.toBytes("name"), Bytes.toBytes(castTO.getName()));
			
			
			puts.add(put1);
			try
			{
				table.put(puts);
				tb.close();
				table.close();
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

		
	}

	public List<CastTO> getCastsByMovieId(int movieId) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		
		List<CastTO> list=new ArrayList<CastTO>();
		Table tb = db.getTableByName("movie");
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(movieId+"_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for(Result result:rs)
		{
			if(result.getValue(Bytes.toBytes("cast"), Bytes.toBytes("cast_id")) != null)
			{
				int cId=Bytes.toInt(result.getValue(Bytes.toBytes("cast"), Bytes.toBytes("cast_id")));
				CastTO cto =getCastById(cId, movieId);
				list.add(cto);
			}
		}
		tb.close();
		
		return list;
	}
	public CastTO getCastById(int castId,int movieId) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("cast");
		CastTO cto = new CastTO();
		Get get = new Get(Bytes.toBytes(castId+"_"+movieId));
		Result rs = table.get(get);
		cto.setId(castId);
		cto.setCharacter(Bytes.toString(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("character"))));
		cto.setOrder((Bytes.toInt(rs.getValue(Bytes.toBytes("movie"), Bytes.toBytes("order")))));
		Get get1=new Get(Bytes.toBytes(castId));
		Result rs1 = table.get(get1);
		cto.setName(Bytes.toString(rs1.getValue(Bytes.toBytes("cast"), Bytes.toBytes("name"))));
		table.close();
		
		return cto;
	}
	public List<MovieTO> getMoviesByCast(int castId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("cast");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		FilterList  filters=new FilterList();
		Filter filter = new PrefixFilter(Bytes.toBytes(castId+"_"));
		Filter filter1=new PageFilter(25);
		Filter filter2=new RandomRowFilter(0.5f);
		filters.addFilter(filter);
		filters.addFilter(filter1);
		filters.addFilter(filter2);
		scan.setFilter(filters);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			//System.out.println(result);
			if(result.getValue(Bytes.toBytes("movie"), Bytes.toBytes("movie_id")) != null)
			{
				int movieId=Bytes.toInt(result.getValue(Bytes.toBytes("movie"), Bytes.toBytes("movie_id")));
				MovieTO mto= mdao.getMovieInfoById(movieId);
				list.add(mto);
				//System.out.println(mto);
			}
			
			
		}
		
		tb.close();
		return list;
	}
}
