//生成数字验证码的servlet

package com.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateCodeServlet extends HttpServlet {
    // 验证码图片的宽度。         
    private int width = 60;               
    // 验证码图片的高度。         
    private int height = 20;             
    // 验证码字符个数         
    private int codeCount = 4;   
    
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',         
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',         
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	/**
	 * 获取随机颜色的方法. <br>
	 */
	public Color getRandomColor(int fc,int bc){
		Random random = new Random();
		Color randomColor = null;
		if(fc>255) fc=255;
		if(bc>255) fc=255;
		//设置0~255之间的随机颜色值
		int red = fc+random.nextInt(bc-fc);
		int green = fc+random.nextInt(bc-fc);
		int blue = fc+random.nextInt(bc-fc);
		randomColor = new Color(red,green,blue);
		return randomColor;   //返回具有指定红色、绿色、和蓝色值的不透明的sRGB颜色
	}
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//禁止页面缓存
		response.setHeader("Pragma", "No-cache");         
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		/*创建一个位于缓存中的图像，宽60，高20*/
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();   //获取用于处理图形上下文的对象，想当于画笔
		Random random = new Random();      //创建生成随机数的对象
		g.setColor(getRandomColor(200,250));             //设置图像的背景
		g.fillRect(0, 0, width, height);              //画一个矩形，坐标（0，0），宽度60，高20
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));        //设置字体格式
		g.setColor(getRandomColor(160,200));               
		for(int i=0;i<130;i++){                      //产生130条随机干扰线
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);           
			g.drawLine(x, y, x+x1, y+y1);              //在图像的坐标（x，y）和（x+x1,y+y1)直接画干扰线
		}
		
		String strCode = "";
		for(int i=0;i<codeCount;i++){
			//String strNumber = String.valueOf(random.nextInt(10));    //只生成数字
			String strNumber = String.valueOf(codeSequence[random.nextInt(36)]);
			strCode = strCode+strNumber;
			//设置字体的颜色
			g.setColor(new Color(15+random.nextInt(120),15+random.nextInt(120),15+random.nextInt(120)));
			g.drawString(strNumber, 13*i+6,16);             //将验证码依次画到图像上，坐标（x=13*i+6,y=16)
		}
		

		//将验证码放入session中，在验证页面取得与输入的相比较
		request.getSession().setAttribute("rand", strCode);
		
		
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	
	
}

