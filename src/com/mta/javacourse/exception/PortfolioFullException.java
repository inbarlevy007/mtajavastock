package com.mta.javacourse.exception;
/**
 * Exception for having not enough 
 * @author Inbar Levy
 *
 */
public class PortfolioFullException extends Exception {
	
	public PortfolioFullException(int maxSize)
	{
		super ("Can't add new stock, portfolio can have only " + maxSize + " stocks.");
	}

}
