package test_java.test.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class Test {

	static String[] dd = new String[]{
			"2016/12/13 14:55:00",
			"2016/12/13 14:52:00",
			"2016/12/13 14:56:00",
			"2017/01/23 17:01:00",
			"2017/01/13 13:37:00",
			"2017/01/12 16:14:00",
			"2017/01/16 14:13:00",
			"2017/01/05 13:55:00",
			"2017/01/11 14:32:00",
			"2017/01/03 16:54:00",
			"2017/01/17 10:47:00",
			"2017/02/08 10:00:00",
			"2016/12/28 17:56:00",
			"2016/12/19 11:53:00",
			"2017/01/19 16:17:00",
			"2017/01/17 10:46:00",
			"2016/09/14 17:33:00",
			"2016/09/14 17:33:00",
			"2016/09/14 17:33:00",
			"2017/01/16 14:12:00",
			"2017/01/16 14:15:00",
			"2017/01/13 13:33:00",
			"2017/01/13 13:30:00",
			"2017/01/13 13:35:00",
			"2016/11/18 14:15:00",
			"2017/01/04 09:38:00",
			"2017/01/13 12:10:00"



	};
	
	@org.junit.Test
	public void test() throws ParseException{
//		sTstring(1479293776);
//		stringTs("2016/11/16 18:56:16");
		for(int i=0; i < dd.length; i++){

			stringTs(dd[i]);
		}
	}
	
	
	//"08/31/2006 21:08:00"格式的String转换java.util.Date类型
	////继续转换得到秒数的long型
	public long stringTs(String sDt) throws ParseException{
		//String sDt = "08/31/2006 21:08:00";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dt2 = sdf.parse(sDt);
		//继续转换得到秒数的long型
		long lTime = dt2.getTime() / 1000;
		System.out.println(lTime);
		return lTime;
	}
	
//		由long类型转换成Date类型
	public void sTstring(long lSysTime1 ){
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		java.util.Date dt = new Date(lSysTime1 * 1000);  
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
		 
	}
	
	//java.util.Date类型转换成long类型
	public long date(){
		java.util.Date dt = new Date();
		System.out.println(dt.toString());   //java.util.Date的含义
		long lSysTime1 = dt.getTime() / 1000;   //得到秒数，Date类型的getTime()返回毫秒数
		return lSysTime1;
	}
}
