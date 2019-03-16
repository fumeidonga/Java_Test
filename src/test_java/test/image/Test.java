package test_java.test.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.StringUtils;
import com.swetake.util.Qrcode;

public class Test {
	public void createPicTwo2(int q, int y) {
		try {
			// 读取第一张图片
			File fileOne = new File("G://ruyi_qrcode_background.png");
			BufferedImage ImageOne = ImageIO.read(fileOne);
			int width = ImageOne.getWidth();// 图片宽度
			int height = ImageOne.getHeight();// 图片高度
			// 从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);

			// 对第二张图片做相同的处理
			File fileTwo = new File("G://IMG.png");
			BufferedImage ImageTwo = ImageIO.read(fileTwo);
			int widthTwo = ImageTwo.getWidth();// 图片宽度
			int heightTwo = ImageTwo.getHeight();// 图片高度
			int[] ImageArrayTwo = new int[widthTwo * heightTwo];
			ImageArrayTwo = ImageTwo.getRGB(0, 0, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);

			// 生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
			ImageNew.setRGB(width / 6 + 10, height / 3 - 20, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);// 设置右半部分的RGB
			// ImageNew.setRGB(width/6 * 2, height / 3, widthTwo, heightTwo,
			// ImageArrayTwo, 0, widthTwo);// 设置右半部分的RGB
			File outFile = new File("G://out.png");
			ImageIO.write(ImageNew, "png", outFile);// 写图片

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void main() {

		// 生成二维码
		String imgPath = "G://Michael_QRCode.png";
		String content = "http://o.c-doctor.com/pay_shop_weixin.html?1=1&code=021DdPrJ0sSpF42jwWpJ0aLMrJ0DdPrI&state=123&store_id=151";
		// String content = "Hello 大大、小小,welcome to QRCode!"
		// + "\nMyblog [ http://sjsky.iteye.com ]"
		// + "\nEMail [ sjsky007@gmail.com ]" + "\nTwitter [ @suncto ]";
		//encoderQRCode(content, imgPath);
		
		// 生成二维码
		String imgPath2 = "G://zxing_qrcode.png";
		//encordZxingCocd(content, imgPath2);

		// 图片合并
		 //createPicTwo2(100, 0);
		
		//
		String imgPath3 = "G://Michael_QRCode1.png";
		drawTextInImg("G://ruyi_qrcode_background.png", imgPath3,  new FontText("中国中国中国中国中国", 1, "#CC2BAC", 60, "黑体") );
	}

	/**
	 * 生成二维码(QRCode)图片
	 * 
	 * @param content
	 * @param imgPath
	 *            QRcode是日本人94年开发出来的。首先去QRCode的官网http://swetake.com/qrcode/java/
	 *            qr_java.html，把要用的jar包下下来，导入到项目里去。qrcode需要设置一个版本号，
	 *            这个版本号代表你生成的二维码的像素的大小。版本1是21*21的，版本号每增加1，边长增加4。也就是说版本7的大小是45 *
	 *            45的。版本号最大值是40。另外，版本7的编码的字节数如果超过了119，那么将无法编码，
	 *            下面按照官方文档提供的像素点个数与编码的字节数公式换算，完全没法算出这个出来119。官方文档在这里：http://
	 *            swetake.com/qrcode/qr1_en.html。
	 */
	public void encoderQRCode(String content, String imgPath) {
		try {
			int width = 430;
			int height = 430;
			Qrcode qrcodeHandler = new Qrcode();
			qrcodeHandler.setQrcodeErrorCorrect('M');// 纠错级别（L 7%、M 15%、Q 25%、H
														// 30%）和版本有关
			qrcodeHandler.setQrcodeEncodeMode('B');
			qrcodeHandler.setQrcodeVersion(7); // 设置Qrcode包的版本
			System.out.println(content);
			byte[] contentBytes = content.getBytes("gbk");
			BufferedImage bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, width, height);
			// 设定图像颜色> BLACK
			gs.setColor(Color.BLACK);
			// 设置偏移量 不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容> 二维码
			if (contentBytes.length > 0 && contentBytes.length < 120) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,120 ]. ");
			}
			gs.dispose();
			bufImg.flush();
			File imgFile = new File(imgPath);
			if (!imgFile.exists())
				imgFile.mkdirs();
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, "png", imgFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // 内容所使用字符集编码

			BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
			// 生成二维码
			File outputFile = new File(imgPath);
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 在图片上写字
	 * @param filePath
	 * @param outPath
	 * @param text
	 */
    public static void drawTextInImg(String filePath,String outPath, FontText text) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image img = imgIcon.getImage();
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bimage.createGraphics();
        g.setColor(Color.white);
        g.setBackground(Color.white);
        g.drawImage(img, 0, 0, null);
        Font font = null;
        if (test_java.test.image.StringUtils.isEmpty(text.getWm_text_font())
                && text.getWm_text_size() != null) {
            font = new Font(text.getWm_text_font(), Font.BOLD,
                    text.getWm_text_size());
        } else {
            font = new Font(null, Font.BOLD, 40);
        }

        g.setFont(font);
        FontMetrics metrics = new FontMetrics(font){};
        Rectangle2D bounds = metrics.getStringBounds(text.getText(), null);
        int textWidth = (int) bounds.getWidth();
        int textHeight = (int) bounds.getHeight();
        int left = (width- textWidth) / 2 ;
        int top = height / 8 + textHeight / 3;
        
        //九宫格控制位置
        if(text.getWm_text_pos()==2){
            left = width/2;
        }
        if(text.getWm_text_pos()==3){
            left = width -textWidth;
        }
        if(text.getWm_text_pos()==4){
            top = height/2;
        }
        if(text.getWm_text_pos()==5){
            left = width/2;
            top = height/2;
        }
        if(text.getWm_text_pos()==6){
            left = width -textWidth;
            top = height/2;
        }
        if(text.getWm_text_pos()==7){
            top = height - textHeight;
        }
        if(text.getWm_text_pos()==8){
            left = width/2;
            top = height - textHeight;
        }
        if(text.getWm_text_pos()==9){
            left = width -textWidth;
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

    // color #2395439
    public static Color getColor(String color) {
        if (color.charAt(0) == '#') {
            color = color.substring(1);
        }
        if (color.length() != 6) {
            return null;
        }
        try {
            int r = Integer.parseInt(color.substring(0, 2), 16);
            int g = Integer.parseInt(color.substring(2, 4), 16);
            int b = Integer.parseInt(color.substring(4), 16);
            return new Color(r, g, b);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }
}
