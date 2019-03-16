package test_java.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFromExcel {

	public static final String filePath = "C:\\Users\\david\\Desktop\\aa.txt";

	public static void main(String[] args) throws Exception {
		readTxtFile(filePath);
	}

	/**
	 * 功能：Java读取txt文件的内容 步骤：
	 * 1：先获得文件句柄 
	 * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 
	 * 4：一行一行的输出。readline()。
	 *  备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 */
	public static ArrayList<String> readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			ArrayList<String> strings = new ArrayList<>();
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String temp = "";
				while ((lineTxt = bufferedReader.readLine()) != null) {

					boolean hasSymble = !lineTxt.matches("^[\\da-zA-Z]*$");
					if (!hasSymble && lineTxt.length() > 5 && lineTxt.length() < 15 
							&& !test1.equalStr(lineTxt) && !test1.isOrderNumeric(lineTxt) 
							&& !test1.isOrderNumeric_(lineTxt) && test1.isddd(lineTxt)
							&& !test1.matcher(lineTxt) && !test1.hasLH1(lineTxt, 3)  && !test1.hasLH(lineTxt, 3)) {
						strings.add(lineTxt);
					}
				}
				read.close();
				return strings;
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return new ArrayList<>();

	}
}
