/*
Given an array A[] of N positive integers which can contain integers from 1 to N where elements can be repeated or can be absent from the array. Your task 
is to count frequency of all elements from 1 to N.

Note: Expected time complexity is O(n) with O(1) extra space.

Input:
First line of input contains an integer T denoting the number of test cases. For each test case, first line contains an integer N denoting the size of array. 
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each test case, output N space-separated integers denoting the frequency of each element from 1 to N.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 <= A[i] <= 106

Example:
Input:
2
5
2 3 2 3 5
4
3 3 3 3

Output:
0 2 2 0 1
0 0 4 0

Explanation:
Testcase 1: Counting frequencies of each array elements, we have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.

**********************************************************************Solution******************************************************************************/

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
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     frequencyOfElements(a, n);   
    	 }
	 }
	 
	 //O(n) solution without any extra space
	 static void frequencyOfElements(int a[], int n)
	 {
	     //subtracting 1 from each element so that the elements become in range from 0 to n-1(initially, it was in range from 1 to n)
	     for(int i = 0; i < n; i++)
	        a[i] -= 1;
	     
	     /*now, we are taking the advantage of the fact that array elements lies in the range of 0 to n-1 
	     and incrementing a[i % n] by n */
	     for(int i = 0; i < n; i++)
	        a[a[i] % n] += n;
	     
	     /*if a[i] > n then i+1 appears in the array a[i] / n times */
	     for(int i = 0; i < n; i++)
	        System.out.print(a[i] / n + " ");
	     
	     System.out.println();   
	 }
	 
	 //solution using map but O(n) extra space is needed for this
	 static void frequencyOfElements2(int a[], int n)
	 {
	     Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	     
	     for(int i = 0; i < n; i++)
	     {
	         if(m.containsKey(a[i]))
	            m.put(a[i], m.get(a[i]) + 1);
	         else
	            m.put(a[i], 1);
	     }
	     
	     for(int i = 1; i <= n; i++)
	     {
	         if(m.get(i) == null)
	            System.out.print(0+" ");
	         else
	            System.out.print(m.get(i)+" ");
	     }
	     
	     System.out.println();
	 }
	 
}





