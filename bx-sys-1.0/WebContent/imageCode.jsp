<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.awt.Color" %>
<%@ page import="java.awt.Font" %>
<%@ page import="java.awt.Graphics" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>

<%
	//原理就是通过bufferedimage生成一张图片
	int width=80;
 	int height=32;
 	//create the image
 	BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
 	Graphics g=image.getGraphics();
 	//set the background color
 	g.setColor(new Color(0xDCDCDC));
 	g.fillRect(0, 0, width, height);
 	//draw the border
 	g.setColor(Color.black);
 	g.drawRect(0, 0, width-1, height-1);
 	//create a random instance to generate the codes
 	Random random=new Random();
 	String hash1=Integer.toHexString(random.nextInt());
 	//make some confusion
 	for(int i=0;i<50 ;i++){
 		int x=random.nextInt(width);
 		int y=random.nextInt(height);
 		g.drawRect(x, y, 0, 0);
 		
 	}
 	
 	//generate a random code
 	String capstr=hash1.substring(0,4);
 	session.setAttribute("key", capstr);
 	g.setColor(new Color(0,100,0));
 	g.setFont(new Font("Candara",Font.BOLD,24));
 	g.drawString(capstr, 8, 24);
 	g.dispose();
 	response.setContentType("image/jpeg");
 	out.clear();
 	out=pageContext.popBody();
 	OutputStream stream=response.getOutputStream();
 	ImageIO.write(image, "jpeg", stream);
 	stream.close();
 	
%>