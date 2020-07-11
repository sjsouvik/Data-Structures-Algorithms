/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price 
for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of 
the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the size of the array. The 
second line of each test case contains N input C[i].

Output:
For each testcase, print the span values for all days.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ C[i] ≤ 800

Example:
Input:
2
7
100 80 60 70 60 75 85
6
10 4 5 90 120 80

Output:
1 1 1 2 1 4 6
1 1 2 4 5 1

********************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     stockSpan(a, n);   
    	 }
	 }
	 
	 /*The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, 
	 for which the price of the stock on the current day is less than or equal to its price on the given day.*/
	 static void stockSpan(int a[], int n)
	 {
	     /*in this problem, we need to find the index of previous greater element(i.e. position wise closest and on left side) and 
	     then difference of the current index and the index of previous greater element will give the span of the stock's price*/
	     
	     //will be storing index of array elements in the stack as we need the difference of the current index and the index of previous greater element to get the span of the stock's price
	     Stack<Integer> s = new Stack<Integer>();
	     
	     //index of the array element's represents the day and the element itself represents the stock's price
	     for(int i = 0; i < n; i++)
	     {
	         /*if the current element is greater than or equal to the element whose index is in the top of the stack then pop from stack until you get the index 
	         which holds the greater element than the current element since we need the index of previous greater element which will also be position wise closest and on left side*/

	         while((!s.isEmpty()) && a[i] >= a[s.peek()]) 
	            s.pop();
	           
	         //before pushing the element into the stack, we need to calculate the span for the current day   
	         
	         /*if the stack is empty which will in 2 cases : i) for the 1st element ii) if there's no previous greater element than the current element, in this case span will be (current element's index + 1)
	         else, span will be the difference of the current index and the index of previous greater element*/
	         System.out.print((s.isEmpty() ? (i+1) : (i - s.peek())) + " ");
	         
	         s.push(i); //pushing the index of the element
	     }
	     
	     System.out.println();
	 }
	 
}




