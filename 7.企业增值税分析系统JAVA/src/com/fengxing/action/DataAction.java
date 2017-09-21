package com.fengxing.action;

import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.fengxing.entity.PurchaseInDAO;
import com.fengxing.entity.SaleOutDAO;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DataAction extends ActionSupport 
{
	private PurchaseInDAO dao = new PurchaseInDAO();
	private SaleOutDAO dao2=new SaleOutDAO();
	
	
	private TreeMap<String, Integer> map=new TreeMap<String, Integer>();
	private TreeMap<String, Integer> map1=new TreeMap<String, Integer>();
	private TreeMap<String, Integer> map2=new TreeMap<String, Integer>();
	public TreeMap<String, Integer> getMap()
	{
		return map;
	}
	public void setMap(TreeMap<String, Integer> map)
	{
		this.map = map;
	}
	public String listArea() throws JSONException{  
		 org.hibernate.Transaction tra=dao.getSession().beginTransaction();
	     System.out.println("开启事务");
         map=dao.findA();  
        tra.commit();
    	dao.getSession().flush();
    	dao.getSession().close();
        System.out.println(JSONUtil.serialize(map));
        return SUCCESS;
          
    }
	public String listArea1() throws JSONException{  
		 org.hibernate.Transaction tra=dao2.getSession().beginTransaction();
	     System.out.println("开启事务");
        map1=dao2.findA();  
       tra.commit();
   	dao2.getSession().flush();
   	dao2.getSession().close();
       System.out.println(JSONUtil.serialize(map1));
       System.out.println(map1.get(String.valueOf(2)));
       return SUCCESS;
         
   }
	public String listArea2() throws JSONException{  
		 org.hibernate.Transaction tra=dao2.getSession().beginTransaction();
	     System.out.println("开启事务");
	     map1=dao2.findA();  
	     tra.commit();
	     dao2.getSession().flush();
	     dao2.getSession().close();
	     org.hibernate.Transaction tra1=dao.getSession().beginTransaction();
	     map=dao.findA();  
	     tra1.commit();
	     dao.getSession().flush();
	     dao.getSession().close();
	     int max=0,min=map.get(String.valueOf(1)),maxmonth=0,minmonth=0,sum=0;
	     int fmonth=0,fastd=0,decremonth=0,decre=0;
	     for(int i=1;i<(map.size())+1;i++)
	     { 
	    	 if(map.get(String.valueOf(i))>max)
	    	 {
	    		 max=map.get(String.valueOf(i));
	    		 maxmonth=i;
	    	 }
	    	 if(map.get(String.valueOf(i))<min)
	    	 {
	    		 min=map.get(String.valueOf(i));
	    		 minmonth=i;
	    	 }
	    	 if(i<12)
	    	 {
	    		 int k=fastd;
	    		 if(k<map.get(String.valueOf(i+1))-map.get(String.valueOf(i)))
	    		 {
	    			 fastd=map.get(String.valueOf(i+1))-map.get(String.valueOf(i));
	    			 fmonth=i+1;
	    		 }
	    	 }
	    	 if(i>1)
	    	 {
	    		 int k=decre;
	    		 if(k<map.get(String.valueOf(i-1))-map.get(String.valueOf(i)))
	    		 {
	    			 decre=map.get(String.valueOf(i-1))-map.get(String.valueOf(i));
	    			 decremonth=i;
	    		 }
	    	 }
	    	 sum+=map.get(String.valueOf(i));
	    	 
	     }
	     int max2=0,min2=map1.get(String.valueOf(1)),maxmonth2=0,minmonth2=0,sum2=0;
	     int fmonth2=0,fastd2=0,decremonth2=0,decre2=0;
	     for(int i=1;i<(map1.size())+1;i++)
	     { 
	    	 if(map1.get(String.valueOf(i))>max2)
	    	 {
	    		 max2=map1.get(String.valueOf(i));
	    		 maxmonth2=i;
	    	 }
	    	 if(map1.get(String.valueOf(i))<min2)
	    	 {
	    		 min2=map1.get(String.valueOf(i));
	    		 minmonth2=i;
	    	 }
	    	 if(i<12)
	    	 {
	    		 int k=fastd2;
	    		 if(k<map1.get(String.valueOf(i+1))-map1.get(String.valueOf(i)))
	    		 {
	    			 fastd2=map1.get(String.valueOf(i+1))-map1.get(String.valueOf(i));
	    			 fmonth2=i+1;
	    		 }
	    	 }
	    	 if(i>1)
	    	 {
	    		 int k=decre2;
	    		 if(k<map1.get(String.valueOf(i-1))-map1.get(String.valueOf(i)))
	    		 {
	    			 decre2=map1.get(String.valueOf(i-1))-map1.get(String.valueOf(i));
	    			 decremonth2=i;
	    		 }
	    	 }
	    	 sum2 +=map1.get(String.valueOf(i));
	    	 
	     }
	     //进项数据                                           销项数据项
	     map2.put("max", max);map2.put("max2", max2);
	     map2.put("min", min);map2.put("min2", min2);
	     map2.put("sum", sum);map2.put("sum2", sum2);
	     map2.put("maxmonth", maxmonth);map2.put("maxmonth2", maxmonth2);
	     map2.put("minmonth", minmonth);map2.put("minmonth2", minmonth2);
	     map2.put("fmonth", fmonth);map2.put("fmonth2", fmonth2);
	     map2.put("decremonth", decremonth);map2.put("decremonth2", decremonth2);
	     map2.put("decre", decre);map2.put("decre2", decre2);
	     map2.put("fastd", fastd);map2.put("fastd2", fastd2);
	     System.out.println(max);
	     System.out.println(JSONUtil.serialize(map2));
	     
      return SUCCESS;
        
  }
	
	public TreeMap<String, Integer> getMap1()
	{
		return map1;
	}
	public void setMap1(TreeMap<String, Integer> map1)
	{
		this.map1 = map1;
	}
	public TreeMap<String, Integer> getMap2()
	{
		return map2;
	}
	public void setMap2(TreeMap<String, Integer> map2)
	{
		this.map2 = map2;
	}  
}
