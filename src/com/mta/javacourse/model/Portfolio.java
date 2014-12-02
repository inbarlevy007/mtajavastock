package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.*;

public class Portfolio {

	public final static int MAX_PORFOLIO_SIZE = 5;

	private String title = ("<h1><h1>Portfolio Title</h1>");

	private int portfolioSize = 0;

	private Stock[] stocks;
	private StockStatus[] stocksStatus;

	public Portfolio()
	{
		stocks = new Stock[MAX_PORFOLIO_SIZE];
		stocksStatus = new StockStatus[MAX_PORFOLIO_SIZE];
	}

	public void addStock(Stock s)
	{
		stocks [portfolioSize] = s;
		portfolioSize++;
	}

	public Stock[] getStocks()
	{
		return stocks;
	}

	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}
	
	public String getHtmlString()
	{
		String str = title;
		int i = 0;
		while (i < portfolioSize)
		{
			str+= stocks[i].getHtmlDescription() + "<br>";
			i++;
		}
		return str;
	}

	public class StockStatus {

		final static int DO_NOTHING = 0;
		final static int staticBUY = 1;
		final static int SELL = 2;

		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;

		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
		public float getCurrentBid() {
			return currentBid;
		}
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		public float getCurrentAsk() {
			return currentAsk;
		}
		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getRecommendation() {
			return recommendation;
		}
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		public int getStockQuantity() {
			return stockQuantity;
		}
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	}

}
