package oracle.demo.oow.bd.dao.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import oracle.demo.oow.bd.pojo.ActivityType;
import oracle.demo.oow.bd.pojo.RatingType;
import oracle.demo.oow.bd.to.ActivityTO;
import oracle.demo.oow.bd.to.MovieTO;
import oracle.demo.oow.bd.util.FileWriterUtil;
import oracle.demo.oow.bd.util.hbase.HBaseDB;

public class ActivityDAO
{
	/*
	 * 可能出现的错误：删除视频记录时
	 */
	public void insertCustomerActivity(ActivityTO activityTO) throws IOException
	{
		HBaseDB db=HBaseDB.getInstance();
		Table table = db.getTableByName("user");
		Table tb = db.getTableByName("activity");
		Table gid = db.getTableByName("gid");
		long cnt1 = gid.incrementColumnValue(Bytes.toBytes("activityId"), 
				  Bytes.toBytes("gid"), Bytes.toBytes("aid"), 1);

		if(tb!=null)
		{
			Put put=new Put(Bytes.toBytes(cnt1));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("user_id"), Bytes.toBytes(activityTO.getCustId()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("movie_id"), Bytes.toBytes(activityTO.getMovieId()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("genre_id"), Bytes.toBytes(activityTO.getGenreId()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("activity"), Bytes.toBytes(activityTO.getActivity().getValue()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("rating"), Bytes.toBytes(activityTO.getRating().getValue()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("time"), Bytes.toBytes(activityTO.getFormattedTime()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("price"), Bytes.toBytes(activityTO.getPrice()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("recommended"), Bytes.toBytes(activityTO.isRecommended().toString()));
			put.addColumn(Bytes.toBytes("activity"), Bytes.toBytes("position"), Bytes.toBytes(activityTO.getPosition()));
			tb.put(put);
		}
		int custId = 0;
        int movieId = 0;
        ActivityType activityType = null;
        String jsonTxt = null;

        

        if (activityTO != null) {
            jsonTxt = activityTO.getJsonTxt();
            System.out.println("User Activity| " + jsonTxt);
            
                     
                
            /**
             * This system out should write the content to the application log
             * file.
             */
            FileWriterUtil.writeOnFile(activityTO.getActivityJsonOriginal().toString());
            
            custId = activityTO.getCustId();
            movieId = activityTO.getMovieId();

            if (custId > 0 && movieId > 0) {
                activityType = activityTO.getActivity();

                switch (activityType) {
                case STARTED_MOVIE:
                    //insert movie entry into customer's currently watching list
                    //key = KeyUtil.getCustomerCurrentWatchListKey(custId, movieId,activityTable);
                    Put put =new Put(Bytes.toBytes(custId+"_current_"+movieId));
                    put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("movieid"), Bytes.toBytes(movieId));  
                    table.put(put);
                    
                    //delete movie from the browse list
                    Delete delete = new Delete(Bytes.toBytes(custId+"_browse_"+movieId));
        			
        			
        			table.delete(delete);
                    //delete(new Key());
                    break;
                case PAUSED_MOVIE:
                    //update the current position of the movie into current watch list
                	Put put1 =new Put(Bytes.toBytes(custId+"_current_"+movieId));
                    put1.addColumn(Bytes.toBytes("info"), Bytes.toBytes("position"), Bytes.toBytes(activityTO.getPosition()));  
                    table.put(put1);
                    break;
                case COMPLETED_MOVIE:
                    //inset movie entry into historical play list
                	Put put2 =new Put(Bytes.toBytes(custId+"_history_"+movieId));
                    put2.addColumn(Bytes.toBytes("info"), Bytes.toBytes("movieid"), Bytes.toBytes(movieId));  
                    table.put(put2);
                    //delete movie entry from currently watching list
                    Delete delete1 = new Delete(Bytes.toBytes(custId+"_current_"+movieId));
        			table.delete(delete1);
                    break;
                case RATE_MOVIE:
                    //insert user rating for the movie in the CT_MV table
                	Put put3 =new Put(Bytes.toBytes(custId+"_rate_"+movieId));
                    put3.addColumn(Bytes.toBytes("info"), Bytes.toBytes("rate"), Bytes.toBytes(activityTO.getRating().getValue()));  
                    table.put(put3);
                    break;
                case BROWSED_MOVIE:
                    //insert browse information
                	Put put4 =new Put(Bytes.toBytes(custId+"_browse_"+movieId));
                    put4.addColumn(Bytes.toBytes("info"), Bytes.toBytes("movieid"), Bytes.toBytes(movieId));  
                    table.put(put4);
                    
                    
                    break;

                }
            } //if (custId > 0 && movieId > 0)

        } //if (activityTO != null)
	}
	public List<MovieTO> getCustomerCurrentWatchList(int userId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(userId+"_current_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			if(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("movieid")) != null)
			{
				//System.out.println(Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("movieid"))));
				String movieId=Bytes.toString(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("movieid")));
				MovieTO mto= mdao.getMovieInfoById(Integer.parseInt(movieId));
				list.add(mto);
			}
			
			//System.out.println(mto);
		}
		
		tb.close();
		return list;
	}
	public ActivityTO getActivityTO(int userId, int movieId) throws IOException
	{
		ActivityTO ato = new ActivityTO();
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("activity");
		List<Filter> filters = new ArrayList<Filter>();
		Scan scan = new Scan();
		Filter filter = new SingleColumnValueFilter(Bytes.toBytes("activity"), Bytes.toBytes("user_id"),
				CompareFilter.CompareOp.EQUAL, new SubstringComparator(Bytes.toString(Bytes.toBytes(userId))));
		((SingleColumnValueFilter) filter).setFilterIfMissing(true);

		Filter filter1 = new SingleColumnValueFilter(Bytes.toBytes("activity"), Bytes.toBytes("movie_id"),
				CompareFilter.CompareOp.EQUAL, new SubstringComparator(Bytes.toString(Bytes.toBytes(movieId))));
		((SingleColumnValueFilter) filter1).setFilterIfMissing(false);
		//System.out.println(ato);
		filters.add(filter1);
		filters.add(filter);
		FilterList filterList2 = new FilterList( FilterList.Operator.MUST_PASS_ALL, filters);
		scan.setFilter(filterList2);
		ResultScanner rs=tb.getScanner(scan);
		for(Result result:rs)
		{
			ato.setCustId(Bytes.toInt(result.getValue(Bytes.toBytes("activity"), Bytes.toBytes("user_id"))));
			int rating =new UserDAO().getMovieRating2(userId, movieId);
			RatingType rt=RatingType.NO_RATING;
			//System.out.println(rating);
			switch(rating){
			case 1:rt=RatingType.ONE;break;
			case 2:rt=RatingType.TWO;break;
			case 3:rt=RatingType.THREE;break;
			case 4:rt=RatingType.FOUR;break;
			case 5:rt=RatingType.FIVE;break;
			}
			ato.setRating(rt);
			ato.setMovieId(movieId);
			if(result.getValue(Bytes.toBytes("activity"), Bytes.toBytes("positon")) != null)
			{
				ato.setPosition(Bytes.toInt(result.getValue(Bytes.toBytes("activity"), Bytes.toBytes("positon"))));
			}
			
			//System.out.println(ato.getCustId());
		}
		tb.close();
		
		//System.out.println(ato.getRating());
		return ato;
	}
	public List<MovieTO> getCustomerBrowseList(int userId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(userId+"_browse_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			int movieId=Bytes.toInt(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("movieid")));
			MovieTO mto= mdao.getMovieInfoById(movieId);
			list.add(mto);
			//System.out.println(mto);
		}
		
		tb.close();
		
		return list;
	}
	public List<MovieTO> getCommonPlayList() throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("movie");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		FilterList flist =new FilterList();
		Filter f1=new PageFilter(25);
		Filter f2 =new RandomRowFilter(0.2f);
		flist.addFilter(f2);
		flist.addFilter(f1);
		scan.setFilter(flist);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			int movieId=Bytes.toInt(result.getValue(Bytes.toBytes("movie"), Bytes.toBytes("movieid")));
			MovieTO mto= mdao.getMovieInfoById(movieId);
			list.add(mto);
			//System.out.println(mto);
			
		}
		
		tb.close();
		MovieTO mto= mdao.getMovieInfoById(180);
		list.add(mto);
		Collections.sort(list);
		return list;
	}
	public List<MovieTO> getCustomerHistoricWatchList(int userId) throws IOException
	{
		HBaseDB db = HBaseDB.getInstance();
		Table tb = db.getTableByName("user");
		List<MovieTO> list =new ArrayList<MovieTO>();
		MovieDao mdao = new MovieDao();
		Scan scan = new Scan();
		Filter filter = new PrefixFilter(Bytes.toBytes(userId+"_history_"));
		scan.setFilter(filter);
		ResultScanner rs=tb.getScanner(scan);
		for (Result result : rs) {
			int movieId=Bytes.toInt(result.getValue(Bytes.toBytes("info"), Bytes.toBytes("movieid")));
			MovieTO mto= mdao.getMovieInfoById(movieId);
			list.add(mto);
			
		}
		
		tb.close();
		
		return list;
	}
	public static void main(String[] args) throws IOException
	{
		ActivityDAO adao=new ActivityDAO();
		adao.getActivityTO(1255601, 13);
	}
}
