package com.interviewcake.solutions;

class Problem1 {

    public static int getMaxProfit(int[] stockPricesYesterday) {

        if(stockPricesYesterday==null || stockPricesYesterday.length <2)
        throw new IllegalArgumentException("Max Profit Cannot be calculated.");
        // calculate max profit
        int len = stockPricesYesterday.length;
        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1]-minPrice;
        
        for(int currentPrice : stockPricesYesterday){
            int potentialProfit = currentPrice-minPrice;
            maxProfit = Math.max(maxProfit,potentialProfit);
            
            minPrice = Math.min(minPrice,currentPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {10, 7, 5, 11, 9};
        System.out.println(getMaxProfit(stockPrices));
    }
}
