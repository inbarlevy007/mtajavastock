package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;
/**
 * 
 * @author Inbar Levy
 *
 */
public class StockStatus extends Stock {

	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	
	/**
	 * c'tor that init stockStatus & the inherit members .
	 */
	public StockStatus(){
		this.symbol = "None";
		this.bid = 0;
		this.ask = 0;
		this.date = null;
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}
	
	/**
	 * copy c'tor
	 * @param stockSymbol
	 * @param ask
	 * @param bid
	 * @param date
	 */
	public StockStatus(String symbol, float bid, float ask, Date date, ALGO_RECOMMENDATION recommendation, int stockQuantity){
		this.symbol = symbol;
		this.bid = bid;
		this.ask = ask;
		this.date = date;
		this.recommendation = recommendation;
		this.stockQuantity = stockQuantity;
	}
	
	/**
	 * copy c'tor that copies the instance "stockStatus".
	 * @param stockStatus
	 */
	public StockStatus(Stock stock){
		super(stock);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}
	
	/**
	 * copy c'tor of stockStatus.
	 * @param stockStatus
	 */
	public StockStatus(StockStatus stockStatus){
		this.symbol = stockStatus.symbol;
		this.ask = stockStatus.ask;
		this.bid = stockStatus.bid;
		this.date = new Date(stockStatus.date.getTime());
		this.recommendation = stockStatus.recommendation;
		this.stockQuantity = stockStatus.stockQuantity;
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
