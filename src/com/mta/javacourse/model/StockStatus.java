package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;


public class StockStatus extends Stock {

	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

	/**
	 * c'tor that init stockStatus & the inherit members .
	 */
	public StockStatus() {
		stockSymbol = "None";
		ask = 0;
		bid = 0;
		recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}
	public StockStatus(Stock stock){
		super(stock);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}


	/**
	 * copy c'tor that copies the instance "stockStatus".
	 * @param stockStatus
	 */
	public StockStatus(StockStatus stockStatus)
	{
		this();
		setStockSymbol(stockStatus.stockSymbol);
		setAsk(stockStatus.ask);
		setBid(stockStatus.bid);
		this.date = new Date(stockStatus.date.getTime());
		setRecommendation(stockStatus.recommendation);
		setStockQuantity(stockStatus.stockQuantity);
	}
	/**
	 * copy c'tor
	 * @param stockSymbol
	 * @param ask
	 * @param bid
	 * @param date
	 */
	
	public StockStatus(String stockSymbol, float ask, float bid, Date date) {
		this();
		
		setStockSymbol(stockSymbol);
		setAsk(ask);
		setBid(bid);
		setDate(new Date(date.getTime()));
	}
	
	/**
	 * getters & setters
	 * @return
	 */
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
