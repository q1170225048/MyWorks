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

import oracle.demo.oow.bd.to.CastTO;
import oracle.demo.oow.bd.to.CrewTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.HBaseDB;

public class CrewDAO
{

	public void insertCrewInfo(CrewTO crewTO) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("crew");
		Table tb = db.getTableByName("movie");
		if(table!=null)
		{
			List<Put> puts=new ArrayList();
			//crew-movies
			List<String> list = crewTO.getMovieList();
			for(String movie:list)
			{
				Put put2=new Put(Bytes.toBytes(movie+"_"+crewTO.getId()));
				put2.addColumn(Bytes.toBytes("crew"), Bytes.toBytes("crew_id"), Bytes.toBytes(crewTO.getId()));
				tb.put(put2);
				Put put =new Put(Bytes.toBytes(crewTO.getId()+"_"+movie));
				put.addColumn(Bytes.toBytes("movie"), Bytes.toBytes("movie_id"), Bytes.toBytes(movie));
				puts.add(put);
			}
			
			//职务信息
			Put put1 =new Put(Bytes.toBytes(crewTO.getId()));
			put1.addColumn(Bytes.toBytes("crew"), Bytes.toBytes("name"), Bytes.toBytes(crewTO.getName()));
			put1.addColumn(Bytes.toBytes("crew"), Bytes.toBytes("job"), Bytes.toBytes(crewTO.getJob()));
			
			
			puts.add(put1);
			try
			{
				table.put(puts);
				table.close();
				
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public List<CrewTO> getCrewsByMovieId(int movieId) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		
		List<CrewTO> list=new ArrayList<CrewTO>();
		Table tb = db.getTableByName("movie");
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(movieId+"_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for(Result result:rs)
		{
			if(result.getValue(Bytes.toBytes("crew"), Bytes.toBytes("crew_id")) != null)
			{
				int cId=Bytes.toInt(result.getValue(Bytes.toBytes("crew"), Bytes.toBytes("crew_id")));
				CrewTO cto =getCastById(cId, movieId);
				list.add(cto);
			}
		}
		tb.close();
		
		return list;
	}

	private CrewTO getCastById(int cId, int movieId) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("crew");
		CrewTO cto = new CrewTO();
		//Get get = new Get(Bytes.toBytes(cId+"_"+movieId));
		//Result rs = table.get(get);
		cto.setId(cId);
		cto.setMovieId(movieId);
		Get get1=new Get(Bytes.toBytes(cId));
		Result rs1 = table.get(get1);
		cto.setName(Bytes.toString(rs1.getValue(Bytes.toBytes("crew"), Bytes.toBytes("name"))));
		cto.setJob(Bytes.toString(rs1.getValue(Bytes.toBytes("crew"), Bytes.toBytes("job"))));
		table.close();
		
		return cto;
	}
	public List<MovieTO> getMoviesByCrew(int crewId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("crew");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		FilterList  filters=new FilterList();
		Filter filter = new PrefixFilter(Bytes.toBytes(crewId+"_"));
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
				String movieId=Bytes.toString(result.getValue(Bytes.toBytes("movie"), Bytes.toBytes("movie_id")));
				MovieTO mto= mdao.getMovieInfoById(Integer.parseInt(movieId));
				list.add(mto);
				//System.out.println(mto);
			}
			
			
		}
		
		tb.close();
		return list;
	}

}
