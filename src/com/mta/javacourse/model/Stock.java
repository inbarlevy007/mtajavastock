package com.mta.javacourse.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class Stock {
       
        //Members Definition
        protected String stockSymbol;
        protected float ask;
        protected float bid;
        protected Calendar basicDate = Calendar.getInstance();
        protected java.util.Date date = basicDate.getTime(); 
 		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
        /**
		 * c'tor that init the Stock members.
		 */
		
		public Stock(){
			this.stockSymbol = "";
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
			this();
			
			setStockSymbol(stockSymbol);
			setAsk(ask);
			setBid(bid);
			setDate(new Date(date.getTime()));
		}
		
		/**
		 * copy c'tor of the Stock.
		 * @param stock
		 */
		public Stock(Stock stock) {
			this(stock.stockSymbol, stock.ask, stock.bid,  new Date(stock.date.getTime()));			
		}
       
        //Setters & getters
	
        public String getStockSymbol() {
                return stockSymbol;
        }
        public void setStockSymbol(String symbol) {
        	stockSymbol = symbol;
        }
       
        public float getAsk() {
                return ask;
        }
        public void setAsk(float ask) {
                this.ask = ask;
        }
       
        public float getBid() {
                return bid;
        }
        public void setBid(float bid) {
                this.bid = bid;
        }
     
        public java.util.Date getDate() {
                return date;
        }
        public void setDate(java.util.Date date) {
                this.date = date;        }
       
        // create Html string of all the members values
        
        public String getHtmlDescription()
        {
        	    String dateString = df.format(date.getTime()) ;
                String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getStockSymbol()
                		+ "<b> Stock Ask</b>: " +getAsk() + "$ <b> Bid</b>: " +getBid() 
                		+ "$ <b> Stock Date</b>: " + dateString;
                
                return stockHtmlDetailsString;
        }
}