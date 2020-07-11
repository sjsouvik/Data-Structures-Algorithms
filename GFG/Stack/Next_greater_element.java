/*
Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their 
appearance in the array. If no such element exists, output -1 

Input:
The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The 
first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting 
the values/elements in the array A.

Output:
For each test case, print in a new line, the next greater element for each array element separated by space in order.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1018
Example:
Input
2
4
1 3 2 4
4
4 3 2 1
Output
3 4 4 -1
-1 -1 -1 -1

Explanation:
Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.

**********************************************************************Solution****************************************************************************/

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
    	     
    	     long a[] = new long[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextLong();
    	     
    	     nextGreaterElement(a, n);   
    	 }
	 }
	 
	 //Solution of this problem will be same as stock span or previous greater element problem except 2 things, here we will be scanning all elements right to left whereas in previous greater element problem, we did scan from left to right and also will be storing array elements here instead of index of elements
	 static void nextGreaterElement(long a[], int n)
	 {
	     Stack<Long> s = new Stack<Long>();
	     
	     ArrayList<Long> l = new ArrayList<Long>(); //this list will be holding the next greater element(position wise closest and on right side) for each array element which will be in reverse order as we are scanning from right to left
	     for(int i = n-1; i >= 0; i--)
	     {
	         while(s.isEmpty() == false && a[i] >= s.peek())
	            s.pop();
	            
	         l.add(s.isEmpty() ? -1 : s.peek());
	         s.push(a[i]);
	     }
	     
	     Collections.reverse(l); //this is to reverse the list containing the next greater element for each array element
	      
	     for(Long i : l)
	        System.out.print(i + " ");
	        
	     System.out.println();
	 }
	 
}




