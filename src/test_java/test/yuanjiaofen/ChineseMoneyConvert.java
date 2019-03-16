package test_java.test.yuanjiaofen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ChineseMoneyConvert {

	public static void main(String argv[]) {
		String amount = "1002.11";
//		System.err.println(getUpperChineseMoney(amount));
		
		System.err.println(getSoundList(amount));

	}

	public static List<String> getSoundList(String amount) {

		String moneySpell = getUpperChineseMoney(amount);
//		System.err.println(moneySpell);

		final char[] hanzi = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖', '拾', '佰', '仟', '万', '元', '角', '分', '点' };
		final String[] shengyin = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "100", "1000", "10000",
				"yuan", "jiao", "fen", "dot" };

		List<String> result = new ArrayList<String>();
		result.add(sound("suc")); // 成功收款
		for (int i = 0; i < moneySpell.length(); i++) {
			char s = moneySpell.charAt(i);
			for (int j = 0; j < hanzi.length; j++) {
				if (hanzi[j] == s) {
					result.add(sound(shengyin[j]));
					break;
				}
			}
		}
		return result;
	}

	private static String sound(String name) {
		return "sound/" + name + ".mp3";
	}

	public static String getUpperChineseMoney(String amount) {

		final String[] upperUnit = { "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元" };
		final String[] upperNumber = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		final String[] upperDec = { "角", "分" };

		if (null == amount || "".equals(amount) || amount.indexOf("-") != -1)
			return "";

		if (amount == null || Double.parseDouble(amount) == 0) {
			return "零元整";
		}

		boolean islt0 = false;
		if (Double.parseDouble(amount) < 0.001) {
			islt0 = true;
			amount = (-Double.parseDouble(amount)) + "";
		}

		StringBuffer convertedMoney = new StringBuffer("");
		String returnString = "";

		try {
			// System.out.println(amount+"----------------------");
			DecimalFormat dcf = new DecimalFormat("###########0.00");
			String numString = dcf.format(Double.parseDouble(amount));
			// System.out.println(numString+"----------------------");
			numString = numString.replaceAll(",", ".");
			// System.out.println(numString+"----------------------");
			int dotPos = numString.indexOf(".");
			String integerStr = numString.substring(0, dotPos);
			String decStr = numString.substring(dotPos + 1);
			int lenInt = integerStr.length();
			int lenDec = 0;
			if ("00".equalsIgnoreCase(decStr)) {
				lenDec = 0;
			} else {
				lenDec = 2;
			}

			if (lenInt > 13) {
				return "数字太大";
			}

			boolean zeroFlg = false;
			int lenEmpty = 13 - lenInt;
			for (int i = 0; i < lenInt; i++) {
				String number = integerStr.substring(i, i + 1);
				String unit = upperUnit[lenEmpty + i];
				String upNum = upperNumber[Integer.parseInt(number)];
				if ("0".equalsIgnoreCase(number)) {
					if (!zeroFlg) {
						zeroFlg = true;
					}
					if ("亿".equals(unit) || "万".equals(unit) || "元".equals(unit)) {
						convertedMoney.append(unit);
					}
				} else {
					if (zeroFlg) {
						convertedMoney.append("零").append(upNum).append(unit);
						zeroFlg = false;
					} else {
						convertedMoney.append(upNum).append(unit);
					}
				}
			}
			if (lenDec == 0) {
				convertedMoney.append("整");
			} else {
				String jiao = upperNumber[Integer.parseInt(decStr.substring(0, 1))];
				if(convertedMoney.length() == 1) { //“元”
					convertedMoney.append("零");
				}
				convertedMoney.append("点");
				convertedMoney.append(jiao);
//				if (!"0".equals(decStr.substring(0, 1))) {
//					convertedMoney.append(jiao).append(upperDec[0]);
//				} else {
//					convertedMoney.append(jiao);
//				}

				String fen = upperNumber[Integer.parseInt(decStr.substring(1, 2))];
				if (!"0".equals(decStr.substring(1, 2))) {
					convertedMoney.append(fen);
//					convertedMoney.append(fen).append(upperDec[1]);
				} else {
					convertedMoney.append("整");
				}
			}

			returnString = convertedMoney.toString();
			returnString = returnString.replaceAll("元", "") + "元";

		} catch (Exception ex) {
			ex.printStackTrace();
			return "输入格式不正确！";
		}
		if (islt0) {
			returnString = "负" + returnString;
		}
		return returnString;
	}
}
