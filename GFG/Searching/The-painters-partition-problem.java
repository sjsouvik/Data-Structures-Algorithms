/*
Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An]. He hired k painters for this work and each painter 
takes 1 unit time to paint 1 unit of the board.The problem is to find the minimum time to get this job done under the constraints that any painter will 
only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Input:
The first line consists of a single integer T, the number of test cases. For each test case, the first line contains an integer k denoting the number of 
painters and integer n denoting the number of boards. Next line contains n- space separated integers denoting the size of boards.

Output:
For each test case, the output is an integer displaying the minimum time for painting that house.

Constraints:
1<=T<=100
1<=k<=30
1<=n<=50
1<=A[i]<=500

Example:
Input:
2
2 4
10 10 10 10
2 4
10 20 30 40
Output:
20
60

Explanation:
1. Here we can divide the boards into 2 equal sized partitions, so each painter gets 20 units of the board and the total time taken is 20.
2. Here we can divide first 3 boards for one painter and the last board for the second painter.

**********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     
    	     int t, n, k;
    	 
    	     t = Integer.parseInt(br.readLine());
    	 
    	     while(t-- > 0)
    	     {
    	         String l = br.readLine();
    	         String s[] = l.split(" ");
    	         k = Integer.parseInt(s[0]);
    	         n = Integer.parseInt(s[1]);
    	     
    	         int a[] = new int[n];
    	     
    	         //to read multiple integers
    	         String line = br.readLine();
    	         String strs[] = line.trim().split("\\s+");
    	     
    	         //array elements input
    	         for(int i = 0; i < n; i++)
    	             a[i] = Integer.parseInt(strs[i]);
    	     
    	         //using StringBuffer to append each output in a string
    	         StringBuffer sb = new StringBuffer();
    	     
    	         sb.append(paintersPartition(a, n, k));
    	     
    	         //finally print the string
    	         System.out.println(sb);
    	     }
	 }
	 
	 /* the idea is to divide the entire painiting work among painters such that it will take minimum time to complete the entire job */
	 static int paintersPartition(int a[], int n, int k)
	 {
	     int start = a[0], end = a[0], minOfMax = -1;
	     
	     //this is to initialise start as max of all array elements and end as sum of all array elements
	     for(int i = 1; i < n; i++)
	     {
	         end += a[i];
	         
	         if(a[i] > start)
	            start = a[i];
	     }
	     
	     while(start <= end)
	     {
	         int mid = start + ((end - start) / 2);
	         
	         if(isValid(a, n, k, mid))
	         {
	             minOfMax = mid; //this will hold one of the valid solution but then to get the most optimal one, we need check further on left side of search space
	             end = mid - 1;
	         }
	         else
	            start = mid + 1;
	     }
	     
	     return minOfMax;
	 }
	 
	 //this is to check whether the amount of work allows to divide the entire job among painters or not
	 static boolean isValid(int a[], int n, int k, int max)
	 {
	     int painter = 1, sum = 0;
	     
	     for(int i = 0; i < n; i++)
	     {
	         if(sum + a[i] > max)
	         {
	             painter++;
	             sum = a[i];
	             
	             if(painter > k)
	                return false;
	         }
	         else
	            sum += a[i];
	     }
	     
	     return true;
	 }
}
