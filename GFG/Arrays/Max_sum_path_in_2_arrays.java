/*
Given two sorted arrays A and B, such that the arrays may have some common elements. Find the sum of the maximum sum path to reach from the beginning of 
any array to end of any of the two arrays. We can switch from one array to another array only at the common elements.

Input:
First line of input contains number of testcases T. For each testcase, there will be three lines. First line contains M and N denoting the length of the 
two sorted array A and B respectively. Second line contains elements of array A. Third line contains elements of array B.

Output:
For each test case, the output is the max sum obtained from the two arrays.

Your Task:
Complete the function max_path_sum() that takes the two arrays A and B along with their sizes M and N as input parameters. It returns the sum of the 
maximum sum path.

Expected Time Complexity: O(M + N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 100
1 <= M,N <= 105
1 <= A[i], B[i] <= 106

Example:
Sample Input:
2
5 4
2 3 7 10 12
1 5 7 8 
3 3
1 2 4
1 2 7

Sample Output:
35 
10

Explanation:
Testcase 1: The path will be 1+5+7+10+12 = 35.
Testcase 2: The path will be 1+2+7=10.

***************************************************************Solution*********************************************************************************/

import java.util.*;

class ArrPathSum1
{	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		GfG g = new GfG();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}

class GfG
{   
    int maxPathSum(int a1[], int a2[])
    {        
        int sum1=0, sum2=0, sum=0, i=0, j=0;
        
        while(i < a1.length && j < a2.length)
        {
            if(a1[i] < a2[j])
            {
                sum1+=a1[i];
                i++;
            }
            
            else if(a2[j] < a1[i])
            {
                sum2+=a2[j];
                j++;
            }
            
            else // a1[i]==a2[j]
            {
                sum+=Integer.max(sum1, sum2) + a1[i];
                
                i++;
                j++;
                
                sum1=0;
                sum2=0;
            }
        }
        
        //if any elements are left in array a1 to be processed
        while(i < a1.length)
        {
            sum1+=a1[i];
            i++;
        }
        
        //if any elements are left in array a2 to be processed
        while(j < a2.length)
        {
            sum2+=a2[j];
            j++;
        }
        
        sum+=Integer.max(sum1, sum2);
        
        return sum;
    }
    
}










