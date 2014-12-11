package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.*;

public class Portfolio {

	public final static int MAX_PORTFOLIO_SIZE = 5;

	private String title;
	private int portfolioSize;

	private Stock[] stocks;
	private StockStatus[] stockStatus;

	/**
	 * c'tor that init all of the portfolio members.
	 */
	public Portfolio()
	{
		portfolioSize = 0;
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
		this.title = "";
	}
	
	/**
	 * c'tor that sets & receives a title.
	 * @param title
	 */
	public Portfolio(String title)
	{
		this();
		this.setTitle(title);
	}
	
	/**
	 * copy c'tor that copies the instance "portfolio".
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio)
	{
		this(portfolio.getTitle());
		setPortfolioSize(portfolio.getPortfolioSize());
		
		for (int i = 0; i < portfolioSize; i++) {
			stocks[i] = new Stock(portfolio.getStocks()[i]);
		}
		
		for(int i = 0; i < portfolioSize; i++)
		{
			stockStatus[i] = new StockStatus(portfolio.getStockStatus()[i]);
		}
	}

	/**
	 * Method that adds a new stock to the portfolio.
	 * create new stockStatus when adding a new stock.
	 * @param stock
	 */
	public void addStock(Stock stock)
	{
		if(portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = stock;
			stockStatus[portfolioSize] = new StockStatus();
			portfolioSize++;
		}
	}
	
	/**
	 * Method that receives a certain stock and removes it from portfolio.
	 * portfolioSize will change as well.
	 * @param stock
	 */
	public void removeStock(Stock stock)
	{
		for(int i=0; i < portfolioSize; i++)
		{
			if(this.stocks[i].getStockSymbol().equals(stock.getStockSymbol()))
			{
				if(i != portfolioSize-1 && portfolioSize > 1)
					for(int l = i; l < portfolioSize-1; l++)
					{
						this.stocks[l] = new Stock(this.stocks[l+1]);
					}
			}
		}
		this.portfolioSize--;
	}
	//setters & getters
	
	public Stock[] getStocks()
	{
		return stocks;
	}
	
	public StockStatus[] getStockStatus() {
		return stockStatus;
	}
	
	public String getTitle(){
		return title;
	}
		
	public void setTitle(String title){
		this.title = title;
	}
		
	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public StockStatus[] getStocksStatus() {
		return stockStatus;
	}

	public void setStocksStatus(StockStatus[] stockStatus) {
		this.stockStatus = stockStatus;
	}
	
	//Create an html string with the stock's members and their title
	
	public String getHtmlString()
	{
		String str = "<h1>" + getTitle() + "</h1>" + "<br/>";
		int i = 0;
		while (i < portfolioSize)
		{
			str += stocks[i].getHtmlDescription() + "<br>";
			i++;
		}
		return str;
	}

	/**
	 * inner class that saves the stock's status.
	 * @author Inbar Levy
	 */
	public class StockStatus {

		final static int DO_NOTHING = 0;
		final static int BUY = 1;
		final static int SELL = 2;

		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;
		
		/**
		 * c'tor that init stockStatus members.
		 */
		public StockStatus() {
			symbol = "None";
			currentAsk = 0;
			currentBid = 0;
			date = new Date();
			recommendation = 0;
			stockQuantity = 0;
		}
		
		/**
		 * copy c'tor that copies the instance "stockStatus".
		 * @param stockStatus
		 */
		public StockStatus(StockStatus stockStatus)
		{
			this();
			setSymbol(stockStatus.symbol);
			setCurrentAsk(stockStatus.currentAsk);
			setCurrentBid(stockStatus.currentBid);
			setDate(stockStatus.date);
			setRecommendation(stockStatus.recommendation);
			setStockQuantity(stockStatus.stockQuantity);
		}
		
		//setters & getters

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
