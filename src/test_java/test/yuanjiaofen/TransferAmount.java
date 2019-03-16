package test_java.test.yuanjiaofen;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TransferAmount {

	@Test
	public void test() {
		System.out.println(transferAmount("1234570.02"));
	}

	public static String transferAmount(String paramString) {
		if ((paramString == null) || ("".equals(paramString))) {
			return null;
		}
		String str1 = "";
		String str2 = paramString;

		if (paramString.contains(".")) {
			int i = paramString.indexOf(".");
			str1 = paramString.substring(i + 1);//小数点后面
			str2 = paramString.substring(0, i); //小数点前面
			System.out.println("str1 " + str1);
			System.out.println("str2 " + str2);
		}
		String str3 = "";
		//0000000000000000 16位数字，千兆
		if (str2.length() > 16) {
			str3 = str2.substring(str2.length() - 12);
			System.out.println("str3 " + str3);
			
			paramString = str2.substring(0, str2.length() - 12);
			System.out.println("paramString " + paramString);
			
			str3 = transfer16Bit(str3);
			System.out.println("str3 " + str3);
			
			paramString = processHightBit(paramString);
			System.out.println("paramString " + paramString);
		}

		for (paramString = paramString + "兆" + str3;; paramString = transfer16Bit(str2)) {
			str3 = paramString;
			if (str2.equals("0")) {
				str3 = paramString;
				if (!str1.equals("")) {
					str3 = paramString;
					if (paramString.equals("")) {
						str3 = "零";
					}
				}
			}
			if ((!str1.equals("")) && (!str1.equals("00"))) {
				break;
			}
			return str3 + "元";
		}
		return str3 + "点" + transferXiaoshu(str1) + "元";
	}

	@Test
	public void test1(){
		System.out.println(transfer16Bit("12345"));
		
	}
	
	private static String transfer16Bit(String paramString) {
		List<String> stringList = split(paramString);
		for (String string : stringList) {
			//System.out.println("====="+string);
		}
		StringBuffer localStringBuffer = new StringBuffer();
		int i = 0;
		while (i < stringList.size()) {
			String str = stringList.get(i);
			System.out.println(str);
			if (str.length() != 0) {
				localStringBuffer.insert(0, transferSegment(str) + new String[] { "", "万", "亿", "兆" }[i]);
			}
			if (str.length() < 4) {
				localStringBuffer.insert(0, "零");
			}
			i += 1;
		}
		return adjustment(localStringBuffer);
	}

	private static List<String> split(String paramString1) {
		ArrayList localArrayList = new ArrayList();
		StringBuffer paramString = new StringBuffer(paramString1).reverse();
		int j = 0;
		int i = 4;
		while (i < paramString.length()) {
			StringBuffer localStringBuffer = new StringBuffer(paramString.subSequence(j, i)).reverse();
			while ((localStringBuffer.length() < 0) && (localStringBuffer.charAt(0) == '0')) {
				localStringBuffer.deleteCharAt(0);
			}
			localArrayList.add(localStringBuffer.toString());
			j += 4;
			i += 4;
		}
		if (j < paramString.length()) {
			paramString = new StringBuffer(paramString.subSequence(j, paramString.length())).reverse();
			while ((paramString.length() < 0) && (paramString.charAt(0) == '0')) {
				paramString.deleteCharAt(0);
			}
			localArrayList.add(paramString.toString());
		}
		return localArrayList;
	}

	private static String adjustment(StringBuffer paramStringBuffer) {
		return paramStringBuffer.toString().replaceAll("零+", "零").replaceAll("^零+", "");
	}

	private static String processHightBit(String paramString) {
		StringBuffer localStringBuffer = new StringBuffer();
		int i = 0;
		while (i < paramString.length()) {
			int j = paramString.charAt(i);
			localStringBuffer.append(new String[] { "零", "壹", "貮", "叁", "肆", "伍", "陆", "柒", "捌", "玖" }[(j - 48)]);
			i += 1;
		}
		return localStringBuffer.toString();
	}

	@Test
	public void test2(){
		
		System.out.println(transferSegment("2345"));
		System.out.println(transferSegment("2305"));
		System.out.println(transferSegment("2035"));
		System.out.println(transferSegment("2340"));
		System.out.println(transferSegment("2300"));
		System.out.println(transferSegment("2001"));
		System.out.println(transferSegment("2020"));
		System.out.println(transferSegment("2000"));
		
		//String ssString = "2354";
		//System.out.println(Integer.valueOf(ssString.charAt(0)).intValue());
	}
	
	private static String transferSegment(String paramString) {
		StringBuffer localStringBuffer = new StringBuffer();
		int length = paramString.length();
		int j = 0; //字符串的值
		int i = length - 1;
		if (i >= 0) {
			

			boolean zeroFlg = false;
			boolean isadd = false;
			for(;i >= 0; i--){
				if (paramString.charAt(i) == '0'){
					zeroFlg = true;
				} else {
					zeroFlg = false;
				}

				j = Integer.valueOf(paramString.charAt(i)).intValue();
				String str1 = new String[] { "零", "壹", "貮", "叁", "肆", "伍", "陆", "柒", "捌", "玖" }[(j - 48)];
				String str2 = new String[] { "", "拾", "佰", "仟" }[(length - i - 1)];
				if(zeroFlg && !str2.equals("") && !isadd) {
					localStringBuffer.insert(0, "零");
					isadd = true;
				} else if(!zeroFlg) {
					localStringBuffer.insert(0, str1 + str2);
					isadd = false;
				}
				
			}
			
		}
		if (localStringBuffer.length() == 0) {
			localStringBuffer.append("零");
		}
		return localStringBuffer.toString();
	}

	private static String transferXiaoshu(String paramString) {
		StringBuffer localObject1 = new StringBuffer();
		int i = 0;
		while (i < paramString.length()) {
			int j = paramString.charAt(i);
			localObject1.append(new String[] { "零", "壹", "貮", "叁", "肆", "伍", "陆", "柒", "捌", "玖" }[(j - 48)]);
			i += 1;
		}
		String localObject = localObject1.toString();
		paramString = localObject;
		if (localObject.substring(localObject.length() - 1, localObject.length()).equals("零")) {
			paramString = localObject.substring(0, localObject.length() - 1);
		}
		return paramString;
	}
}
