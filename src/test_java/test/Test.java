package test_java.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Test {

	public static String s = "{\"data\":{\"banners\":[{\"id\":\"测试内容s6id\",\"image_url\":\"测试内容7xg6\",\"link_url\":\"测试内容r7sh\",\"type\":\"测试内容o1x7\"}],\"cash\":\"测试内容t84l\",\"coin\":\"测试内容mh8i\",\"id\":\"测试内容s0p6\",\"title\":\"测试内容6n45\",\"today_read_duration\":\"测试内容2f57\",\"type\":\"my_centers\",\"user_entrances\":[{\"button_title\":\"测试内容568j\",\"callback_url\":\"测试内容8k77\",\"first_title\":\"测试内容51pv\",\"icon_url\":\"测试内容r574\",\"id\":\"1\",\"link_type\":\"测试内容3661\",\"link_url\":\"测试内容a2r5\",\"second_title\":\"测试内容y47u\",\"show_type\":\"2\",\"statistical_code\":\"测试内容1xir\",\"type\":\"测试内容6914\"},{\"button_title\":\"测试内容568j\",\"callback_url\":\"测试内容8k77\",\"first_title\":\"测试内容51pv\",\"icon_url\":\"测试内容r574\",\"id\":\"2\",\"link_type\":\"测试内容3661\",\"link_url\":\"测试内容a2r5\",\"second_title\":\"测试内容y47u\",\"show_type\":\"3\",\"statistical_code\":\"测试内容1xir\",\"type\":\"测试内容6914\"},{\"button_title\":\"测试内容568j\",\"callback_url\":\"测试内容8k77\",\"first_title\":\"测试内容51pv\",\"icon_url\":\"测试内容r574\",\"id\":\"3\",\"link_type\":\"测试内容3661\",\"link_url\":\"测试内容a2r5\",\"second_title\":\"测试内容y47u\",\"show_type\":\"1\",\"statistical_code\":\"测试内容1xir\",\"type\":\"测试内容6914\"},{\"button_title\":\"测试内容568j\",\"callback_url\":\"测试内容8k77\",\"first_title\":\"测试内容51pv\",\"icon_url\":\"测试内容r574\",\"id\":\"4\",\"link_type\":\"测试内容3661\",\"link_url\":\"测试内容a2r5\",\"second_title\":\"测试内容y47u\",\"show_type\":\"1\",\"statistical_code\":\"测试内容1xir\",\"type\":\"测试内容6914\"},{\"button_title\":\"测试内容568j\",\"callback_url\":\"测试内容8k77\",\"first_title\":\"测试内容51pv\",\"icon_url\":\"测试内容r574\",\"id\":\"5\",\"link_type\":\"测试内容3661\",\"link_url\":\"测试内容a2r5\",\"second_title\":\"测试内容y47u\",\"show_type\":\"1\",\"statistical_code\":\"测试内容1xir\",\"type\":\"测试内容6914\"},{\"button_title\":\"测试内容568j\",\"callback_url\":\"测试内容8k77\",\"first_title\":\"测试内容51pv\",\"icon_url\":\"测试内容r574\",\"id\":\"6\",\"link_type\":\"测试内容3661\",\"link_url\":\"测试内容a2r5\",\"second_title\":\"测试内容y47u\",\"show_type\":\"1\",\"statistical_code\":\"测试内容1xir\",\"type\":\"测试内容6914\"}]}}";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//stringFan();
		//printInt("aq出字符串");

		/*try {
			URLEncoder.encode(null, "utf-8");
			System.out.println(URLEncoder.encode("", "utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*String string = "fs:/qrcode2017/06/21/1498044268.jpg";

		String dir = string.substring(4, string.lastIndexOf("/")+1);
		String filename = string.substring(string.lastIndexOf("/")+1);
		System.out.println(dir);
		System.out.println(filename);*/
		
		//System.out.println("1".equals(null));
		
		System.out.println(s.replaceAll("测试内容", ""));
		
		System.out.println(false && false);
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		
	}


	/**
	 * 字符串反转
	 * .调用StringBuffer直接反转 
	 */
	public static void stringFan() {
		String string = "123456789";
		StringBuffer b = new StringBuffer(string);
		b = b.reverse();
		System.out.println(b.toString());

		byte[] by = string.getBytes();
		for (int i = 0; i < by.length; i++) {
			System.out.println(by[i]);
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 字符串二分
	 */
	public static String reverse1(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String left = s.substring(0, length / 2);
		String right = s.substring(length / 2, length);
		return reverse1(right) + reverse1(left);
	}

	/**
	 * 
	 * @param s
	 * @return
	 * charAt
	 */
	public static String reverse2(String s) {
		int length = s.length();
		String reverse = "";
		for (int i = 0; i < length; i++)
			reverse = s.charAt(i) + reverse;
		return reverse;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * toCharArray
	 */
	public static String reverse3(String s) {
		char[] array = s.toCharArray();
		String reverse = "";
		for (int i = array.length - 1; i >= 0; i--)
			reverse += array[i];
		return reverse;
	}

	public static String reverse5(String orig) {
		char[] s = orig.toCharArray();
		int n = s.length - 1;
		int halfLength = n / 2;
		for (int i = 0; i <= halfLength; i++) {
			char temp = s[i];
			s[i] = s[n - i];
			s[n - i] = temp;
		}
		return new String(s);
	}

	/**
	 * 
	 * @param s
	 * @return
	 * 异或（^）
	 */
	public static String reverse6(String s) {

		char[] str = s.toCharArray();
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end) {
			str[begin] = (char) (str[begin] ^ str[end]);
			str[end] = (char) (str[begin] ^ str[end]);
			str[begin] = (char) (str[end] ^ str[begin]);
			begin++;
			end--;
		}
		return new String(str);
	}

	/**
	 * 
	 * @param s
	 * @return
	 * java Stack堆栈
	 */
	public static String reverse7(String s) {
		char[] str = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length; i++)
			stack.push(str[i]);

		String reversed = "";
		for (int i = 0; i < str.length; i++)
			reversed += stack.pop();
		return reversed;
	}

	public static int printInt(String param) {// 返回换算后的int值

		int result = 0;
		int x;
		int z = 1;
		int length = param.length();
		System.out.println("输出字符串:" + param);
		for (int p = 0; p < param.length(); p++) {
			System.out.println("输出字符串中" + p + "字符:" + param.charAt(p));
			x = (int) param.charAt(p);
			for (int t = 1; t < length; t++) {
				z = z * 26;
			}
			length--;
			result = result + x * z;
		}

		return result;
	}
	
	@org.junit.Test
	public void testFor(){
		int i = 0;
		for(foo("A"); foo("B") && (i < 2); foo("C")){
			i ++;
			System.out.println("D");
		}
		
	}
	
	public boolean foo(String s){
		System.out.println(s);
		return true;
	}

	public String send_template_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	public String TEMPLATE_ALL_LIST = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
	
	@org.junit.Test
	public void test333(){
		send_template_url = send_template_url + "123";
		System.out.println(send_template_url);
		System.out.println(TEMPLATE_ALL_LIST.replace("ACCESS_TOKEN", "235"));
	}

	@org.junit.Test
	public void testParams(){
//		testp("1", null);
		testp("2","3");
		//testp("");

		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
	    int day = cal.get(Calendar.DATE);
	    int month = cal.get(Calendar.MONTH) + 1;
	    String todayTime = year + "-" + month+"-"+day;
	    
		testp(todayTime, null);
		testp(dateFormat.format(new Date()), null);*/
		
	    
	}
	
	public void testp(String...params){
		System.out.println("-------params.length ----------" + params.length);
		for (String string : params) {
			System.out.println(string);
		}
	}

	@org.junit.Test
	public void testSocket() throws Exception {
		
		Socket socket = new Socket("192.168.100.142", 8787); 
		System.out.println(socket);
	    
	}
	Integer[] arr = new Integer[] {  1,4,6,9};
	
	public static boolean useArraysBinarySearch(Integer[] arr, int targetValue) { 
	    int a =  Arrays.binarySearch(arr, targetValue);
	    if(a > 0)
	        return true;
	    else
	        return false;
	}
	
	public static boolean useLoop(Integer[] arr, int targetValue) {
	    for(int s: arr){
	        if(s == targetValue)
	            return true;
	    }
	    return false;
	}
	
	@org.junit.Test
	public void testkkk(){
		long startTime = System.nanoTime();
		useArraysBinarySearch(arr, 6);
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println("useList:  " + duration / 1000000);
	    
	    List<Integer> list = new ArrayList();
	    list.add(1);
	    list.add(3);
	    list.add(4);
	    System.out.println(list.contains(1));
	    System.out.println(list.contains(2));
	    System.out.println(list.contains(3));
	}
}
