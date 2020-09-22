/*
Given a Binary Heap of size N, write a program to calculate the height of the Heap.

Input:
First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. The first line of each test case contains 
an integer N denoting the number of node in the Heap. Next line contains N space separated integers denoting the elements of the heap.

Output:
For each test case print the height of the Heap on a new line.

Constraints:
1<=T<=100
1<=N<=103

Example:
Input:
2
6
1 3 6 5 9 8
9
3 6 9 2 15 10 14 5 12
Output:
2
3
Explanation:
Testcase 1:

Input : N = 6
Output : 2
        (1)
       /    \
     (3)     (6)
    /  \    /
  (5)  (9) (8)

Testcase 2:

Input : N = 9
Output :
         (2)
      /       \
     (3)      (9)
    /  \     /   \
  (5) (15) (10)  (14)
  /  \
(6)  (12)

********************************************************************Solution**************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
     public static void main (String[] args) throws IOException
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
    	     
    	     height(n);   
    	 }
     }
	 
	/* This is how we calculate log base 2 of an integer in Java
	    We can calculate log2 N indirectly as:
        	log2 N = log10 N / log10 2 
    	*/
	 static void height(int n)
	 {
	     System.out.println((int)Math.floor(Math.log(n) / Math.log(2)));
	 }
}




