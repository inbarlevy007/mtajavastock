package com.mta.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

public class PortfolioService {

	Stock st1 = new Stock();
	Stock st2 = new Stock();
	Stock st3 = new Stock();

	public Portfolio getPortfolio ()
	{
		Portfolio myPortfolio = new Portfolio();
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

		myPortfolio.addStock(st1);
		myPortfolio.addStock(st2);
		myPortfolio.addStock(st3);
		
		return myPortfolio;
	}
}