/*
Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one element extra added in between. Find the 
index of the extra element.

Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. The first line of each test case contains an 
integer N, denoting the number of elements in array. The second line of each test case contains N space separated values of the array A[]. The Third 
line of each test case contains N-1 space separated values of the array B[].

Output:
Return the index (0 based indexing) of the corresponding extra element in array A[].(starting index 0).

User Task:
You don't have to take any input. Just complete the provided function findExtra() that takes array A[], B[] and size of A[] and return the valid index 
(0 based indexing).

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1<=T<=100
2<=N<=104
1<=Ai<=105

Example:
Input:
2
7
2 4 6 8 9 10 12
2 4 6 8 10 12
6
3 5 7 9 11 13
3 5 7 11 13
Output:
4
3

Explanation:
Testcase 1: In the second array, 9 is missing and it's index in the first array is 4.
Testcase 2: In the second array, 9 is missing and it's index in the first array is 3.

*****************************************************************Solution*********************************************************************************/

import java.util.*;

class ExtraElement 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
	{
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            GfG g = new GfG();
            System.out.println(g.findExtra(a, b, n));
        }
    }
}


class GfG {
    public int findExtra(int a[], int b[], int n) 
    {
        int start = 0, end = n - 1;
        
        while(start <= end)
        {
            int mid = start + ((end - start) / 2);
            
            //if both the arrays have same element at mid index but doesn't have same element at (mid + 1) then the extra element is present at index (mid + 1)
            if(mid < n - 2 && a[mid] == b[mid] && a[mid + 1] != b[mid + 1])
                return mid + 1;
            
            /* we'll come to this condition if the 1st condition satisfies i.e. either both the arrays have same element at index mid and (mid + 1) or have different elements at both the indexes. 
               So, we'll now check whether both the arrays have same element at mid index or not, if mid index has same element in both arrays then will search in the (mid + 1) and end search space to get the index of extra element*/    
            else if(mid < n - 1 && a[mid] == b[mid])
                start = mid + 1;
            
            //if none of the above conditions satisfy that means extra element is present in the left side of the array     
            else
                end = mid - 1;
        }
        
        return start; //if the extra element is present at first or last index then after processing all array elements, start will be at first or last index of the array and end will be at (start - 1), so in these cases we can return start or (end + 1) 
    }
}





