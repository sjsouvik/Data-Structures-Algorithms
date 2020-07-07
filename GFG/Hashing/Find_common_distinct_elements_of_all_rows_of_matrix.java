/*
Given a N x N matrix. Write a program to find count of all the distinct elements common to all rows of the matrix. Print count of such elements.

Input:
First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains a 
single integer N which denotes the dimension of matrix. Second line of each test case contains N*N space separated integers which denotes elements of 
the matrix.

Output:
For each test case, print count of all the distinct elements common to all rows of the matrix.

Constraints:
1 <= T <= 100
1 <= N <= 1000

Example:
Input:
2
4
2 1 4 3 1 2 3 2 3 6 2 3 5 2 5 3
5
12 1 14 3 16 14 2 1 3 35 14 1 14 3 11 14 25 3 2 1 1 18 3 21 14

Output:
2
3

*********************************************************************Solution*******************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 int t, n;
    	 
    	 Scanner sc = new Scanner(System.in);
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     int a[][] = new int[n][n];
    	     
    	     for(int i = 0; i < n; i++)
    	     {
    	         for(int j = 0; j < n; j++)
    	            a[i][j] = sc.nextInt();
    	     }
    	     
    	     System.out.println(noOfDistinctElements(a, n));   
    	 }
	 }
	 
	 //In simple words, this is to find the size of intersection set of all rows of a matrix
	 static int noOfDistinctElements(int a[][], int n)
	 {
	     Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	     
	     //putting all elements of 1st row into a map with value as 1 as we need to consider distinct element only
	     for(int i = 0; i < n; i++)
	        m.put(a[0][i], 1);
	     
	     for(int i = 1; i < n; i++)
	     {
	         for(int j = 0; j < n; j++)
	         {
	             /*now for remaining rows, checking elements are present or not in the map, 
	             if present then need to check the value is equal to the current row no or not, 
	             if it satisfies the condition then increment value by 1. This check also handle the duplicate elements */
	             if(m.containsKey(a[i][j]) && m.get(a[i][j]) == i)
	                m.put(a[i][j], i + 1);
	         }
	     }
	     
	     //iterate over each entry in the map and count number of keys having their value equal to number of rows in the matrix
	     int c = 0;
	     for(Map.Entry<Integer, Integer> k : m.entrySet())
	     {
	         if(k.getValue() == n)
	            c++;
	     }
	     
	     return c;
	 }
	 
}





