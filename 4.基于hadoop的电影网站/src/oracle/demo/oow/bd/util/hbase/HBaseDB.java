package oracle.demo.oow.bd.util.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseDB
{
	private Connection conn;
	private static HBaseDB db=null;
	public static HBaseDB getInstance()
	{
		if(db==null)
		{	
			db=new HBaseDB();
			return db;
		}
		else
			return db;
	}
	private HBaseDB()
	{
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "localhostGkt");
		conf.set("hbase.rootdir", "hdfs://localhostGkt:9000/hbase");
		try {
			conn = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void createTable(String tableName,String[] columnFamily)
	{
		try
		{
			//Table table = conn.getTable(TableName.valueOf(tableName));
			Admin admin=conn.getAdmin();
			HTableDescriptor hd=new HTableDescriptor(TableName.valueOf(tableName));
			for(String cf:columnFamily)
			{
				HColumnDescriptor hcd=new HColumnDescriptor(Bytes.toBytes(cf));
				hd.addFamily(hcd);
			}
			admin.createTable(hd);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteTable(String tablename)
	{
		try
		{
			Admin admin=conn.getAdmin();
			admin.disableTable(TableName.valueOf(tablename));
			admin.deleteTable(TableName.valueOf(tablename));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Table getTableByName(String name)
	{
		try
		{
			Table tb=conn.getTable(TableName.valueOf(name));
			return tb;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close()
	{
		try
		{
			conn.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
