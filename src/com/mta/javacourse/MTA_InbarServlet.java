package com.mta.javacourse;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MTA_InbarServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		int num1 = 3;
		int num2 = 4;
		int num3 = 7;
		int res = (num1+num2)*num3;
		
		String resStr = new String ("<h1>The result of : " + "(" + num1 + "+" + num2 + ")" + "*" + num3 + " = " + res + "</h1>" );
		
		//circle area
		int radius = 50;
		double circleArea = (radius * radius) * Math.PI;
		String roundCircleArea = String.format("%.2f", circleArea);
		String line1 = new String ("calculation 1: Area of circle with radius " + radius + " is: " + roundCircleArea + " square-cm.");
		
		
		//opposite of triangle
		int bAngle = 30;
		int hypotenuse = 50;
		
		double degreeToRadian = Math.toRadians(bAngle);
		double opposite = hypotenuse * Math.sin(degreeToRadian);
		String roundOpposite = String.format("%.2f", opposite);
		String line2 = new String ("calculation 2: Length of opposite, where angle B is: " + bAngle + " degrees" + " is: " + roundOpposite + ".");
		
		//calculate power of 20
		int base = 20;
		int exp = 13;
		long powRes = (long)Math.pow(base, exp);
		String line3 = new String ("calculation 3: Power of " + base +" with exp of " + exp + " is: " + powRes);
		
		String resultStr = resStr + "<br>" + line1 + "<br>" + line2 + "<br>" + line3;
		
		resp.setContentType("text/html");
		resp.getWriter().println(resultStr);
	}
}
