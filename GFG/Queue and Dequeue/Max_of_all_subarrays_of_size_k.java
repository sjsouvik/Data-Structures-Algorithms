/*
Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting 
the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print the maximum for every subarray of size k.

Your Task:
This is a function problem. You only need to complete the function max_of_subarrays that returns an array of answer. The printing is automatically done 
by the driver code.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13
Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.
Testcase 2: Starting from first subarray of size k =, we have 10 as maximum. Moving the window forward maximum elements are as follows 10 10 10 15 15 90 90.

**********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
                        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            ArrayList <Integer> res = new solve().max_of_subarrays(arr, n, k);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}


class solve
{
    static ArrayList <Integer> max_of_subarrays(int a[], int n, int k)
    {
        Deque<Integer> dq = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        //Note : we'll be storing index of array items in the deque
        
        //if array size is 'n', window size is 'k' then there'll be total (n - k + 1) windows
        
        /*The idea is to keep a dequeu of size 'k' where will keep all elements in descending order, 
        to do that whenever the current element will be greater than the peek item of the deque, 
        we'll remove that item until we get a greater item than the current one. After that will add the current item into the deque.
        With this approach, the front of the deque will always hold the max element of the current window */
        
        //this is to traverse the 1st window
        for(int i = 0; i < k; i++)
        {
            while((!dq.isEmpty()) && a[dq.peekLast()] <= a[i]) //will remove all smaller or equal items than the current item from deque as those are not useful to get the solution
                dq.removeLast();
            
            dq.addLast(i);    
        }
        
        //to traverse rest of the windows (n - k)
        for(int i = k; i < n; i++)
        {
            res.add(a[dq.peek()]); //this is to store the max element of previous window
            
            if(dq.peek() == i - k) //this is to remove the element which is not part of current window, was part of previous window
                dq.removeFirst();
            
	    //again, follow the process that we followed for 1st window
            while(dq.isEmpty() == false && a[dq.peekLast()] <= a[i]) 
                dq.pollLast();
            
            dq.offerLast(i);  //addLast(), offer, offerLast() - all do the same operation, adds item at last  
        }
        
        res.add(a[dq.peek()]); //this is to store the max element of last window
        
        return res;
    }
}










