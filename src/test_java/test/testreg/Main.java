package test_java.test.testreg;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import test_java.test.ramdomName.CreateRandomField;
import test_java.test.ramdomName.Regeister;
import test_java.test.ramdomName.Test;

public class Main {
	public static Regeister json;
	
	@org.junit.Test
	public void test() {
		//注册
		System.out.println(regis());
		
		//登录
		System.out.println(login(json.getUsername(), json.getPassword()));
		
		//初始化 
		System.out.println(zg(json.getId()));
		
		//干嘛的？
		System.out.println(message(json.getId()));
		
		//开始
		System.out.println(start(json.getId()));
		

		//上传图片
		System.out.println(sztp(json.getId(), ""));

		//退出登录
//		System.out.println();
		
		//提现
		System.out.println(tx(json.getId(), json.getPassword()));
		
		
		//查看提现记录
		System.out.println(cashRecorder(json.getId(), json.getPassword()));
		
		//登录
		System.out.println(login(json.getUsername(), json.getPassword()));
		
	}
	
	//查看提现记录
	//GET /home/cashrecorder?id=8244&password=poiulkjh HTTP/1.1
	public static String cashRecorder(String id, String pass){
        String sr = sendGet("http://112.74.57.100:64499/home/cashrecorder", "id="+ id + "&password=" + pass);
		return sr;
	}
	
	//登录
    public static String login(String uString, String pString) {
        String sr = sendGet("http://112.74.57.100:64499/home/login", "username="+ uString + "&password=" + pString);
        
        return sr;
    }
    
//    Host: 112.74.57.100:64499
//    GET /home/register?email=rthjjgffffgg@qq.com&username=123qweasd&password=123qweasd&vx=s1159&tel=14725836999 + "&yqm=" + yqm HTTP/1.1
    public static String regis() {
    	String eamil = Test.getEmail(6, 9);
    	String u = CreateRandomField.getRandomEnglishName();
    	/*String u = Test.getChineseName()+Test.getRoad();
    	if(u.length() > 8){
    		u = u.substring(0, 7);
    	}*/
    	String pass = Test.getRandom();
    	String tel = Test.getTel();
        String sr = sendGet("http://112.74.57.100:64499/home/register", "email=" + eamil + "&username=" + u + "&password="+ pass +"&vx=s1159134924&tel=" + tel);

        if(sr.startsWith("{")) {
        	try {
            	json = JSONObject.parseObject(sr, Regeister.class);
				System.out.println(json);
			} catch (Exception e) {
				System.out.println(e);
			}
        }
        return sr;
    }
    
    //GET /home/updateint?id=8247&key=sgjzg&value=0&sysj=0&cishu=0&ssje=0 HTTP/1.1
    //任务完成了
    public static String start(String id) {
        String sr = sendGet("http://112.74.57.100:64499/home/updateint", "id=" + id + "&key=wancheng&value=200&sysj=0&cishu=0&ssje=0");
        return sr;
    }
    
    //初始化
    //GET /home/updateint?id=8244&key=sgjzg&value=0&sysj=0&cishu=0&ssje=0 HTTP/1.1
    public static String zg(String id) {
        String sr = sendGet("http://112.74.57.100:64499/home/updateint", "id=" + id + "&key=sgjzg&value=200&sysj=0&cishu=0&ssje=0");
        return sr;
    }
    
    //提交数据
    public static String message(String id) {
        String sr = sendGet("http://112.74.57.100:64499/home/updateint", "id=" + id + "&key=yue&value=200&sysj=0&cishu=0&ssje=200");
        return sr;
    }
    
    
    //上传图片
    //POST /home/upload/?id=8244&filename=png HTTP/1.1
    public static String sztp(String id, String image) {
        try {
			sendImg("http://112.74.57.100:64499/home/upload?id=" + id + "&filename=png", new File("F:\\test.png"));
		} catch (IOException e) {
			System.out.println(e);
		}
        return "";
    }
    
    //提现
    //GET /home/eppay?id=8244&cashnum=2&password=poiulkjh HTTP/1.1
    public static String tx(String id, String p) {
        String sr = sendGet("http://112.74.57.100:64499/home/eppay", "id=" + id + "&cashnum=2&password=" + p);
        return sr;
    }

    public static String sendGet(String url, String param) {
        String result = "";
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
            for (String key : map.keySet()) {
            	//System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            InputStreamReader localInputStreamReader1 = new InputStreamReader(connection.getInputStream());

        	String line = "";
        	while ((line = in.readLine()) != null) {
        		result += line;
        	}
        } catch(Exception e) {
            System.out.println("send " + e);
            e.printStackTrace();
            if(in != null) {
                try {
                    in.close();
                    return result;
                } catch(Exception e2) {
                    e2.printStackTrace();
                }
            }
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
        return result;
    }
    
    public static String sendPost(String url, String param) {
    	PrintWriter out = null;
    	BufferedReader in = null;
    	String result = "";
    	try {
    		URL realUrl = new URL(url);
    		// 打开和URL之间的连接
    		URLConnection conn = realUrl.openConnection();
    		// 设置通用的请求属性
    		conn.setRequestProperty("accept", "*/*");
    		conn.setRequestProperty("connection", "Keep-Alive");
    		conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
    		// 发送POST请求必须设置如下两行
    		conn.setDoOutput(true);
    		conn.setDoInput(true);
    		// 获取URLConnection对象对应的输出流
    		out = new PrintWriter(conn.getOutputStream());
    		// 发送请求参数
    		out.print(param);
    		// flush输出流的缓冲
    		out.flush();
    		// 定义BufferedReader输入流来读取URL的响应
    		in = new BufferedReader(
    				new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = in.readLine()) != null) {
    			result += line;
    		}
    	} catch (Exception e) {
    		System.out.println("发送 POST 请求出现异常！" + e);
    		e.printStackTrace();
    	}
    	//使用finally块来关闭输出流、输入流
    	finally {
    		try {
    			if (out != null) {
    				out.close();
    			}
    			if (in != null) {
    				in.close();
    			}
    		} catch (IOException ex) {
    			ex.printStackTrace();
    		}
    	}
    	return result;
    }

    public static void sendImg(final String paramString, final File paramFile)  throws IOException {
    	try  {
    		byte[] paramAnonymousVarArgs = new byte[1024];
    		HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    		localHttpURLConnection.setReadTimeout(10000);
    		localHttpURLConnection.setConnectTimeout(10000);
    		localHttpURLConnection.setDoInput(true);
    		localHttpURLConnection.setDoOutput(true);
    		localHttpURLConnection.setUseCaches(false);
    		localHttpURLConnection.setRequestMethod("POST");
    		FileInputStream fileInputStream = new FileInputStream(paramFile);

            BufferedOutputStream  out=new BufferedOutputStream(localHttpURLConnection.getOutputStream());
            int numReadByte=0;
            while((numReadByte=fileInputStream.read(paramAnonymousVarArgs,0,1024))>0)  {
                out.write(paramAnonymousVarArgs, 0, numReadByte);
            }

            out.flush();
            fileInputStream.close();
            //读取URLConnection的响应
            DataInputStream in=new DataInputStream(localHttpURLConnection.getInputStream());

			// 将返回的输入流转换成字符串
			InputStream inputStream = localHttpURLConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			localHttpURLConnection.disconnect();
			System.out.println(buffer.toString());
    	} catch (IOException paramAnonymousVarArgs)  {
    		paramAnonymousVarArgs.printStackTrace();
        }
    }
}
