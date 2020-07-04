/*
You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0

Input:
First line of the input contains an integer T denoting the number of test cases. Each test case consists of two lines. First line of each test case contains 
an Integer N denoting the size of the array, and the second line contains N space separated integers.

Output:
For each testcase, in a new line, print the total count of sub-arrays having their sum equal to 0.

Your Task:
Complete findSubarray function that takes array and its size as arguments and returns the total count of sub-arrays with 0 sum. The printing is done by the 
driver code.

Constraints:    
1 <= T <= 100
1<= N <= 107
-1010 <= Ai <= 1010

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space : O(N)

Example:
Input:
2
6
0 0 5 5 0 0
10
6 -1 -3 4 -2 2 4 6 -12 -7

Output:
6
4

Explanation:
Testcase1: The 6 subarrays are [0], [0], [0], [0], [0 0], and [0 0].
Testcase2: The 4 subarrays are [-1 -3 4], [-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]

***********************************************************************Solution****************************************************************************/

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    int arr[]=new int[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }

		    System.out.println(findSubarray(arr,n));
		}
		
	}


public static int findSubarray(int[] a ,int n) 
{
    int c = 0, prefixSum = 0;
    
    Map<Integer, ArrayList<Integer>> m = new HashMap<Integer, ArrayList<Integer>>();
    
    //this is to handle the case when subarray with 0 sum starts from index 0 - trickiest part of the solution to handle this edge case
    m.put(0, new ArrayList<Integer>()); //initializing the list
    m.get(0).add(-1); //adding the value to list after retrieving the value using the key
    
    for(int i = 0; i < n; i++)
    {
        prefixSum += a[i];
        
        //list to store value part of the HashMap
        ArrayList<Integer> l = new ArrayList<Integer>();
        
        // If sum already exists in the map there exists at-least one subarray ending at index i with 0 sum  
        if(m.containsKey(prefixSum))
        {
            //if prefixSum exists then will retrieve the value part using the key
            l = m.get(prefixSum);
            
            for(Integer v : l)
            {
                c++;
                //System.out.println(v+1+"..."+i); //this is to print the 1st and last index of the subarray
            }
        }
        
        //adding the index to the list before adding it to the HashMap
        l.add(i);
        m.put(prefixSum, l);
    }
    
    return c;
}
    
}
 






