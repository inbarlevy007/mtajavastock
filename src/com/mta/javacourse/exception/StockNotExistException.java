package com.mta.javacourse.exception;

public class StockNotExistException extends Exception{
	
	public StockNotExistException(){
		
		super("Cannot sell this stock, the stock doesn't exist.");
	}

}
