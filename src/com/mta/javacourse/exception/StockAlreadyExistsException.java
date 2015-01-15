package com.mta.javacourse.exception;

public class StockAlreadyExistsException extends Exception {
	
	public StockAlreadyExistsException() {
		
		super("Cannot add the new stock, the stock is already exists.");
		
	}

}
