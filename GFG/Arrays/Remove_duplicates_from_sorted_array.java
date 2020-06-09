/*
Given a sorted array A of size N. The function remove_duplicate takes two arguments . The first argument is the sorted array A[ ] and the second argument 
is 'N' the size of the array and returns the size of the new converted array A[ ] with no duplicate element.

Input Format:
The first line of input contains T denoting the no of test cases . Then T test cases follow . The first line of each test case contains an Integer N and 
the next line contains N space separated values of the array A[ ] .

Output Format:
For each test case output will be the transformed array with no duplicates.

Your Task:
Your task to complete the function remove_duplicate which removes the duplicate  elements from the array .

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= A[ ] <= 106

Example:
Input  (To be used only for expected output) :
2
5
2 2 2 2 2 
3
1 2 2
Output
2
1 2

*********************************************************************Solution*****************************************************************************/

import java.util.Scanner;

class Delete_Duplicate
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int N = sc.nextInt();
			int a[] = new int[N];
			for(int i=0; i<N; i++)
				a[i] = sc.nextInt();
			
			GfG g = new GfG();
			int n = g.remove_duplicate(a,N);
			
			for(int i=0; i<n; i++)
			System.out.print(a[i]+" ");
			
			System.out.println();
			
		T--;
		}
	}
}


class GfG
{       
	int remove_duplicate(int a[], int n)
	{		
		int j=0;
		
		for(int i=0;i<n-1;i++)
		{
		    //this is to store only unique elements
		    if(a[i]!=a[i+1])
		    {
		        a[j]=a[i];
		        j++;
		    }
		}
		    
		a[j]=a[n-1];
		
		return j+1;
	}
}