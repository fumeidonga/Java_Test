/*********************************************************************/
/*  文件名  StringUtils.java    　                                   */
/*  程序名  字符串工具类                     						 */
/*  版本履历   2014/10/16  修改                  刘伟    			 */
/*         Copyright 2014 DILIN. All Rights Reserved.                */
/*********************************************************************/
package test_java.test.image;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 字符串工具类
 * 
 */
public class StringUtils {

	/**
	 * 随机实例
	 */
	private static final Random DEFULT_RANDOM = new Random();

	/**
	 * 判断字符串是否为空
	 * 
	 * @param value
	 *            字符串
	 * @return true:为空,false:不为空
	 */
	public static boolean isEmpty(Object value) {
		if (value == null || value.toString().trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean equals(String a, String b) {
		if (a == b)
			return true;
		if (a != null && b != null) {
			return a.equals(b);
		}
		return false;
	}

	/**
	 * 去除制表符、空格、回车、换行
	 * 
	 * @param str
	 *            原字符串
	 * @return 去除制表符后的字符串
	 */
	public static String filterBlankTag(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 按Byte位数截取字符串
	 * 
	 * @param str
	 *            字符串
	 * @param byteLen
	 *            byte位数
	 * @param paddingSuffix
	 *            超长补位符，一般为省略号
	 * @return 截取后的字符串
	 */
	public static String subStrB(String str, int byteLen, String paddingSuffix) {
		if (str == null) {
			return str;
		}
		int suffixLen = paddingSuffix.getBytes().length;

		StringBuffer sbuffer = new StringBuffer();
		char[] chr = str.trim().toCharArray();
		int len = 0;
		for (int i = 0; i < chr.length; i++) {
			if (chr[i] >= 0xa1) {
				len += 2;
			} else {
				len++;
			}
		}

		if (len <= byteLen) {
			return str;
		}

		len = 0;
		for (int i = 0; i < chr.length; i++) {

			if (chr[i] >= 0xa1) {
				len += 2;
				if (len + suffixLen > byteLen) {
					break;
				} else {
					sbuffer.append(chr[i]);
				}
			} else {
				len++;
				if (len + suffixLen > byteLen) {
					break;
				} else {
					sbuffer.append(chr[i]);
				}
			}
		}
		sbuffer.append(paddingSuffix);
		return sbuffer.toString();
	}

	/**
	 * 电话号码加掩码*****
	 * 
	 * @param pn
	 * @return
	 */
	public static String getMaskPhoneNumber(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() < 5) {
			return phoneNumber;
		}
		StringBuffer s = new StringBuffer(phoneNumber.substring(0, 3));
		for (int i = 0; i < phoneNumber.length() - 4; i++) {
			s.append("*");
		}
		s.append(phoneNumber.charAt(phoneNumber.length() - 1));
		return s.toString();
	}

	/**
	 * 生成随机验证码
	 * 
	 * @param len
	 *            验证码位数
	 * @return 随机验证码
	 */
	public static String makeRandom(int len) {

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < len; i++) {
			// FIXUBUG:医生反馈如医号带4不吉利
			// buffer.append(DEFULT_RANDOM.nextInt(10));
			int r = DEFULT_RANDOM.nextInt(10);
			while (r == 4) {
				r = DEFULT_RANDOM.nextInt(10);
			}
			buffer.append(r);
		}
		if ("0".equals(buffer.charAt(0) + "")) {
			buffer.setCharAt(0, (char) 49);
		}
		return buffer.toString();
	}

	/**
	 * 生成门诊预约凭证码
	 */
	public static String voucherCodeRandom() {
		StringBuffer buffer = new StringBuffer();
		buffer.append((char) (DEFULT_RANDOM.nextInt(26) + 65));
		for (int i = 0; i < 4; i++) {
			// FIXUBUG:医生反馈如医号带4不吉利
			// buffer.append(DEFULT_RANDOM.nextInt(10));
			int r = DEFULT_RANDOM.nextInt(10);
			while (r == 4) {
				r = DEFULT_RANDOM.nextInt(10);
			}
			buffer.append(r);
		}
		if ("0".equals(buffer.charAt(0) + "")) {
			buffer.setCharAt(0, (char) 49);
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		System.out.println(((char) 1));
		for (int i = 0; i < 1000; i++) {
			int random = Integer.parseInt(makeRandom(5));
			System.out.println("makeRandom(5):" + random + "   " + (Integer.valueOf(random) + 10));
		}
	}

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
