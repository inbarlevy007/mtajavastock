package com.mta.javacourse.exception;

public class BalanceException extends Exception{
	
	public BalanceException()
	{
		super("There is not enough balance to make the purchase.");
	}
}
