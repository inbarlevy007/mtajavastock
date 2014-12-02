package com.mta.javacourse.model;

import java.util.Date;
 
public class Stock {
       
        //Data Members
        private String Symbol;
        private float Ask;
        private float Bid;
        private Date Date;
       
        //Setters and Getters--->
       
        public String getSymbol() {
                return Symbol;
        }
        public void setSymbol(String symbol) {
                Symbol = symbol;
        }
       
        public float getAsk() {
                return Ask;
        }
        public void setAsk(float ask) {
                Ask = ask;
        }
       
        public float getBid() {
                return Bid;
        }
        public void setBid(float bid) {
                Bid = bid;
        }
     
        public java.util.Date getDate() {
                return Date;
        }
        public void setDate(java.util.Date date) {
                Date = date;
        }
       
        public String getHtmlDescription()
        {
                String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getSymbol() + "<b> Stock Ask</b>: " +getAsk() + "<b> Bid</b>: " +getBid() + "<b> Stock Date</b>: " +getDate();
                return stockHtmlDetailsString;
        }
 
}