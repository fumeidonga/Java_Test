package test_java.test.yunsuanfu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test_java.test.kucun;

/**
 * 加减乘除赋值就算啦 我们来测试逻辑运算符 & 位运算符
 * 
 * @author david
 *
 */
public class Test {

	private static int test = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*new Object(){
			void show(){
				System.out.println("show run");				
			}
		}.show();
		
		Object obj = new Object(){
			void show(){
				System.out.println("show run");
			}
		};
		((Object) obj).show();*/
		
		/*new Thread(new Runnable(){  //匿名
			public void run(){
				System.out.println("runnable run");	
			}
		})
		{
			public void run(){
				System.out.println("subthread run");
			}
		}.start();*/
		int i = -1;
		
		System.out.println((5 >>> 2));


	}

	/*
	 * 逻辑运算
	 */
	private static void testAnd() {
		System.out.println("test > 5 && test < 7 " + (test > 5 && test < 7));
		System.out.println("test > 5 & test < 5 " + (test > 5 & test < 5));
	}

    protected int mGroupFlags;
    //100 0000 0000 0000 0000
    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000; 
    @org.junit.Test
    public void dispatchTouchEvent(){
    	test123();
    	requestDisallowInterceptTouchEvent(false);
    	test123();
    	requestDisallowInterceptTouchEvent(true);
    	test123();
    }
   
    public void test123(){
    	mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    	System.out.println(mGroupFlags);
    	
    	final boolean disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
    	if(!disallowIntercept) {
        	System.out.println("intercept");
    	} else {
        	System.out.println("do not intercept");
    	}
    	
    }
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    	System.out.println("before requestDisallow " + mGroupFlags);
    	if (disallowIntercept) {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } else {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        }
    	System.out.println("after requestDisallow " + mGroupFlags);
    }
    
	/*
	 * 位运算 "<<" 有符号左移 ">>" 有符号右移 ">>>" 无符号右移 "&" 位与 (只有1&1得1，其他得0) "|" 位或
	 * (只有0|0为0 ，其他为1) "~" 位非(反码) 即按位取反 "^" 位异或 (即 相同的为0 不同的为1) 1^1=0 0^0=0
	 * 1^0=1
	 */
	private static void testWei() {
		/**
		 * "~" 位非(反码) 4 的反码 0000 0000 0000 0000 0000 0000 0000 0100 
		 *             按位取反 1111 1111 1111 1111 1111 1111 1111 1011 
		 * 此时按位取反后的值为补码 现在需要换成二进制原码用来输出 先减1
		 *                   1111 1111 1111 1111 1111 1111 1111 1010 
		 *             然后取反 0000 0000 0000 0000 0000 0000 0000 0101
		 * 最后 输出接口要加上符号位 即 -5 (先取反 ，在减1也可以)
		 */
		System.out.println("~4 " + (~4));

		/**
		 * "&" 位与 (只有1&1得1，其他得0) 4 的补码 0000 0000 0000 0000 0000 0000 0000 0100 6
		 * 的补码 0000 0000 0000 0000 0000 0000 0000 0110 位与结果 0000 0000 0000 0000
		 * 0000 0000 0000 0100
		 */
		System.out.println("4&6 " + (4 & 6));

		/**
		 * "<<" 有符号左移 规律左移是基数乘以2的移位幂次方，比如3<<2则是3*2*2也就是3乘以2的2次幂
		 */
		System.out.println("3 << 3 " + (3 << 3));

		/**
		 * ">>" 有符号右移 规律左移是基数除以2的移位幂次方，比如3>>1则是3/2也就是3除以2的1次幂
		 */
		System.out.println("3 >> 1 " + (3 >> 1));

		/**
		 * ">>>" 无符号右移 无论高位是0还是1都补0
		 */
		System.out.println("3 >>> 1 " + (3 >>> 1));
	}

	@org.junit.Test
	public void testBreak() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
			if (i % 2 == 0) {
				
			} else {
				System.out.println("执行了break语句,跳出当前循环!");
				break;
			}
		}
	}

	private static void testContinue() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println("没有执行continue语句输出i=" + i);
			} else {
				System.out.println("执行了Continue语句,跳出当前循环!");
				continue;
			}
		}
	}

	private static void testReturn() {
		for (int i = 0; i < 10; i++) {
			System.out.println("执行了return语句,直接跳出了当前的testReturn方法!");
			return;
		}
		int[] intArray = { 1, 2, 3, 4, 5 };  
		String intArrayString = Arrays.toString(intArray);  
	}
	
	@org.junit.Test
	public void test(){

		System.out.println("0 << 30 " + (0 << 30));
		System.out.println("1 << 30 " + (1 << 30));
		System.out.println("2 << 30 " + (2 << 30));
	}

	/**
	 * for 循环最先判断的是中间的值，
	 */
	@org.junit.Test
	public void testFor(){

		for(int l = 0; l > 0; l++){
			System.out.println("l = " + l);
		}
		
		for(kucun k = null; k != null; k=k){

			System.out.println("k");
		}
		
		for(int i = 0; kk();  II(i)){
			System.out.println("i = " + i);
			i++;
			if(i == 10)
				break;
		}
	}
	public boolean kk(){
		System.out.println("kk");
		return true;
	}
	public int j(){
		System.out.println("J");
		return 5;
	}
	public int II(int i){
		System.out.println("II");
		return i++;
	}
	
	
	
	@org.junit.Test
	public void testshuxi(){
		String s = "穿越架空|宅斗";
		System.out.println("|");
		System.out.println(s.replaceAll("\\|"," | "));
		mDatas = new ArrayList<String>();
		mStringList = new ArrayList<String>();
		mDatas.addAll(mStringList);
		map = new HashMap<>();
		map.put(1, "123");
		map.put(2, 123);
		System.out.println(map.get(1) instanceof String);
		System.out.println(map.get(2) instanceof String);
		
	}
	
	List<String> mStringList;
	List<String> mDatas;

	Object object = null;
	Map<Integer, Object> map= null;
	
	@org.junit.Test
	public void testswitch(){
		String s = "dfdf";
		
		switch(s) {
		case "dfdf":
			System.out.println("1");
			//break;
		case "ddw1":
			System.out.println("2");
			//break;
		case "dde444":
			System.out.println("3");
			//break;
		default :
			if("dfdf".equals(s)){
				System.out.println("0");
				
				break;
			}
			System.out.println("4");
			break;
		}
	}
}
