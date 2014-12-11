package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

	PortfolioService portfolioService = new PortfolioService();
	Portfolio portfolio = portfolioService.getPortfolio();
	Stock[] stocks = portfolio.getStocks();
	
	//create a copy of the first portfolio.
	Portfolio newPortfolio = new Portfolio(portfolio);
	//setting title for the new portfolio.
	newPortfolio.setTitle("Portfolio #2");
	
	//print portfolio & newPortfolio.
	resp.setContentType("text/html");
	resp.getWriter().println(portfolio.getHtmlString());
	resp.getWriter().println("</br>");
	resp.getWriter().println(newPortfolio.getHtmlString());
	
	//remove the first stock of portfolio.
	portfolio.removeStock(portfolio.getStocks()[0]);
	
	//print again after the change(remove the first stock).
	resp.setContentType("text/html");
	resp.getWriter().println(portfolio.getHtmlString());
	resp.getWriter().println("</br>");
	resp.getWriter().println(newPortfolio.getHtmlString());
	
	//change the bid value of stock3 in the newPortfolio.
	newPortfolio.getStocks()[2].setBid(55.55f);
	
	//print again after the change(bid).
	resp.setContentType("text/html");
	resp.getWriter().println(portfolio.getHtmlString());
	resp.getWriter().println("</br>");
	resp.getWriter().println(newPortfolio.getHtmlString());
}
}
