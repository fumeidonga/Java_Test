package test_java.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class test1 {

	@Test
	public void testq() {

		int store_id = -1;
		try {
			store_id = Integer.parseInt("11");
		} catch (Exception e) {
			store_id = -1;
			System.out.println(e);
		}
		System.out.println(store_id);
		
		Map map = new HashMap<>();
		map.put("test",	"111");
		
		map.put("test",	"111");
		System.out.println(map.get("test"));
	}

	@Test
	public void test(){
		ProtocolBaseParameter parameter = new ProtocolBaseParameter();
		String par = JSON.toJSONString(parameter);
		// 发送消息给服务器
		ProtocolMsg msg = new ProtocolMsg();
		ProtocolHeader protocolHeader = new ProtocolHeader();
		//protocolHeader.setMagic(magic);
		protocolHeader.setMsgType((byte) 0x04);
		protocolHeader.setReserve((short) 0);
		protocolHeader.setSn((short) 0);

		byte[] bodyBytes1 = par.getBytes(Charset.forName("utf-8"));
		int bodySize1 = bodyBytes1.length;
		protocolHeader.setLen(bodySize1);

		msg.setProtocolHeader(protocolHeader);
		msg.setBody(par);
		
		System.out.println("sendMsg " + msg);// 序列化
		
		String jsonStr = JSON.toJSONString(msg);
		System.out.println("sendMsg " + jsonStr);
		
		
		ProtocolHeader header = msg.getProtocolHeader();
		String body = msg.getBody();
		byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
		int bodySize = bodyBytes.length;
		
		ByteBuffer out = ByteBuffer.allocate(bodySize+10);
		// 1.写入消息的开头的信息标志(byte类型) 
		out.put(header.getMagic());
		// 2.写入消息的类型
		out.put(header.getMsgType());
		// 3.写入消息的
		out.putShort(header.getReserve());
		// 4.写入消息的
		out.putShort(header.getSn());
		// 5.写入消息的长度(int 类型)
		out.putInt(bodySize);
		// 6.写入消息的内容
		out.put(bodyBytes, 10, bodySize);
		System.out.println(decode(out));
	}
	
	public  String decode(ByteBuffer buffer)
	{
		System.out.println( " buffer= "   +  buffer);
		Charset charset  =   null ;
		CharsetDecoder decoder  =   null ;
		CharBuffer charBuffer  =   null ;
		try 
		{
			charset  =  Charset.forName( "utf-8" );
			decoder  =  charset.newDecoder();
			// charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空  
			charBuffer = decoder.decode(buffer.asReadOnlyBuffer());  
			buffer.flip();
			System.out.println( " charBuffer= "   +  charBuffer);
			System.out.println(charBuffer.toString());
			return  charBuffer.toString();
		} 
		catch  (Exception ex)
		{
			ex.printStackTrace();
			return   "" ;
		} 
	}
	
	@Test
	public void tes2t(){
		byte[] head = new byte[] { 0x7e };   
		byte[] type = new byte[] { 0x00 };
		

		ProtocolHeader protocolHeader = new ProtocolHeader();
		protocolHeader.setMagic((byte) 0x01);
		protocolHeader.setMsgType((byte) 0x05);
		protocolHeader.setReserve((short) 0);
		protocolHeader.setSn((short) 0);
		
		ProtocolBaseParameter parameter = new ProtocolBaseParameter();
		parameter.setmDateTime("");
		parameter.setmEndTime("");
		parameter.setmMemberId(0);
		parameter.setmPageNumber(1);
		parameter.setmPageSize(0);
		parameter.setmPassWord("");
		parameter.setmStoreId(2);
		String par = JSON.toJSONString(parameter);
		
		
		ProtocolMsg msg = new ProtocolMsg();
		msg.setProtocolHeader(protocolHeader);
		msg.setBody(par);
		
		ProtocolBaseParameter parameterobj = JSON.parseObject(msg.getBody(), ProtocolBaseParameter.class);
		
		
		System.out.println(parameterobj);
		
	}
	@Test
	public void tet() {

		String event_key = "last_trade_no_42";
		int store_id = -1;
		try {
			event_key = event_key.substring(event_key.lastIndexOf("_")+1);
			System.out.println("event_key " + event_key);

			store_id = Integer.parseInt(event_key);
		} catch (Exception e) {
			store_id = -1;
			System.out.println(e.toString());
		}
		System.out.println("store_id " + store_id);
	}

	public static void main(String[] args) {
		String extraItem1 = "2-1436";
		String extraItem2 = "2-1250,2-1251";
		String[] contacts = extraItem1.split(",");
		String[] contacts2 = extraItem2.split(",");
		if (contacts.length >= 1) {
			for (String contact : contacts) {
				// System.out.println(contact);
			}
		}
		if (contacts2.length >= 1) {
			for (String contact1 : contacts2) {
				// System.out.println(contact1);
			}
		}
		String extraItem3 = "http ://:5";
		// System.out.println(extraItem3.indexOf(":"));
		// String string = extraItem3.substring(0, 2);
		// String string2 = extraItem3.substring(0, 2);
		// System.out.println(string);
		// System.out.println(string);
		String[] contacts3 = extraItem3.split(":", 2);
		if (contacts3.length >= 1) {
			for (String contact2 : contacts3) {
				System.out.println(contact2);
			}
		}

	}

	@Test
	public void testdd() {
		Person yPerson = new Person("5");
		Person oPerson = new Person("100");

		swapAge(yPerson, oPerson);// 能成功交换年龄吗？
		System.out.println("yPerson.age=" + yPerson.getAge());
		System.out.println("oPerson.age=" + oPerson.getAge());

		changeAge(oPerson);// 更改后的年龄是多少了？
		System.out.println("oPerson.age=" + oPerson.getAge());
	}

	private static void swapAge(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

	private static void changeAge(Person person) {
		person.setAge("5");
		person = new Person("30");
		person.setAge("40");
	}

	static class Person {
		private String age;

		public Person(String age) {
			this.age = age;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
	}

	@Test
	public void testFor() {
		// 死循环哦
		for (;;) {
			System.out.println("=-=-=");
		}
	}

	@Test
	public void testDi() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// System.out.println("" + i + j);
			}
		}
		print("", 2);
		// 00
		// 01
		// 02
		// 10
		// 11
		// 12
		// 20
		// 21
		// 22
	}

	public void print(String result, int depth) {
		for (int i = 0; i < 3; i++) {
			result += i;
			if (depth == 1) {
				System.out.println(result);
			} else {
				print(result, depth - 1);
			}
			result = result.substring(0, result.length() - 1);

		}
	}

	@Test
	public void test10() {

		double count = 1000;
		double initialize = 10;
		double resultMoney = 0;

		while (initialize < 19 && count > 0) {
			initialize += initialize * 0.1;
			resultMoney += 200 * initialize;
			count -= 200;
			System.out.println(count);
			System.out.println(initialize);
			System.out.println(resultMoney);
		}

		/**
		 * 10000 / 1000 / 0 7800 / 800 / 2200 9.75
		 */

	}

	double resultMoney = 10000;
	double gujia = 10;

	double atlastMoney;
	int haveNo = (int) (resultMoney / gujia);

	int salesNo = 400;
	int atlastNo;

	double zhongjianMoney;

	double zhangbaifenbi = 0.1;

	@Test
	public void test11() {

		gujia += gujia * zhangbaifenbi;

		System.out.println(" 涨了后的 gujia " + gujia);
		atlastNo = (haveNo - salesNo);
		zhongjianMoney = salesNo * gujia;

		System.out.println(" 减仓后余额 " + zhongjianMoney);

		atlastMoney = atlastNo * gujia + zhongjianMoney;

		System.out.println(" 减仓后余额 + 市值 " + atlastMoney);

		// 再涨一个百分比
		gujia += gujia * zhangbaifenbi;
		System.out.println(" 涨了后的 gujia2 " + gujia);
		atlastNo = (haveNo - salesNo);
		zhongjianMoney = salesNo * gujia;

		System.out.println(" 减仓后余额 2 " + zhongjianMoney);

		atlastMoney = atlastNo * gujia + zhongjianMoney;

		System.out.println(" 减仓后余额 + 市值2  " + atlastMoney);

		//
		gujia = (resultMoney - zhongjianMoney) / atlastNo;

		System.out.println(" 跌到不亏的最低的 gujia " + gujia);

	}

	/**
	 * IO操作的线程 为处理器核数的两倍
	 */
	private static final int IO_MAX_THREAD = Runtime.getRuntime().availableProcessors() * 2;

	/**
	 * 定长线程池 执行顺序不定 io计算
	 **/
	private static ExecutorService ioCalculateExecutor = Executors.newSingleThreadExecutor();

	@Test
	public void test13() {
		// {"cost":0.009000000543892384,"data":{"error":{"note":"客户端无权播放,201","code":-603}},"e":{"code":0,"provider":"hsfprovider","desc":""}}
		// XMjgzNDk2ODk4MA
		// String url =
		// "http://play.youku.com/play/get.json?vid=XMjgzNDk2ODk4MA==&ct=10&pwd=";
		String url = "http://play.youku.com/play/get.json?vid=XMjgyODY5MTAzNg==&ct=10&pwd=";

		final String filePath = "C:\\Users\\david\\Desktop\\wpa2pojiezidian\\(401W-500W).txt";
		final ArrayList<String> kucuns = ReadFromExcel.readTxtFile(filePath);
		System.out.println(kucuns.size());
		int i = 0;
		for (String string : kucuns) {
			i++;
			boolean hasSymble = !string.matches("^[\\da-zA-Z]*$");
			String regex3 = "^[A-Z]+$";
			boolean hasSymble3 = string.matches(regex3);
			if (hasSymble3 && !hasSymble && string.length() > 5 && !equalStr(string) && !isOrderNumeric(string) && !isOrderNumeric_(string) && isddd(string)) {
				System.out.println("第 " + i + " 次  string= " + string);
				String passw = md5(string, true);
				String sb = sendGet(url + passw + "&ran=437", "");
				if (sb.contains("客户端无权播放")) {
					System.out.println("============pass========== " + string);
					break;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String md5(String str, boolean zero) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
		byte[] resultByte = messageDigest.digest(str.getBytes());
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < resultByte.length; ++i) {
			int v = 0xFF & resultByte[i];
			if (v < 16 && zero)
				result.append("0");
			result.append(Integer.toHexString(v));
		}
		return result.toString();
	}

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public String sendGet(String url, String param) {
		StringBuffer result = new StringBuffer();
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			/*
			 * for (String key : map.keySet()) { System.out.println(key + "--->"
			 * + map.get(key)); }
			 */
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		String sb = result.toString();
		return sb;
	}

	/**
	 * 判断一段字符串里是否有除了数字和字母以外的字符
	 */
	@Test
	public void test14() {
		String str0 = "aaaa1a";
		String str1 = "aaaaA";
		String str2 = "111111";
		String str3 = "AAAa";
		String regex0 = "^[\\da-zA-Z]*$";
		String regex1 = "^[a-z]+$";
		String regex2 = "^[0-9]+$";
		String regex3 = "^[A-Z]+$";
		boolean hasSymble0 = str0.matches(regex0);
		boolean hasSymble1 = str1.matches(regex1);
		boolean hasSymble2 = str2.matches(regex2);
		boolean hasSymble3 = str3.matches(regex3);
		System.out.println(hasSymble0);
		System.out.println(hasSymble1);
		System.out.println(hasSymble2);
		System.out.println(hasSymble3);
		
		System.out.println(isddd("11q1111"));
	}
	
	public static boolean isddd(String dddd){
		boolean flag = true;
		String regex1 = "^[a-z]+$";
		String regex2 = "^[0-9]+$";
		String regex3 = "^[A-Z]+$";
//		boolean hasSymble0 = str.matches(regex0);
		boolean hasSymble1 = dddd.matches(regex1);
		boolean hasSymble2 = dddd.matches(regex2);
		boolean hasSymble3 = dddd.matches(regex3);
		flag = hasSymble1 || hasSymble2 || hasSymble3;
		return !flag;
	}

	// 不能全是相同的数字或者字母（如：000000、111111、aaaaaa） 全部相同返回true
	public static boolean equalStr(String numOrStr) {
		boolean flag = true;
		char str = numOrStr.charAt(0);
		for (int i = 0; i < numOrStr.length(); i++) {
			if (str != numOrStr.charAt(i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	// 不能是连续的数字--递增（如：123456、12345678）连续数字返回true
	public static boolean isOrderNumeric(String numOrStr) {
		boolean flag = true;// 如果全是连续数字返回true
		boolean isNumeric = true;// 如果全是数字返回true
		for (int i = 0; i < numOrStr.length(); i++) {
			if (!Character.isDigit(numOrStr.charAt(i))) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {// 如果全是数字则执行是否连续数字判断
			for (int i = 0; i < numOrStr.length(); i++) {
				if (i > 0) {// 判断如123456
					int num = Integer.parseInt(numOrStr.charAt(i) + "");
					int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") + 1;
					if (num != num_) {
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	// 不能是连续的数字--递减（如：987654、876543）连续数字返回true
	public static boolean isOrderNumeric_(String numOrStr) {
		boolean flag = true;// 如果全是连续数字返回true
		boolean isNumeric = true;// 如果全是数字返回true
		for (int i = 0; i < numOrStr.length(); i++) {
			if (!Character.isDigit(numOrStr.charAt(i))) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {// 如果全是数字则执行是否连续数字判断
			for (int i = 0; i < numOrStr.length(); i++) {
				if (i > 0) {// 判断如654321
					int num = Integer.parseInt(numOrStr.charAt(i) + "");
					int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") - 1;
					if (num != num_) {
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}
	
	@Test
	public void isfff(){
		String str = "kkkkkk8888888shioobo666";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			int sum = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					sum++;
			}
			map.put(str.charAt(i), sum);
		}
		for (Map.Entry<Character, Integer> me : map.entrySet()){
			
			if ((Integer) me.getValue() > 1){
				
				System.out.println("重复字母：" + me.getKey() + "重复次数：" + me.getValue());
			}
		}
		//return false;
		 String str1 = "ab9871";
    	 boolean ll = hasLH1(str1, 3);
    	 System.out.println(ll);
	}
	
	
	 public static boolean matcher(String input)  
	    {  
	        //创建一个List   
	        List<String> list = new ArrayList<String>();  
	        //创建匹配的模式  
	        Pattern pattern = Pattern.compile("(.)\\1*");  
	        //匹配器  
	        Matcher matcher = pattern.matcher(input);  
	        //查找与该模式匹配的子序列。从"+kkkhan888shioobo66" 里面 查找出 与 此模式 "(.)\\1*"  相匹配的 子序列。如果存在，返回true，如果不存在，返回false.  
	        while (matcher.find())  
	        {    
	            //返回匹配的子序列，并加入到list里面。  
	        	if(matcher.group().length() >2)
	            list.add(matcher.group());  
	        }  
	        System.out.println(list);  
	        //对分好组的List，进行排序。根据指定比较器产生的顺序对指定列表进行排序。把重复的序列排在前面。  
	        /*Collections.sort(list, new Comparator<String>()  
	        {  
	            public int compare(String o1, String o2)  
	            {  
	                return o2.length() - o1.length();  
	            }  
	        });  
	        //找到连续重复的字符,加入到数组中。  
	        String[] strings = list.toArray(new String[0]);  
	        //找出连续并且重复的子序列。并且把这些连续重复的子序列用空字符串替换。  
	        for(int i=0 ;i<=strings.length-1;i++){  
	            if(strings[i].length()>1){  
	                System.out.println(strings[i]);  
	                input=input.replace(strings[i],"");  
	                System.out.println(input);  
	            }  
	        }  
	        System.out.println("最终结果："+input);  */
	        //返回把连续重复的字符赐除掉的字符序列。  
	        if(list.size() > 0)
	        return true;  
	        else return false;
	    } 
	 //.判断字符串是否是连续字母或者是连续的数字可以用截取字符串然后比较ascii码的值判断连续的次数 顺序
	 public static boolean hasLH(String str,int count) {
			int pre = 0;
			int len = 1;
			for (int i = 0; i < str.length(); i++) {
				String s = str.substring(i, i + 1);
				char c = s.charAt(0);
				if (i == 0) {
					pre = c;
				}
				if (c - 1 == pre) {
					len++;
					if(len>=count){
						return true;
					}
				}else {
					len = 1;
				}
				pre = c;
			}
			return false;
		}
	 //.判断字符串是否是连续字母或者是连续的数字可以用截取字符串然后比较ascii码的值判断连续的次数  倒叙
	 public static boolean hasLH1(String str,int count) {
			int pre = 0;
			int len = 1;
			for (int i = 0; i < str.length(); i++) {
				String s = str.substring(i, i + 1);
				char c = s.charAt(0);
				if (i == 0) {
					pre = c;
				}
				if (c + 1 == pre) {
					len++;
					if(len>=count){
						return true;
					}
				}else {
					len = 1;
				}
				pre = c;
			}
			return false;
		}
	 
	 @Test
	 public void telist(){

			List<kucun> kucuns = new ArrayList<>();
			for(int i = 0; i < 3; i++){
				kucun k = new kucun();
				k.setCode(i + " i");
				k.setNum("i " + i);
				kucuns.add(k);
			}

			for(kucun o : kucuns){
				System.out.println(o);
			}
			
			kucun k = new kucun();
			k.setCode(1 + " i");
			k.setNum("i " + 1);
			
			System.out.println(kucuns.indexOf(k));
			k.setCode(5 + " set");
			kucuns.set(1, k);
			
			for(kucun o : kucuns){
				System.out.println(o);
			}
			
	 }

}
