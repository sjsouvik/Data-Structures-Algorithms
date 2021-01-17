/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

********************************************************************************************Solution*******************************************************************************************************/

class Solution 
{
    public int maxProfit(int[] prices) 
    {
        if(prices.length == 0)
            return 0;
        
        int buyStateProfit = -prices[0], sellStateProfit = 0, cooldownStateProfit = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            //Profit after current day's buy would be based on profit after previous cooldown
            int newBuyStateProfit = Integer.max(buyStateProfit, cooldownStateProfit - prices[i]);

            //Profit after current day's sell would be current day's price + profit after previous day's buy
            int newSellStateProfit = Integer.max(sellStateProfit, buyStateProfit + prices[i]);
            
            //Profit after current day's cooldown would be based on profit after previous day's sell 
            int newCooldownStateProfit = Integer.max(cooldownStateProfit, sellStateProfit);
            
            buyStateProfit = newBuyStateProfit;
            sellStateProfit = newSellStateProfit;
            cooldownStateProfit = newCooldownStateProfit;
        }
        
        return sellStateProfit;
    }
}