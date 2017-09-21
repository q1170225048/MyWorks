package com.swz.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import com.swz.entity.Scor;

public class IDSC {

	public static int  SC(){
			int id=0;
		 Calendar calendar=Calendar.getInstance();
		 SimpleDateFormat smft=new SimpleDateFormat("MMddHHmmss");
		 String nowString=smft.format(calendar.getTime());
		 id=Integer.parseInt(nowString);
		 System.out.println(id);
     	 return id;
	}

	public static double  avrscor(List<Scor> list) {
		
		double toscor=0,avgscor=0;
		for (int index=0;index<list.size();index++) {
			
			toscor+=list.get(index).getScor();
		}
		if(list.size()>0)
		{
			avgscor=toscor/list.size();
		}
		return avgscor;
	}
	public static List<Scor> sortparam(List<Scor> list) 
	{
		System.out.println("开始排序");
		for(int i=list.size()-1;i>0;i--)
		{
			for(int j=0;j<i;++j)
			{
				if(list.get(j+1).getScor()<list.get(j).getScor())
				{
					list.add(j+1,list.get(j));
					list.add(j,list.get(j+2));
					list.remove(j+2);
					list.remove(j+2);
				}
			}
			
		}
		System.out.println("排序完成");
		return list;
	}
}
