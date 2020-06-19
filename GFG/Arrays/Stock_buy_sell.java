/*
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your 
profit is maximum.

Input: 
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of 
stock prices of N days. 

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
3
7
100 180 260 310 40 535 695
4
100 50 30 20
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
No Profit
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.

*********************************************************************Solution*******************************************************************************/

import java.util.Scanner;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
	        
    	     stockBuySell(a, n);
    	 }
	 }
	 
	 //In simple words, this is a problem where there are some local minimum and some local maximum(or, peak) elements and we need to find the positions of those elements
	 static void stockBuySell(int a[], int n)
	 {
	     int j=0, profit=-1;
	     
	     for(int i=1;i<n;i++)
	     {
	         if(a[i-1] > a[i])
	            j=i; //to store position of local minimum
	         
	         if(a[i-1] <= a[i] && (i+1 == n || a[i] > a[i+1])) 
	         {
	             profit+=(a[j] - a[i]); //this is to store the maximum profit, however it's not required to show as output in this problem, still can use to show whether there's any profit or not 
	             System.out.print("("+j+" "+i+") ");
	         }
	     }
	     
	     if(profit==-1)
	        System.out.print("No Profit");
	     
	     System.out.println();   
	 }
	 
}



