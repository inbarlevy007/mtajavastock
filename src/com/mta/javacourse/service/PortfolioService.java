package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

public class PortfolioService {
	
	/**
	 * Method that insert new stocks values to the portfolio.
	 * @return the updated portfolio
	 */
	public Portfolio getPortfolio ()
	{
		Portfolio myPortfolio = new Portfolio("portfolio");
		Calendar c = Calendar.getInstance();
		c.set (2014, 10, 15, 0, 0, 0);
		Date d = (Date) c.getTime();
		
		Stock st1 = new Stock("PIH", 12.4f, 13.1f, d);
		Stock st2 = new Stock("AAL", 5.5f, 5.78f, d);
		Stock st3 = new Stock("CAAS", 31.5f, 31.2f, d);

		myPortfolio.addStock(st1);
		myPortfolio.addStock(st2);
		myPortfolio.addStock(st3);
		
		return myPortfolio;
	}
}