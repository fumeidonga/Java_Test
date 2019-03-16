package test_java.test.test_http;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.ImageIcon;

import org.junit.Test;

import Decoder.BASE64Encoder;

public class testurl {

	@Test
	public void main() {
		// TODO Auto-generated method stub
		a();
	}

	public int i = 1;

	public void a() {
		String url = "http://www.cengfan8.com/ajax.php?code=&typename=3";
		try {
			BaseHttpRequester httpRequester = new BaseHttpRequester();
			httpRequester.setDefaultContentEncoding("utf-8");
			BaseHttpRespons httpRespons = httpRequester.sendGet(url);
//			BaseHttpRespons httpRespons = httpRequester.sendPost(url);
			System.out.println(httpRespons.content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * http://2320098003-qq-com.iteye.com/blog/1434536 public void
	 * setDoInput(boolean doinput)将此 URLConnection 的 doInput 字段的值设置为指定的值。 URL
	 * 连接可用于输入和/或输出。如果打算使用 URL 连接进行输入，则将 DoInput 标志设置为 true；如果不打算使用，则设置为
	 * false。默认值为 true。 public void setDoOutput(boolean dooutput)将此
	 * URLConnection 的 doOutput 字段的值设置为指定的值。 URL 连接可用于输入和/或输出。如果打算使用 URL
	 * 连接进行输出，则将 DoOutput 标志设置为 true；如果不打算使用，则设置为 false。默认值为 false。
	 * 
	 * @throws Exception
	 */
	@Test
	public void testget() throws Exception {

//		String wepurl = "http://wapruyitest.c-doctor.com/statics/qrcode2017/06/02/1496393384.jpg";
		String wepurl = "http://play.youku.com/play/get.json?vid=XMjgzNDk2ODk4MA==&ct=10&pwd=%22%22&ran=437";
		String param = "";

		URL url = new URL(wepurl + "?" + param);

		//// 打开和URL之间的连接
		URLConnection urlConnection = url.openConnection();

		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true);

		// 获取属性
		Map<String, List<String>> map = httpURLConnection.getRequestProperties();

		Set<String> set = map.keySet();
		for (String string : set) {
			System.out.println(string);
		}
		// 设置通用的请求属性
		// httpURLConnection.setRequestProperty("", "");

		// 建立实际的连接
		httpURLConnection.connect();

		InputStream inputStream = httpURLConnection.getInputStream();

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String readline = "";
		while (bufferedReader.readLine() != null) {
			readline += bufferedReader.readLine();
			System.out.println(readline + "\n");

		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		System.out.println(readline);

	}

	@Test
	public void testpost() throws Exception {

		String wepurl = "http://www.baidu.com/";
		String param = "";

		URL url = new URL(wepurl + "?" + param);

		//// 打开和URL之间的连接
		URLConnection urlConnection = url.openConnection();

		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		// 发送POST请求必须设置如下两行
		httpURLConnection.setDoOutput(true);// 表示向服务器写数据
		httpURLConnection.setDoInput(true);// 表示从服务器获取数据

		httpURLConnection.setRequestMethod("POST");

		// HttpRespons response = httpURLConnection.getResponse();
		// PrintWriter outWriter = response.getWriter();

		PrintWriter outWriter = new PrintWriter(httpURLConnection.getOutputStream());
		// 发送请求参数
		outWriter.print(param);
		// flush输出流的缓冲
		outWriter.flush();

		// 定义BufferedReader输入流来读取URL的响应
		InputStream inputStream = httpURLConnection.getInputStream();

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String readline = "";
		while (bufferedReader.readLine() != null) {
			readline += bufferedReader.readLine();
			System.out.println(readline + "\n");

		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		System.out.println(readline);

	}
	
	@Test
	public void ddddd() throws Exception{
		
		for(int i = 0; i < ss.length; i ++){
			
			testsaveFile(ss[i], "G://er1//"+i+".jpg");
		}
	}

	
	public void testsaveFile(String URL_PATH, String name) throws Exception {
		

		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;
		URL url = new URL(URL_PATH);
		if (url != null) {
			httpURLConnection = (HttpURLConnection) url.openConnection();
			// 设置连接网络的超时时间
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.setDoInput(true);
			// 表示设置本次http请求使用GET方式请求
			httpURLConnection.setRequestMethod("GET");
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				// 从服务器获得一个输入流
				inputStream = httpURLConnection.getInputStream();
			}
		}
		byte[] data = new byte[1024];
		int len = 0;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		FileOutputStream fileOutputStream = null;
		fileOutputStream = new FileOutputStream(name);
		while ((len = inputStream.read(data)) != -1) {
			fileOutputStream.write(data, 0, len);
			byteArrayOutputStream.write(data);
		}
		byte[] dataB = byteArrayOutputStream.toByteArray();
		System.out.println(byte2hex(dataB));
		System.out.println(checkImageType(dataB));

		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fileOutputStream != null) {
			fileOutputStream.close();
			// TODO Auto-generated catch block
		}
		if (byteArrayOutputStream != null) {
			byteArrayOutputStream.close();
			// TODO Auto-generated catch block
		}
	}

	// 二进制转字符串
	public static String byte2hex(byte[] b) {
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}

		}
		return sb.toString();
	}

	// 根据字节流来判断这个图片的编码格式
	public static String checkImageType(byte[] imageBytes) {
		ByteArrayInputStream bais = null;
		MemoryCacheImageInputStream mcis = null;
		try {
			bais = new ByteArrayInputStream(imageBytes);
			mcis = new MemoryCacheImageInputStream(bais);
			Iterator<ImageReader> itr = ImageIO.getImageReaders(mcis);
			while (itr.hasNext()) {
				ImageReader reader = (ImageReader) itr.next();
				String imageName = reader.getClass().getSimpleName();
				if (imageName != null && ("JPEGImageReader".equalsIgnoreCase(imageName))) {
					return "jpeg";
				} else if (imageName != null && ("JPGImageReader".equalsIgnoreCase(imageName))) {
					return "jpg";
				} else if (imageName != null && ("pngImageReader".equalsIgnoreCase(imageName))) {
					return "png";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	// 将图片转成字节流
	public static byte[] image2Bytes(String imagePath) {
		ImageIcon ima = new ImageIcon(imagePath);
		BufferedImage bu = new BufferedImage(ima.getImage().getWidth(null), ima.getImage().getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
		try {
			// 把这个jpg图像写到这个流中去,这里可以转变图片的编码格式
			boolean resultWrite = ImageIO.write(bu, "png", imageStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] tagInfo = imageStream.toByteArray();
		return tagInfo;
	}

	// 将字节流转成图片
	public static void buff2Image(byte[] b, String tagSrc) throws Exception {
		FileOutputStream fout = new FileOutputStream(tagSrc);
		// 将字节写入文件
		fout.write(b);
		fout.close();
	}

	// 图片转化成base64字符串
	// @Test
	public static String GetImageStr() {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		String imgFile = "d://test.png";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		String encode = encoder.encode(data);
		System.out.println(encode);
		return encode;// 返回Base64编码过的字节数组字符串
	}

	public static void main(String[] args) {
		//GetImageStr();

        List<String> openids = new ArrayList<String>();
		openids.add("oXeLbjsfjC8u5LirnwaJU-2qwh9A");
		openids.add("oXeLbjgpxkHFei_lf3L086yL2UMA");
		openids.add("oXeLbjpqTZ7bgX72ie091bsGFs9E");
		openids.add("oXeLbjgpERBiiv6Q5g8fNH2SuGqs");
		openids.add("oXeLbjkwOi0LhNJWu9hjihNHPGgc");
		//openids.add("oUavtwcgeGPWeRiSZQXSqAlk6CJU");
		String ac = "JCBF2XtSGXjW-7nBNcMutnUMXGtP9c4wM5mqg-8jN3j6zaGdJgHoU8R80wGrmQ4nhaocnQR_6QhQAfcgFEmGaz0z3DbwJeyMCVUgGilXtxxG9AxgVmafMVz7EKWumYgfJWLiAGAZMB";
		for(String string :openids){
			String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ac+"&openid=" + string+"&lang=zh_CN ";
			String result = httpsRequest(url, "GET", null);
			System.out.println(result);
			System.out.println("_________________^^^^^^^^^^^^^^^^^^^^^^___________________");
		}
	}

	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		URL url = null;
		HttpsURLConnection httpUrlConn = null;

			try {
				url = new URL(requestUrl);
				httpUrlConn = (HttpsURLConnection) url.openConnection();
				httpUrlConn.setDoOutput(true);
				httpUrlConn.setDoInput(true);
				httpUrlConn.setUseCaches(false);

				httpUrlConn.setReadTimeout(15000);
				httpUrlConn.setReadTimeout(15000);
				// 设置请求方式（GET/POST）
				httpUrlConn.setRequestMethod(requestMethod);
				if ("GET".equalsIgnoreCase(requestMethod))
					httpUrlConn.connect();
				// 当有数据需要提交时
				// System.out.println(outputStr);

				if (null != outputStr) {
					OutputStream outputStream = httpUrlConn.getOutputStream();
					// 注意编码格式，防止中文乱码
					// System.out.println(outputStr.getBytes("UTF-8"));
					outputStream.write(outputStr.getBytes("UTF-8"));
					outputStream.close();
				}
				// 将返回的输入流转换成字符串
				InputStream inputStream = httpUrlConn.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				bufferedReader.close();
				inputStreamReader.close();
				// 释放资源
				inputStream.close();
				inputStream = null;
				httpUrlConn.disconnect();
			} catch (Exception e) {
			}

		String result = buffer.toString();
		return result;
	}
	
	public static String ss[] = {"http://o.c-doctor.com/statics/qrcode2017/08/01/1501558993.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/01/1501569459.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/01/1501573725.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/01/1501577823.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/02/1501662266.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/03/1501736247.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/05/1501918352.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/06/1501992859.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/06/1502013170.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/07/1502072545.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/07/1502075316.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/07/1502081351.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/07/1502088631.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/09/1502246540.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/10/1502338911.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/10/1502355294.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/11/1502421912.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/11/1502445579.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/12/1502508132.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/12/1502513082.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/13/1502589408.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/15/1502786091.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/14/1502682152.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/14/1502687051.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/14/1502686761.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/15/1502776120.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/20/1503230132.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/20/1503230124.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/20/1503230187.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/20/1503233615.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503276532.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503277415.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503278783.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503279473.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503279917.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503284742.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503286842.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503289487.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503296343.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503301705.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503301960.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503306146.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/21/1503309861.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503362276.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503364272.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503364677.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503366983.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503367247.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503376970.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503371211.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503372716.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503373928.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503380218.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503386898.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503388621.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503389750.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503392142.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503392416.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/22/1503393613.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503452442.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503453533.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503459063.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503465800.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503473542.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503474262.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503476643.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503479053.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/23/1503481604.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503538720.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503539481.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503539919.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503541005.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503541003.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503540971.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503541172.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503542982.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503543818.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503546116.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503546333.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503546411.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503549704.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503551077.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503551548.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503552605.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503553616.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503557618.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503559059.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503559354.jpg",
			"http://o.c-doctor.com/statics/qrcode2017/08/24/1503560654.jpg"};
}
