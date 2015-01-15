package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistException;

/**
 * 
 * @author Inbar Levy
 *
 */
public class Portfolio {

	public static final int MAX_PORTFOLIO_SIZE = 5;
	public static final int SELL_ALL = -1;
	public static final int BUY_ALL = -1;

	private int portfolioSize;
	private StockStatus[] stockStatus;
	private String title;
	private float balance;

	public enum ALGO_RECOMMENDATION {
		DO_NOTHING, BUY, SELL;		
	}

	/**
	 * c'tor that init all of the portfolio members.
	 */
	public Portfolio()
	{
		portfolioSize = 0;
		stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
		balance = 0;
		this.setTitle("New Portfolio");
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

		for(int i = 0; i < portfolioSize; i++)
		{
			stockStatus[i] = new StockStatus(portfolio.getStockStatus()[i]);
		}

	}

	/**
	 * Method that adds a new stockStatus to the portfolio.
	 * Print Error the user adds stocks more than MAX_PORTFOLIO_SIZE.
	 * * Print Error the user adds stock that's already exists.
	 * @param stock
	 * @throws StockAlreadyExistsException 
	 * @throws PortfolioFullException 
	 */
	public void addStock(Stock stock) throws StockAlreadyExistsException, PortfolioFullException 
	{
		for(int i=0; i < portfolioSize; i++)
		{
			if(this.stockStatus[i].getStockSymbol().equals(stock.getStockSymbol()))
			{
				throw new StockAlreadyExistsException();
			}
		}

		if(portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			this.stockStatus[portfolioSize] = new StockStatus();
			this.stockStatus[portfolioSize].setStockSymbol(stock.getStockSymbol());
			this.stockStatus[portfolioSize].setAsk(stock.getAsk());
			this.stockStatus[portfolioSize].setBid(stock.getBid());
			this.stockStatus[portfolioSize].setDate(new Date(stock.date.getTime()));
			portfolioSize++;
		}
		else
		{
			throw new PortfolioFullException();
		}
	}

	/**
	 * Method that sells stock and update the balance accordingly.
	 * @param symbol
	 * @param quantity
	 * @return
	 * @throws StockNotExistException 
	 */
	public void sellStock(String symbol, int quantity ) throws StockNotExistException
	{

		for(int i=0; i<portfolioSize; i++)
			if(this.stockStatus[i].getStockSymbol().equals(symbol))
			{
				if(quantity == -1) {
					float currentSell=stockStatus[i].getStockQuantity()*stockStatus[i].getBid();
					updateBalance(currentSell);
					stockStatus[i].setStockQuantity(0);
				}
				else if(stockStatus[i].getStockQuantity()-quantity < 0){
					System.out.println("Error, not enough stocks to sell");
				}
				else if (stockStatus[i].getStockQuantity()-quantity >= 0){
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()-quantity);
					float currentSell1 = quantity*stockStatus[i].getBid();
					updateBalance(currentSell1);
				}
				return;
			}
		throw new StockNotExistException();
	}

	/**
	 * Method that buys stock and update the balance accordingly.
	 * @param symbol
	 * @param quantity
	 * @return
	 * @throws StockNotExistException 
	 * @throws BalanceException 
	 */
	public void buyStock(String symbol, int quantity ) throws StockNotExistException, BalanceException
	{
		
		for(int i=0; i<stockStatus.length;i++)
			if(symbol.equals(stockStatus[i].getStockSymbol()))
			{
				int maxQuantityToBuy = (int) (balance/stockStatus[i].getAsk());

				if( quantity == -1) {
					stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+ (int)(balance/stockStatus[i].getAsk()));
					float currentBuy = (maxQuantityToBuy *stockStatus[i].getAsk())/(-1);
					updateBalance(currentBuy);
					return;

				}
				else if(maxQuantityToBuy < quantity){
					throw new BalanceException();
				}
				stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity()+quantity);
				float currentBuy1=(quantity*stockStatus[i].getAsk())/(-1);
				updateBalance(currentBuy1);
				return;
			}
		throw new StockNotExistException();
	}

	/**
	 * Method that receives a certain stock symbol and removes the right stock from portfolio.
	 * portfolioSize will change as well.
	 * @param stock
	 * @throws StockNotExistException 
	 */
	public  void removeStock(String symbol) throws StockNotExistException
	{
		sellStock(symbol,-1);
		for(int i=0; i<stockStatus.length;i++)
			if(symbol.equals(stockStatus[i].getStockSymbol()))
			{
				stockStatus[i] = stockStatus[portfolioSize-1];
				stockStatus[portfolioSize-1] =null;
				stockStatus[i] = stockStatus[portfolioSize-1];
				stockStatus[portfolioSize-1] =null;
				portfolioSize--;
				return;
			}
		throw new StockNotExistException();
	}

	/**
	 * Method that sums the stocks value according to the current bid.
	 * @return
	 */
	public float getStocksValue()
	{
		float sum = 0;
		for(int i=0; i < portfolioSize; i++)
		{
			sum += stockStatus[i].getStockQuantity() * stockStatus[i].getBid();
		}
		return sum;
	}


	/**
	 * Method that sums all the portfolio value.
	 * @return
	 */

	public float getTotalValue()
	{
		return getStocksValue() + getBalance();
	}

	/**
	 * Method that adds to balance when the user sells/buys stocks.
	 * @param amount
	 */
	public void updateBalance(float amount){
		if (balance + amount < 0){
			System.out.println("Error, there is not enough balance to spend.");
		}
		else
		{
			balance += amount;
		}
	}

	//Getters & Setters:
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public StockStatus[] getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus[] stockStatus) {
		this.stockStatus = stockStatus;
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

	//Create an html string with the stock's members and their title

	public String getHtmlString()
	{
		String str = "<font color=pink>" + "<h1><center>" +getTitle() + "</center></h1>" + "</font></h1>" + "<br/> ";
		str += "<b>Total Portfolio Value:</b> " + getTotalValue() +
				"$, <b>Total Stocks Value:</b> " + getStocksValue() +
				"$, <b>Balance:</b> " + getBalance() + "$<br/>";
		for(int i = 0; i < portfolioSize; i++)
		{
			str += stockStatus[i].getHtmlDescription() + ", <b>Quantity:</b> " + stockStatus[i].getStockQuantity() +"<br/>";
		}
		return str;
	}

}
