package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.model.StockStatus;

public class PortfolioService {
	
	/**
	 * Method that create a new portfolio and insert new stocks values .
	 * @return the updated portfolio
	 */
	public Portfolio getPortfolio ()
	{
		Portfolio myPortfolio = new Portfolio("portfolio");
		myPortfolio.setTitle("Exercise 8 - Portfolio");
		myPortfolio.updateBalance(10000);
		
		Calendar basicDate = Calendar.getInstance();
		basicDate.set(Calendar.ERA, GregorianCalendar.AD);
		basicDate.set(2014,11,15);
		java.util.Date d = basicDate.getTime();
		
		Stock st1 = new StockStatus("PIH", 10f, 8.5f, d);
		Stock st2 = new StockStatus("AAL", 30f, 25.5f, d);
		Stock st3 = new StockStatus("CAAS", 20f, 15.5f, d);

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