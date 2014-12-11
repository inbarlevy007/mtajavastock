package com.mta.javacourse.model;

import java.util.Date;
 
public class Stock {
       
        //Members Definition
        private String stockSymbol;
        private float ask;
        private float bid;
        private Date date;
        
        /**
		 * c'tor that init all of the Stock members.
		 */
		public Stock(){
			this.stockSymbol = "";
			this.ask = 0;
			this.bid = 0;
			this.date = new Date();
		}
		
		/**
		 * c'tor that receives values and sets the members below
		 * @param stockSymbol
		 * @param ask
		 * @param bid
		 * @param date
		 */
		public Stock(String stockSymbol, float ask, float bid, java.util.Date date) {
			this();
			
			setStockSymbol(stockSymbol);
			setAsk(ask);
			setBid(bid);
			setDate(date);
		}
		
		/**
		 * copy c'tor of the Stock.
		 * @param stock
		 */
		public Stock(Stock stock) {
			this(stock.stockSymbol, stock.ask, stock.bid, stock.date);			
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
                String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getStockSymbol()
                		+ "<b> Stock Ask</b>: " +getAsk() + "<b> Bid</b>: " +getBid() 
                		+ "<b> Stock Date</b>: " +getDate();
                return stockHtmlDetailsString;
        }
 
}