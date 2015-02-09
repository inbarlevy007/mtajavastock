package com.mta.javacourse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 /**
  * 
  * @author Inbar Levy
  *
  */
public class Stock{
    //Members Definition
	protected String symbol;
	protected float ask;
	protected float bid;
	protected Date date;
	
	/**
	 * c'tor that initializes all Stock members.
	 */
	public Stock(){
		this.symbol = " ";
		this.ask = 0;
		this.bid = 0;
	}

	/**
	 * c'tor that receives values and sets the members below
	 * @param stockSymbol
	 * @param ask
	 * @param bid
	 * @param date
	 */
	public Stock(String stockSymbol, float ask, float bid, Date date) {
			setSymbol(stockSymbol);
			setAsk(ask);
			setBid(bid);
			setDate(new Date(date.getTime()));
	}

	/**
	 * copy c'tor of the Stock.
	 * @param stock
	 */
	public Stock(Stock stock){
		this(stock.getSymbol(),stock.getAsk(),stock.getBid(),new Date(stock.getDate().getTime()));
	}

    //Setters & getters
	public String getSymbol (){
		return symbol;
	}

	public float getAsk (){
		return ask;
	}

	public float getBid (){
		return bid;
	}

	public Date getDate (){
		return date;
	}


	public void setSymbol (String symbol){
		this.symbol = symbol;
	}

	public void setAsk (float ask){
		this.ask = ask;
	}

	public void setBid (float bid){
		this.bid = bid;
	}

	public void setDate (Date date){
		this.date = date;
	}

    // create Html string of all the members values
	public String getHtmlDescription(){
		String stockHtmlDetailsString = "<b>Stock symbol</b>: " + getSymbol() 
				+ " , <b>ask</b>: " + getAsk() + " , <b>bid</b>: "
				+getBid()+ " , <b>date</b>: " +new SimpleDateFormat("dd-MM-yyyy").format(date);
		return stockHtmlDetailsString;
	}
}