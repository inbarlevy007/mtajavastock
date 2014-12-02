package com.mta.javacourse;
 
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Stock;
 
public class StockDetailsServlet extends HttpServlet {
        @SuppressWarnings("deprecation")
        public void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws IOException {
 
                Stock st1 = new Stock();
                Stock st2 = new Stock();
                Stock st3 = new Stock();
                
                Calendar c = Calendar.getInstance();
        		c.set (2014, 10, 15, 0, 0, 0);
        		Date d = (Date) c.getTime();
                
 
                st1.setSymbol("PIH");
                st1.setAsk(12.4f);
                st1.setBid(13.1f);
                st1.setDate(d);
 
                st2.setSymbol("AAL");
                st2.setAsk(5.5f);
                st2.setBid(5.78f);
                st2.setDate(d);
 
                st3.setSymbol("CAAS");
                st3.setAsk(31.5f);
                st3.setBid(31.2f);
                st3.setDate(d);
 
                resp.setContentType("text/html");
 
                resp.getWriter().println(st1.getHtmlDescription() + "<br>");
                resp.getWriter().println(st2.getHtmlDescription() + "<br>");
                resp.getWriter().println(st3.getHtmlDescription() + "<br>");
 
        }
}