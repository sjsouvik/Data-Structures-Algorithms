/*

Given an integer x. The task is to find the square root of x. If x is not a perfect square, then return floor(√x).

Input:
First line of input contains number of testcases T. For each testcase, the only line contains the number x.

Output:
For each testcase, print square root of given integer.

User Task:
The task is to complete the function floorSqrt() which should return the square root of given number x.

Constraints:
1 ≤ T ≤ 1000
1 ≤ x ≤ 107

Example:
Input:
2
5
4
Output:
2
2

Explanation:
Testcase 1: Since, 5 is not perfect square, so floor of square_root of 5 is 2.
Testcase 2: Since, 4 is a perfect square, so its square root is 2.

***********************************************************************Solution*******************************************************************************/

import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			long a = sc.nextInt();
			SquareRoot obj = new SquareRoot();
			System.out.println(obj.floorSqrt(a));		
		}
	}
}


// Function to find square root
// x: element to find square root

class SquareRoot
{
     long floorSqrt(long x)
	 {		
		long start = 1, end = x, ans=-1;
		while(start <= end)
		{
		    long m = start + ((end - start)/2);
		   
		    if(m*m == x)
		    {
		        ans = m;
		        break;
		    }
		    else if(m*m < x)
		    {
		        ans = m;
		        start = m + 1;
		    }
		    else
		        end = m - 1;
		}
		return ans;
	 }
}





