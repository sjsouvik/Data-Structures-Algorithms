/*
Given two arrays A and B respectively of size N and M, the task is to print the count of elements in the intersection (or common elements) of the two arrays.

For this question, the intersection of two arrays can be defined as the set containing distinct common elements between the two arrays.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and M, N is the size of array A and M 
is the size of array B. The second line of each test case contains N input A[i].

The third line of each test case contains M input B[i].

Output:
Print the count of intersecting elements.

User Task:
The task is to complete the function NumberofElementsInIntersection which takes 4 inputs ie- array a, array b, n which is the size of array a, m which is 
the size of array b. The function should return the count of the number of elements in the intersection.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(min(N,M)).

Constraints:
1 ≤ T ≤ 100
1 ≤ N, M ≤ 105
1 ≤ A[i], B[i] ≤ 105

Example:
Input:
4
5 3
89 24 75 11 23
89 2 4
6 5
1 2 3 4 5 6
3 4 5 6 7
4 4
10 10 10 10
20 20 20 20
3 3
10 10 10
10 10 10
Output:
1
4
0
1
Explanation:
Testcase 1: 89 is the only element in the intersection of two arrays.
Testcase 2: 3 4 5 and 6 are the elements in the intersection of two arrays.

*************************************************************************Solution***************************************************************************/

import java.io.*;
import java.util.*;

class GFG 
{
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n,m;

		    n=sc.nextInt();
		    m=sc.nextInt();

		    int a[]=new int[n];
		    int b[]=new int[m];

		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }

		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    
		    System.out.println(NumberofElementsInIntersection(a,b,n,m));
		}
	}
	
	
public static int NumberofElementsInIntersection (int a[], int b[] , int n, int m)
{
    Set<Integer> s = new HashSet<Integer>();
    
    int c = 0;
    
    for(int i : a)
        s.add(i);
    
    for(int i : b)
    {
        if(s.contains(i)) //checking whether the element is present in the set or not and if it's there in set then increasing the count, removing the element from set so that we don't increase the count if we encounter again the same element in array 'b' 
        {
            c++;
            s.remove(i); //removing the element from set so that we don't increase the count if we encounter again the same element in array 'b' as array may contain duplicates 
        }
    }
    
    return c;
}








