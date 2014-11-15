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
		
		String resultStr = new String ("<h1>The result of : " + "(" + num1 + "+" + num2 + ")" + "*" + num3 + " = " + res + "</h1>" );
		
		resp.setContentType("text/html");
		resp.getWriter().println(resultStr);
	}
}
