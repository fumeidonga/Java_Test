package test_java.test.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import test_java.test.test1;

public class Main {

	
	/**
	 * 生成收款的二维码
	 */
	@Test
	public void test1() throws Exception{

		String code_url  = "https://o.c-doctor.com/pay_qrcode.html?qrid=";
//		String code_url  = "http://wapruyitest.c-doctor.com/pay_qrcode.html?qrid=";
		String imgPath2 = "G://er//zxing_qrcode";
		for(int i = 15001; i <= 17000; i++){
			System.out.println(code_url+i);
			encordZxingCocd(code_url+i, imgPath2+i+".png");
			Thread.sleep(30);
		}
	}
	
	
	// 生成二维码，并写字上去
	@Test
	public void test() {
		
		String imgPath2 = "G://zxing_qrcode.png";
		String imgPath3 = "G://Michael_QRCode1.png";
		String qrBackground = "G://ruyi_qrcode_background.png";
		makeMoneyQrcode(imgPath2, imgPath3, qrBackground);
	}
	
	public void makeMoneyQrcode(String qrcodePath, String tempQrCode, String qrBackground){

		// 1, 生成二维码
		String content = "http://wapruyitest.c-doctor.com/s_scan_qrcode_receipt_money.html?store_id=151";
		encordZxingCocd(content, qrcodePath);

		// 2, 写个字
		drawTextInImg(qrBackground, tempQrCode, new FontText("中国中国", 1, "#CC2BAC", 60, "黑体"));

		// 3, 图片合并
		createPicTwo2(tempQrCode, qrcodePath);
	}

	/**
	 * 生成二维码(ZXING)图片
	 * 
	 */
	public void encordZxingCocd(String text, String imgPath) {
		try {
			int width = 430; // 二维码图片宽度
			int height = 430; // 二维码图片高度
			String format = "png";// 二维码的图片格式

			Hashtable hints = new Hashtable();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码
			ErrorCorrectionLevel level = ErrorCorrectionLevel.H;
			hints.put(EncodeHintType.ERROR_CORRECTION, level); //容错率
			hints.put(EncodeHintType.MARGIN, 0);  //二维码边框宽度，这里文档说设置0-4，但是设置后没有效果，不知原因，

			// 生成二维码
			File outputFile = new File(imgPath);
			
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
			int margin = 30;  //自定义白边边框宽度
			bitMatrix = updateBit(bitMatrix, margin);  //生成新的bitMatrix
			//因为二维码生成时，白边无法控制，去掉原有的白边，再添加自定义白边后，二维码大小与size大小就存在差异了，为了让新
			//生成的二维码大小还是size大小，根据size重新生成图片
			BufferedImage bi =  MatrixToImageWriter.toBufferedImage(bitMatrix);
			bi = zoomInImage(bi,width,height);//根据size放大、缩小生成的二维码
			ImageIO.write(bi, "png", outputFile); //生成二维码图片
			//这样生成的二维码在图片属性上跟我们设置的图片大小size是一致的。
			//唯一不明白的就是zxing库中生成二维码是设置白边边框不起作用，如果起作用，就不用这么麻烦了
			
			//MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private BitMatrix updateBit(BitMatrix matrix, int margin){
		int tempM = margin*2;
		int[] rec = matrix.getEnclosingRectangle();   //获取二维码图案的属性
		int resWidth = rec[2] + tempM;
		int resHeight = rec[3] + tempM;
		BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); // 按照自定义边框生成新的BitMatrix
		resMatrix.clear();
		for(int i= margin; i < resWidth- margin; i++){   //循环，将二维码图案绘制到新的bitMatrix中
			for(int j=margin; j < resHeight-margin; j++){
				if(matrix.get(i-margin + rec[0], j-margin + rec[1])){
				resMatrix.set(i,j);
				}
			}
		}
		return resMatrix;
	}
	/**
	* 图片放大缩小
	*/
	public static BufferedImage  zoomInImage(BufferedImage  originalImage, int width, int height){
		BufferedImage newImage = new BufferedImage(width,height,originalImage.getType());
		Graphics g = newImage.getGraphics();
		g.drawImage(originalImage, 0,0,width,height,null);
		g.dispose();
		return newImage;
	}

	/**
	 * 图片合并
	 * 
	 * @param x
	 * @param y
	 */
	public void createPicTwo2(String firstPic, String secondPic) {
		try {
			// 读取第一张图片
			File fileOne = new File(firstPic);
			BufferedImage ImageOne = ImageIO.read(fileOne);
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);

			// 对第二张图片做相同的处理
			File fileTwo = new File(secondPic);
			BufferedImage ImageTwo = ImageIO.read(fileTwo);
			int widthTwo = ImageTwo.getWidth();// 图片宽度
			int heightTwo = ImageTwo.getHeight();// 图片高度
			int[] ImageArrayTwo = new int[widthTwo * heightTwo];
			ImageArrayTwo = ImageTwo.getRGB(0, 0, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);

			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			ImageNew.setRGB(width / 6 + 10, height / 3 - 20, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);// 设置右半部分的RGB
			//ImageNew.setRGB(width/6 * 2, height / 3, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);// 设置右半部分的RGB
			File outFile = new File("G://out.png");
			ImageIO.write(ImageNew, "png", outFile);// 写图片

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 在图片上写字
	 * 
	 * @param filePath
	 * @param outPath
	 * @param text
	 */
	public static void drawTextInImg(String filePath, String outPath, FontText text) {
		ImageIcon imgIcon = new ImageIcon(filePath);
		Image img = imgIcon.getImage();
		int width = img.getWidth(null);
		int height = img.getHeight(null);
		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics2D g = bimage.createGraphics();
		g.setColor(Color.white);
		g.setBackground(Color.white);
		g.drawImage(img, 0, 0, null);
		Font font = null;
		if (test_java.test.image.StringUtils.isEmpty(text.getWm_text_font()) && text.getWm_text_size() != null) {
			font = new Font(text.getWm_text_font(), Font.BOLD, text.getWm_text_size());
		} else {
			font = new Font("宋体", Font.BOLD, 40);
		}

		g.setFont(font);
		FontMetrics metrics = new FontMetrics(font) {
		};
		Rectangle2D bounds = metrics.getStringBounds(text.getText(), null);
		int textWidth = (int) bounds.getWidth();
		int textHeight = (int) bounds.getHeight();
		//文字的位置
        int left = (width- textWidth) / 2 ;
        int top = height / 8 + textHeight / 3;

		// 九宫格控制位置
		if (text.getWm_text_pos() == 2) {
			left = width / 2;
		}
		if (text.getWm_text_pos() == 3) {
			left = width - textWidth;
		}
		if (text.getWm_text_pos() == 4) {
			top = height / 2;
		}
		if (text.getWm_text_pos() == 5) {
			left = width / 2;
			top = height / 2;
		}
		if (text.getWm_text_pos() == 6) {
			left = width - textWidth;
			top = height / 2;
		}
		if (text.getWm_text_pos() == 7) {
			top = height - textHeight;
		}
		if (text.getWm_text_pos() == 8) {
			left = width / 2;
			top = height - textHeight;
		}
		if (text.getWm_text_pos() == 9) {
			left = width - textWidth;
			top = height - textHeight;
		}
		g.drawString(text.getText(), left, top);
		g.dispose();

		try {
			FileOutputStream out = new FileOutputStream(outPath);
			ImageIO.write(bimage, "JPEG", out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test111(){
		int i[] = {3333,
				3339,
				3341,
				3346,
				3354,
				3362,
				3374,
				3377,
				3380,
				3381,
				3383,
				3386,
				3388,
				3389,
				3415,
				3441,
				3462,
				3469,
				3481,
				3494,
				3495,
				3504,
				3537,
				3509,
				3511,
				3510,
				3532,
				3584,
				3583,
				3586,
				3589,
				3590,
				3591,
				3593,
				3596,
				3597,
				3601,
				3602,
				3607,
				3612,
				3616,
				3618,
				3622,
				3626,
				3630,
				3632,
				3634,
				3636,
				3637,
				3649,
				3640,
				3645,
				3647,
				3650,
				3659,
				3662,
				3664,
				3668,
				3670,
				3672,
				3682,
				3684,
				3697,
				3700,
				3709,
				3710,
				3715,
				3722,
				3725,
				3732,
				3733,
				3734,
				3739,
				3738,
				3737,
				3740,
				3742,
				3743,
				3747,
				3748,
				3749,
				3751,
				3752,
				3753,
				3755,
				3756,
				3757,
				3760,
				3761,
				3765};
		String string = "http://o.c-doctor.com/index.html?store_id=";
		for(int j = 0; j< i.length; j++){
			System.out.println(string+i[j]);
		}
	}

}
