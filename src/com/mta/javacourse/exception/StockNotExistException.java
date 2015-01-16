package com.mta.javacourse.exception;

public class StockNotExistException extends Exception{
	
	public StockNotExistException(String stockSymbol){
		
		super("Cannot sell this stock, the stock " + stockSymbol + " doesn't exist.");
	}

}
