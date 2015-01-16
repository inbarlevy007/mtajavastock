package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioService;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio;
		/**
		 * Multi try/catch for taking care of exceptions.
		 */
		try {
			portfolio = portfolioService.getPortfolio();
			String portfolioString= portfolio.getHtmlString();
			resp.getWriter().println(portfolioString);
		} catch (StockAlreadyExistsException | PortfolioFullException
				| StockNotExistException | BalanceException e) {

			resp.getWriter().println(e.getMessage());
		}
	}
}