/*
A function f is defined as follows F(n)= (1) +(2*3) + (4*5*6) ... n. Given an integer n the task is to print the F(n)th term.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test contains an integer n.

Output:
For each test case print the nth term of the sequence. .

Constraints:
1 <= T <= 10
1 <= N <= 10

Example:
Input:
2
5
7
Output:
365527
6006997207

*********************************************************************Solution*******************************************************************************/

import java.util.*;

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
	         
	         System.out.println(sequence(n));
	     }
	 }
	 
	
	 static long sequence(int n)
	 {
	     if(n == 1)
                 return 1;

             long s = sequence(n - 1);
             long sum = s + mul(n, (n * ((n - 1)) / 2) + 1);
         
             return sum;
	 }
	 
	 
	 static long mul(int n, long i)
         {
             if(n == 1)
                 return i;
        
             return i * mul(n - 1, ++i);
         }
}


