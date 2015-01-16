package com.mta.javacourse.exception;
/**
 * Exception for having not enough balance
 * @author Inbar Levy
 *
 */
public class BalanceException extends Exception{
	
	public BalanceException(float currBalance)
	{
		super("Your " + currBalance + " is not enough to make this purchase.");
	}
}
