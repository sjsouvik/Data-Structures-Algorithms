/*
Given an array A[] and a range [a, b]. The task is to partition the array around the range such that array is divided in three parts.
1) All elements smaller than a come first.
2) All elements in range a to b come next.
3) All elements greater than b appear in the end.
The individual elements of three sets can appear in any order. You are required to return the modified arranged array.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer 
N denoting the size of the array. Then in the next line are N space separated values of the array (A[]).Then the next line contains two space separated 
integers which denote the range(a,b).

Output:
For each test case the output will be 1 if the array is properly arranged else it would be 0.

User Task:
The task is to complete the function threeWayPartition() which should segregate the elements as required. The function returns an array.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
5
1 2 3 3 4
1 2
3
1 2 3
1 3
Output:
1
1

Explanation:
Testcase 1: First, array has elements less than or equal to 1. Then , elements between 1 and 2. And, finally elements greater than 2. So, output is 1.
Testcase 2: First, array has elements less than or equal to 1. Then, elements between 1 and 3. And, finally elements greater than 3. So, output is 1.

***********************************************************************Solution***************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;


class Three{
	public static void main(String[] args)throws IOException 
	{
		 BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
		 int t  =Integer.parseInt(read.readLine());
		 
		while(t-->0)
		{
    		int N = Integer.parseInt(read.readLine());
    		ArrayList<Integer> A=new ArrayList<>();
    		int[] hash=new int[1000001];
    		Arrays.fill(hash,0);
    		
    		String str[] = read.readLine().trim().split(" ");
    		for(int i=0;i<N;i++)
    		{
    		    int val = Integer.parseInt(str[i]);
    		    A.add(i,val);
    		
    		    hash[A.get(i)]++;
		    }
		    
		    str = read.readLine().trim().split(" ");
    		int n = Integer.parseInt(str[0]);
    		int m = Integer.parseInt(str[1]);
		
    		ArrayList<Integer> B=new ArrayList<>();
    		for(int i=0;i<A.size();i++)
    		{
    			B.add(i,A.get(i));
    		}
            int k1=0,k2=0,k3=0;
            int kk1=0;int kk2=0;int kk3=0;
            for(int i=0;i<B.size();i++)
            {
            	if(B.get(i)>m)
            	{
            		k3++;
            	}else if(B.get(i)<=m && B.get(i)>=n)
            	{
            		k2++;
            	}else if(B.get(i)<m)
            	k1++;
            }
    		GfG g = new GfG();
    		ArrayList<Integer> Res = g.threeWayPartition(A,n,m);
          	for(int i=0;i<k1;i++)
          	{
          		if(Res.get(i)<m)
          		kk1++;
          	}
          	for(int i=k1;i<k1+k2;i++)
          	{
          		
          		if(Res.get(i)<=m && Res.get(i)>=n)
          		kk2++;
          		
          	}
          	for(int i=k1+k2;i<k1+k2+k3;i++)
          	{
          		if(Res.get(i)>m)
          		kk3++;
          	}
          	boolean ok = false;
          	if(k1==kk1 && k2 ==kk2 && k3 == kk3)
          	ok = true;
    	
    	    for(int i=0;i<Res.size();i++)
          		hash[Res.get(i)]--;
          	
          	for(int i=0;i<Res.size();i++)
          	if(hash[Res.get(i)]!=0)
          	ok=false;
          	
        	if(ok)
        		System.out.println(1);
        		else
        		System.out.println(0);
        		}
	}
}


class GfG
{
	public ArrayList<Integer> threeWayPartition(ArrayList<Integer> A, int a, int b)
	{
        int start=0, end=A.size()-1, mid=0, pivot=a, pivot2=b;
        
        while(mid <= end)
        {
            if(A.get(mid) < pivot)
            {
                Collections.swap(A, mid, start);
                start++;
                mid++;
            }
            else if(A.get(mid) > pivot2)
            {
                Collections.swap(A, mid, end);
                end--;
            }
            else //if(A.get(mid) > pivot && A.get(mid) < pivot2)
                mid++;
        }
        
        return A;
    }
    
}








