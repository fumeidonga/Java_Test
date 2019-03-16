package test_java.test.test_io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import org.junit.Test;

public class Main {

	/**
	 *         File.pathSeparator ;
	 *         File.separator \
	 */
	@Test
	public void testFile() throws Exception {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		String filepath = "";
		File file = new File(filepath);
		file.createNewFile(); // 创建一个新文件
		
		if(file.exists()){
			file.delete();   //删除一个文件
		}
		
		file.mkdir();  //创建一个文件夹
		
		String [] filelist = file.list();  //列出指定目录的全部文件（包括隐藏文件）
		
		File [] listFile = file.listFiles(); //列出指定目录的全部文件（包括隐藏文件）
		
		file.isDirectory();    //判断一个指定的路径是否为目录
		
	}
	
	@Test
	public void testRandomAccessFile(){
		//java_RandomAccessFile 花1k的内存实现高效的 i-o
	}
	
	@Test
	public void testFileInputOutPutStream() throws Exception {
		String filepath = "E:\\coding\\ruyi_web_oto_back\\javamall\\resource\\wx.properties";
		File file = new File(filepath);
		InputStream inputStream = new FileInputStream(file);
		
		//先规定一个数组的长度,比如100
		byte [] byt = new byte[100];
		
		//将这个流中的字节缓冲到数组byt中
		//返回的这个数组中的字节个数，这个缓冲区没有满的话，则返回真实的字节个数，
		//到未尾时都返回-1
		int result = -1;
		StringBuffer buffer = new StringBuffer();
		while ((result = inputStream.read(byt)) != -1) {
			buffer.append(new String(byt, "UTF-8"));
			System.out.println(new String(byt, "UTF-8"));
			System.out.println("-------------------------");
		}
		
		//关闭流
		inputStream.close();
		
		String path = "C:\\Users\\david\\Desktop\\wx1.properties";
		File fileout = new File(path);
		//true表示追加模式，否则为覆盖
		OutputStream outputStream = new FileOutputStream(fileout, true); 
		outputStream.write(buffer.toString().getBytes());
		outputStream.close();
		
		
	}
	
	@Test
	public void testFileReaderWriter() throws Exception {

		String filepath = "E:\\coding\\ruyi_web_oto_back\\javamall\\resource\\wx.properties";
		File file = new File(filepath);
		
		Reader reader = new FileReader(file);
		
		char [] cbuf = new char[12];
		
		int result = -1;
		
		while ((result = reader.read(cbuf)) != -1) {
			System.out.println(new String(cbuf));
			System.out.println("---------------------------");
		}
	}
	
	/**
	 * 这两个类创建的对象分别被称为数据输入流和数据输出流。这是很有用的两个流，它们允许程序按与机器无关的风格读写Java数据。
	 * 所以比较适合于网络上的数据传输。这两个流也是过滤器流，常以其它流如InputStream或OutputStream作为它们的输入或输出
	 * @throws Exception
	 */
	@Test
	public void testDataInputStream() throws Exception {
		String filepath = "E:\\coding\\ruyi_web_oto_back\\javamall\\resource\\wx.properties";
		File file = new File(filepath);
		
		InputStream inputStream1 = new FileInputStream(file);
		DataInputStream inputStream = new DataInputStream(inputStream1);
		
		char [] ch = new char[6];
		char temp = '1';
		int count = 0;
		
		for(int i = 0; i < 5; i++) {
			ch[i] = inputStream.readChar();
			
		}
		
		/*while((temp = inputStream.readChar()) != 'a'){
			ch[count++] = inputStream.readChar();
		}*/
		System.out.println(new String(ch));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
