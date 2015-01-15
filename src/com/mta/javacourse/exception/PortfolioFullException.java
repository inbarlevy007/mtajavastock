package com.mta.javacourse.exception;

public class PortfolioFullException extends Exception {
	
	public final static int MAX_PORTFOLIO_SIZE = 5;
	
	public PortfolioFullException()
	{
		super ("Can't add new stock, portfolio can have only " + MAX_PORTFOLIO_SIZE + " stocks.");
	}

}
