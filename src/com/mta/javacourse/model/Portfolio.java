package com.mta.javacourse.model;

import java.util.Date;

import com.google.appengine.api.appidentity.AppIdentityServicePb.SigningService.Method;
import com.mta.javacourse.*;
/**
 * 
 * @author Inbar Levy
 *
 */

public class Portfolio {

	public final static int MAX_PORTFOLIO_SIZE = 5;
	private  enum ALGO_RECOMMENDATION {DO_NOTHING,BUY,SELL};
	
	private float balance;
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
		balance = 0;
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
		setTitle("Portfolio Title");
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
	 * Print Error the user adds stocks more than MAX_PORTFOLIO_SIZE.
	 * @param stock
	 */
	public void addStock(Stock stock)
	{
		if(portfolioSize < stocks.length)
		{
			stocks[portfolioSize] = stock;
			stockStatus[portfolioSize] = new StockStatus(stock);
			portfolioSize++;
		}
		else
			System.out.println("Can't add new stock, portfolio can have only " + MAX_PORTFOLIO_SIZE +" stocks ");
	}
	/**
	 * Method that sells stock and update the balance accordingly.
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public boolean sellStock(String symbol, int quantity )
	{

		for(int i=0; i<stocks.length; i++)
			if(symbol.equals(stocks[i].getStockSymbol()))
			{
				if(quantity == -1) {
					float currentSell=stockStatus[i].getStockQuantity()*stockStatus[i].getCurrentBid();
					updateBalance(currentSell);
					stockStatus[i].setStockQuantity(0);
				}
				else if(stockStatus[i].getStockQuantity()-quantity < 0){
						System.out.println("Error, not enough stocks to sell");
				}
				else if (stockStatus[i].getStockQuantity()-quantity >= 0){
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()-quantity);
					float currentSell1 = quantity*stockStatus[i].getCurrentBid();
					updateBalance(currentSell1);
				}
				return true;
			}
		return false;
	}
	
	/**
	 * Method that buys stock and update the balance accordingly.
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public boolean buyStock(String symbol, int quantity )
	{

		for(int i=0; i<stocks.length;i++)
			if(symbol.equals(stocks[i].getStockSymbol()))
			{
				if( quantity == -1) {
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+ (int)(balance/stockStatus[i].getCurrentAsk()));
					float currentBuy = ((int)(balance/stockStatus[i].getCurrentAsk()) *stockStatus[i].getCurrentAsk())/(-1);
					updateBalance(currentBuy);

				}
				else{
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+quantity);
					float currentBuy1=(quantity*stockStatus[i].getCurrentAsk())/(-1);
					updateBalance(currentBuy1);
				}
				return true;
			}
		return false;
	}
	
	/**
	 * Method that receives a certain stock symbol and removes the right stock from portfolio.
	 * portfolioSize will change as well.
	 * @param stock
	 */
	
	public  boolean removeStock(String symbol)
	{
		sellStock(symbol,-1);
		for(int i=0; i<stocks.length;i++)
			if(symbol.equals(stocks[i].getStockSymbol()))
			{
				stocks[i] = stocks[portfolioSize-1];
				stocks[portfolioSize-1] =null;
				stockStatus[i] = stockStatus[portfolioSize-1];
				stockStatus[portfolioSize-1] =null;
				portfolioSize--;
				return true;
			}
		return false;
	}
	
	/**
	 * Method that adds to balance when the user sells/buys stocks.
	 * @param amount
	 */
	public void updateBalance(float amount)
	{
		balance += amount;
	}
	
	/**
	 * Method that sums the stocks value according to the current bid.
	 * @return
	 */
	public float getStocksValue()
	{
		float sumVal =0;
		
		for(int i =0; i<portfolioSize; i++)
			sumVal+=stockStatus[i].getStockQuantity() * stockStatus[i].getCurrentBid();

		return  sumVal;
	}
	/**
	 * Method that sums all the portfolio value.
	 * @return
	 */
	
	public float getTotalValue()
	{
		return getBalance() + getStocksValue();
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
	
	public float getBalance() {
		return balance;
	}
	
	public StockStatus[] getStocksStatus() {
		return stockStatus;
	}

	public void setStocksStatus(StockStatus[] stockStatus) {
		this.stockStatus = stockStatus;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	//Create an html string with the stock's members and their title
	
	public String getHtmlString()
	{
		String str = "<h1><center>" + getTitle() + "</center></h1>" + "<br/>";
		str +="<b> Total Portfolio Value: </b>" + getTotalValue() +"$, <b>Total Stocks Value: </b>"+ getStocksValue() + "$, <b>Balance: </b>"+ getBalance() +"$. <br/><br/>";
		
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

		private String symbol;
		private float currentBid, currentAsk;
		private Date date;
		private ALGO_RECOMMENDATION recommendation;
		private int stockQuantity;
		
		/**
		 * c'tor that init stockStatus members.
		 */
		public StockStatus() {
			symbol = "None";
			currentAsk = 0;
			currentBid = 0;
			recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
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
			this.date = new Date(stockStatus.date.getTime());
			setRecommendation(stockStatus.recommendation);
			setStockQuantity(stockStatus.stockQuantity);
		}
		
		/**
		 * copy c'tor that insert to stockStatus the stocks values.
		 * @param stock
		 */
		public StockStatus(Stock stock)
		{
			this();
			setSymbol(stock.getStockSymbol());
			setCurrentBid(stock.getBid());
			setCurrentAsk(stock.getAsk());
			setDate(new Date(stock.date.getTime()));
			setRecommendation(ALGO_RECOMMENDATION.DO_NOTHING);
			setStockQuantity(0);
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

}
