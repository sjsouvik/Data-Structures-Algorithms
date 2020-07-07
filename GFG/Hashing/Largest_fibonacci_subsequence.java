/*
Given an array with positive number the task to find the largest subsequence from array that contain elements which are Fibonacci numbers.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer N denoting the 
size of the array. Then in the next line are N space separated values of the array.

Output:
For each test case in a new line print the space separated elements of the  longest fibonacci subsequence.

Constraints:
1<=T<=100
1<=N<=100
1<=A[]<=1000

Example:
Input:
2
7
1 4 3 9 10 13 7
9
0 2 8 5 2 1 4 13 23

Output:
1 3 13
0 2 8 5 2 1 13 

*************************************************************************Solution**************************************************************************/

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
    	     
    	     Integer a[] = new Integer[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     fibonacciSubsequence(a, n);   
    	 }
	 }
	 
	 static void fibonacciSubsequence(Integer x[], int n)
	 {
	     Integer max = Collections.max(Arrays.asList(x)); //to get the max element of the array
	     
	     Set<Integer> s = new HashSet<Integer>();
	     
	     //adding all fibonacci numbers less than the max element into a set
	     Integer a = 0, b = 1, c = 0;
	     s.add(a);
	     s.add(b);
	     while(c < max)
	     {
	         c = a + b;
	         s.add(c);
	         a = b;
	         b = c;
	     }
	     
	     //iterating over the array and if cuurrent element is present in the set then printing the element
	     for(Integer i : x)
	     {
	         if(s.contains(i))
	            System.out.print(i + " ");
	     }
	     
	     System.out.println();
	 }
	 	 
}






