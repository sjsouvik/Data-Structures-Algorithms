/*
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two integers m and n 
denoting the size of the two arrays. The following two lines will contain both the arrays respectively.

Output:
Print the count of elements less than or equal to it in arr2 for each element in arr1.

Constraints:
1<=T<=100
1<=m,n<=10^5
1<=arr1[i],arr2[j]<=10^5

Example:
Input:
2
6 6
1 2 3 4 7 9
0 1 2 1 1 4
5 7
4 8 7 5 1
4 48 3 0 1 1 5

Output:
4 5 5 6 6 6 
5 6 6 6 3

*************************************************************************Solution***************************************************************************/

import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            GfG gfg = new GfG();
            gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            System.out.println();
        }
        
    }
}



class GfG
{
    public static void countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {       
       Arrays.sort(arr2); 
       
       for(int i=0;i<m;i++)
       {
           System.out.print(binarySearch(arr2, 0, n-1, arr1[i])+" ");
       }
    }
    
    static int binarySearch(int a[], int l, int r, int k)
    {
        int lastIndex = r;
        
        while(l<=r)
        {
            int m=l+((r-l)/2);
            
            if((a[m] <= k) && (m==lastIndex || a[m+1] > k))
                return m+1;
            else if(m < lastIndex && a[m] > k)
                r=m-1;
            else  //a[m] <= k && m < lastIndex
                l=m+1;
        }
        
        return 0; 
    }
}







