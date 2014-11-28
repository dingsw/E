//����������֤���servlet

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
    // ��֤��ͼƬ�Ŀ�ȡ�         
    private int width = 60;               
    // ��֤��ͼƬ�ĸ߶ȡ�         
    private int height = 20;             
    // ��֤���ַ�����         
    private int codeCount = 4;   
    
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',         
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',         
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	/**
	 * ��ȡ�����ɫ�ķ���. <br>
	 */
	public Color getRandomColor(int fc,int bc){
		Random random = new Random();
		Color randomColor = null;
		if(fc>255) fc=255;
		if(bc>255) fc=255;
		//����0~255֮��������ɫֵ
		int red = fc+random.nextInt(bc-fc);
		int green = fc+random.nextInt(bc-fc);
		int blue = fc+random.nextInt(bc-fc);
		randomColor = new Color(red,green,blue);
		return randomColor;   //���ؾ���ָ����ɫ����ɫ������ɫֵ�Ĳ�͸����sRGB��ɫ
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
		//��ֹҳ�滺��
		response.setHeader("Pragma", "No-cache");         
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		/*����һ��λ�ڻ����е�ͼ�񣬿�60����20*/
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();   //��ȡ���ڴ���ͼ�������ĵĶ����뵱�ڻ���
		Random random = new Random();      //��������������Ķ���
		g.setColor(getRandomColor(200,250));             //����ͼ��ı���
		g.fillRect(0, 0, width, height);              //��һ�����Σ����꣨0��0�������60����20
		g.setFont(new Font("Times New Roman",Font.PLAIN,18));        //���������ʽ
		g.setColor(getRandomColor(160,200));               
		for(int i=0;i<130;i++){                      //����130�����������
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);           
			g.drawLine(x, y, x+x1, y+y1);              //��ͼ������꣨x��y���ͣ�x+x1,y+y1)ֱ�ӻ�������
		}
		
		String strCode = "";
		for(int i=0;i<codeCount;i++){
			//String strNumber = String.valueOf(random.nextInt(10));    //ֻ��������
			String strNumber = String.valueOf(codeSequence[random.nextInt(36)]);
			strCode = strCode+strNumber;
			//�����������ɫ
			g.setColor(new Color(15+random.nextInt(120),15+random.nextInt(120),15+random.nextInt(120)));
			g.drawString(strNumber, 13*i+6,16);             //����֤�����λ���ͼ���ϣ����꣨x=13*i+6,y=16)
		}
		

		//����֤�����session�У�����֤ҳ��ȡ�����������Ƚ�
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

