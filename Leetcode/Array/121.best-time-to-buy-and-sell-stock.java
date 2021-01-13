/*
You are given an array prices for which prices[i] is the price of a given stock on the ith day.

You are only permitted to complete at most one transaction. In other words, you can buy one and sell one share of the stock. You cannot sell a stock before you buy one.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
The answer is not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104

*********************************************************************************************Solution*****************************************************************************************************/

class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int profit = 0, leastPrice = prices[0];
        
        for(int i = 1; i < prices.length; i++)
        {                        
            //if we get any price which is less than the leat price then will update the least price
            if(prices[i] < leastPrice)
                leastPrice = prices[i];
            
            //if we get any price greater than the least price which will also give better profit then will update the profit
            else if(prices[i] - leastPrice > profit)
                profit = prices[i] - leastPrice;
        }
        
        return profit;
    }
}