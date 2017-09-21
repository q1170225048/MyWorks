package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.CustomerTO;
import oracle.demo.oow.bd.to.GenreMovieTO;
import oracle.demo.oow.bd.to.GenreTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.hbase.HBaseDB;

public class UserDAO
{
	private static int MOVIE_MAX_COUNT = 25;
    private static int GENRE_MAX_COUNT = 10;

	public void insert(CustomerTO custTO)
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("user");
		if(table!=null)
		{
			//username->id
			Put put =new Put(Bytes.toBytes(custTO.getUserName()));
			put.addColumn(Bytes.toBytes("id"), Bytes.toBytes("id"), Bytes.toBytes(custTO.getId()));
			//用户信息
			Put put1 =new Put(Bytes.toBytes(custTO.getId()));
			put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes(custTO.getName()));
			put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("email"), Bytes.toBytes(custTO.getEmail()));
			put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("username"), Bytes.toBytes(custTO.getUserName()));
			put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("password"), Bytes.toBytes(custTO.getPassword()));
			List<Put> puts=new ArrayList();
			puts.add(put);
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

	public CustomerTO getCustomerByCredential(String username, String password)
	{
		CustomerTO cto=null;
		if(!username.equals("")){
		int id = getIdByUsername(username);
		if(id>0)
		{
			CustomerTO ct=getInfoById(id);
			if(ct.getPassword().equals(password))
			{
				cto=ct;
			}
		}
		}
		return cto;
	}

	private CustomerTO getInfoById(int id)
	{
		HBaseDB db=HBaseDB.getInstance();
		Table tb=db.getTableByName("user");
		Get get=new Get(Bytes.toBytes(id));
		CustomerTO cto =new CustomerTO();
		try
		{
			Result rs=tb.get(get);
			cto.setEmail(Bytes.toString(rs.getValue(Bytes.toBytes("info"), Bytes.toBytes("email"))));
			cto.setId(id);
			cto.setName(Bytes.toString(rs.getValue(Bytes.toBytes("info"), Bytes.toBytes("name"))));
			cto.setPassword(Bytes.toString(rs.getValue(Bytes.toBytes("info"), Bytes.toBytes("password"))));
			cto.setUserName(Bytes.toString(rs.getValue(Bytes.toBytes("info"), Bytes.toBytes("username"))));
			tb.close();
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cto;
	}

	private int getIdByUsername(String username)
	{	
		HBaseDB db=HBaseDB.getInstance();
		Table tb=db.getTableByName("user");
		Get get=new Get(Bytes.toBytes(username));
		int id=0;
		try
		{
			Result rs=tb.get(get);
			id=Bytes.toInt(rs.getValue(Bytes.toBytes("id"), Bytes.toBytes("id")));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	@Test
	public ActivityTO getMovieRating(int userId,int movieId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		ActivityTO ato = new ActivityTO();
		ActivityDAO adao=new ActivityDAO();
		Get get = new Get(Bytes.toBytes(userId+"_rate_"+movieId));
		get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"));
		Result rs=tb.get(get);
		int score =0;
		if(rs.getValue(Bytes.toBytes("info"), Bytes.toBytes("rate")) != null)
		{
			score =Bytes.toInt(rs.getValue(Bytes.toBytes("info"), Bytes.toBytes("rate")));
		}
		if(score>0)
		{
			ato=adao.getActivityTO(userId, movieId);
		}
		return ato;
	}
	public List<MovieTO> getMovies4CustomerByGenre(int userId,int genreId) throws IOException
	{
		return getMovies4CustomerByGenre(userId, genreId, MOVIE_MAX_COUNT);
	}

	private List<MovieTO> getMovies4CustomerByGenre(int userId, int genreId,
			int mOVIE_MAX_COUNT2) throws IOException
	{
		List<MovieTO> list = new ArrayList<MovieTO>();
        ActivityTO activityTO = null;
        GenreDao gdao=new GenreDao();
        
		
        list= gdao.getMoviesInfoByGenreId(genreId);
		return list;
	}
	public List<GenreMovieTO> getMovies4Customer(int userId,int maxcount,int gMax) throws NumberFormatException, IOException
	{
		List<GenreMovieTO> list = new ArrayList<GenreMovieTO>();
//		int genreId = 0;
		GenreDao gdao=new GenreDao();
//      String name = null;
//      GenreTO genreTO = null;
//      List<MovieTO> movieList = null;
//      int count = 0;
        HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(userId+"_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			if(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("genreid")) != null)
			{
				System.out.println("存在类别");
				int gId=Bytes.toInt(result.getValue(Bytes.toBytes("genre"), Bytes.toBytes("genreid")));
				//movieList= gdao.getMoviesInfoByGenreId(gId);
				GenreMovieTO gm = new GenreMovieTO();
				//gm.setMovieList(movieList);
				GenreTO gto =new GenreTO();
				gto.setId(gId);
				gto.setName(gdao.getGenreName(gId));
				gm.setGenreId(gId);
				gm.setGenreTO(gto);
				list.add(gm);
			}
			else
			{
				list = gdao.getRandomMovies();
				break;
				
			}
			
			
			//System.out.println(mto);
		}
		return list;
	}
	public void insertCustomerRating(int userId,int movieId,int score) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		Put put3 =new Put(Bytes.toBytes(userId+"_rate_"+movieId));
        put3.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(score));  
        tb.put(put3);
        tb.close();
        
	}
	public List<MovieTO> getMoviesByMood(int userId) throws IOException
	{
		ActivityDAO adao=new ActivityDAO();
		List<MovieTO> list = adao.getCommonPlayList();
		
		return list;
	}
	public static void main(String[] args) throws IOException{
		UserDAO udao=new UserDAO();
		System.out.println(udao.getMovieRating(1255601, 13).getRating());
	}

	public int getMovieRating2(int userId, int movieId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		Get get =new Get(Bytes.toBytes(userId+"_rate_"+movieId));
        get.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"));  
        Result result = tb.get(get);
        tb.close();
       
		return Bytes.toInt(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("rate")));
	}
}
