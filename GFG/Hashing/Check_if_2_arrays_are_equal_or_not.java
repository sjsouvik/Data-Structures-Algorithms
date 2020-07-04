/*
Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same 
set of elements, arrangements (or permutation) of elements may be different though.

Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Input Format:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test case contains 3 lines of input. The first 
line contains an integer N denoting the size of the array. The second line contains element of array A[]. The third line contains elements of the array B[].

Output Format:
For each testcase in a new line print 1 if the arrays are equal else print 0.

Your Task:
Complete check function which takes both the given array and their size as function arguments and returns true if the arrays are equal else returns false.
The 0 and 1 printing is done by the driver code.

Constraints:
1<=T<=100
1<=N<=107
1<=A[],B[]<=1018

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(N)

Example:
Input:
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15

Output:
1
0

Explanation:
Testcase1:
Input : A[] = {1, 2, 5, 4, 0}; B[] = {2, 4, 5, 0, 1};
Output : 1

Testcase2:
Input : A[] = {1, 2, 5}; B[] = {2, 4, 15};
Output : 0 

**********************************************************************Solution*****************************************************************************/

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  
		  long a[]=new long[n];
		  long b[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      a[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      b[i]=sc.nextLong();
		  }
		  
		  System.out.println(check(a,b,n)==true?"1":"0");		  		  
		}
	}


public static boolean check(long a[],long b[],int n)
{    
    Map<Long, Long> m = new HashMap<Long, Long>();
    
    //Adding all elements of one of the arrays(array 'a') into a HashMap with its frequencies
    for(int i = 0; i < n; i++)
    {
        if(!m.containsKey(a[i])) //if array element is not present in the map then add it as key with count 1 as value
            m.put(a[i], (long)1);
        else //if it's already present then increase the count by retrieving the value using key and again add it
        {
            long c = m.get(a[i]);
            m.put(a[i], ++c);
        }
    }
    
    //then, traversing the other array and checking whether the array elements are present in the map or not
    for(int i = 0; i < n; i++)
    {
        //if an element of other array doesn't appear in map then we can say arrays are not equal
        if(!m.containsKey(b[i]))
            return false;
        
        // If an element of arr2[] appears more times than it appears in arr1[] then it'll get value as 0 since we'll decrease the count for each element once we find it in map    
        if(m.get(b[i]) == 0)
            return false;
        
        //decrease the count of element once we get it in map
        long c = m.get(b[i]);
        m.put(b[i], --c);
    }
        
    return true;
}

}   



