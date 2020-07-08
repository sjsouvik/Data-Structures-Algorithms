/*
Given an integer array and a non-negative integer k, count all distinct pairs with difference equal to k, i.e., A[ i ] - A[ j ] = k.


Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, the second line has the elements of the array and the third line consists of the 
difference k.

Output:

In each separate line print the number of times difference k exists between the elements of the array.


Constraints:

1 ≤ T ≤ 100
1 ≤ N≤ 100
0≤K≤100
0 ≤ A[i] ≤ 10000


Example:

Input:

3
5 
1 5 4 1 2
0
3
1 1 1
0
3 
1 5 3
2

Output:

1
1
2

****************************************************************************Solution************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 int t, n, k;
    	 
    	 Scanner sc = new Scanner(System.in);
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();
    	     
    	     k = sc.nextInt();
    	     
    	     System.out.println(countDistinctPairs(a, n, k));   
    	 }
	 }
	 
	
	 //Using hashing - O(n) solution with O(n) extra space
	 static int countDistinctPairs(int a[], int n, int k)
	 {
	     int c = 0;
	     
	     Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	     
	     for(int i = 0; i < n; i++)
	         m.put(a[i], m.getOrDefault(a[i], 0) + 1);   
	     
	     for(Map.Entry<Integer, Integer> i : m.entrySet())
	     {
    	     if(k == 0)
    	     {
    	         if(i.getValue() >= 2)
    	            c++;
    	     }
    	     else if(m.containsKey(i.getKey() + k))
        	    c++;
	     }
	     
	     return c;
	 }
	 
	 
	  //Using 2 pointer approach - but it doesn't handle the duplicate pairs case, in case of duplicate pairs also it'll increment the count
	 //O(nlogn) solution
	 static int countDistinctPairs2(int a[], int n, int k)
	 {
	     Arrays.sort(a);
	     
	     int l = 0, r = 0, c = 0;
	     
	     while(r < n)
	     {
	         if(a[r] - a[l] == k)
	         {
	             c++;
	             l++;
	             r++;
	         }
	         else if(a[r] - a[l] > k)
	            l++;
	         else //a[r] - a[l] < k
	            r++;
	     }
	     
	     return c;
	 }
	 
}


