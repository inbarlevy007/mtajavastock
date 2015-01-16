package com.mta.javacourse.exception;

public class StockAlreadyExistsException extends Exception {
	
	public StockAlreadyExistsException(String stockSymbol) {
		
		super("Cannot add the new stock, the stock "+ stockSymbol + " already exists.");
	}

}
