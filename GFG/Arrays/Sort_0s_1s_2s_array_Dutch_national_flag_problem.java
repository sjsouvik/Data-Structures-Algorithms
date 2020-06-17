/*
Given an array of size N containing 0s, 1s, and 2s; sort the array in ascending order.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines, first of which will contain N. The second lines contains 
the elements of the array.

Output: 
Print sorted array.

Your Task:
Complete the function sort012() that takes array and n and sorts the array in place. 

Constraints: 
1 <= T <= 50
1 <= N <= 10^5
0 <= A[i] <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.

**********************************************************************Solution***************************************************************************/

import java.io.*;
import java.util.*;

class GFG 
{

// Linear-time partition routine to sort an array containing 0, 1 and 2
// It similar to three-way Partitioning for Dutch national flag problem
public static void sort012(int a[], int n)
{
    int start=0, mid=0, end=n-1, pivot=1;
    
    while(mid <= end)
    {
        if(a[mid] < pivot) // current element is 0
        {
            swap(a, mid, start);
            start++;
            mid++;
        }
        else if(a[mid] > pivot) // current element is 2
        {
            swap(a, mid, end);
            end--;
        }
        else //a[mid]==pivot --- current element is 1
            mid++;
    }
}


static void swap(int a[], int m, int n)
{
    int temp = a[m];
    a[m]=a[n];
    a[n]=temp;
}


public static void main (String[] args) throws IOException 
{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0)
	{
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++)
	    {
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}








