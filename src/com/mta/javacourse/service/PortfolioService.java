package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

public class PortfolioService {
	
	/**
	 * Method that create a new portfolio and insert new stocks values.
	 * @return the updated portfolio
	 */
	public Portfolio getPortfolio ()
	{
		Portfolio myPortfolio = new Portfolio("portfolio");
		myPortfolio.setTitle("Exercise 7 - Portfolio");
		myPortfolio.setBalance(10000);
		
		Calendar c = Calendar.getInstance();
		c.set (2014, 10, 15, 0, 0, 0);
		Date d = (Date) c.getTime();
		
		Stock st1 = new Stock("PIH", 10f, 8.5f, d);
		Stock st2 = new Stock("AAL", 30f, 25.5f, d);
		Stock st3 = new Stock("CAAS", 20f, 15.5f, d);

		myPortfolio.addStock(st1);
		myPortfolio.addStock(st2);
		myPortfolio.addStock(st3);
		
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		
		myPortfolio.sellStock("AAL", -1);	
		
		myPortfolio.removeStock("CAAS");
		
		
		return myPortfolio;
	}
}