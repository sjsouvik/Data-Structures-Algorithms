/*
There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. 
The task is to connect the ropes with minimum cost.

Example 1:

Input:
4
4 3 2 6

Output: 
29

Explanation:
For example if we are given 4
ropes of lengths 4, 3, 2 and 6. We can
connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Now we have three ropes of lengths 4, 6
and 5.
2) Now connect ropes of lengths 4 and 5.
Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all
ropes have connected.
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. Other ways of
connecting ropes would always have same
or more cost. For example, if we connect
4 and 6 first (we get three strings of 3,
2 and 10), then connect 10 and 3 (we get
two strings of 13 and 2). Finally we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.

Example 2:

Input:
5
4 2 7 6 9

Output: 
62

Your Task:
You are required to complete the method minCost() which takes 2 arguments and returns the minimum cost.

Expected Time Complexity : O(nlogn)
Expected Auxilliary Space : O(n)

Constraints:
1 ≤ N ≤ 100000
1 ≤ L[i] ≤ 106

********************************************************************Solution****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
    public static void main(String[] args) 
    {        
        //Taking input using class Scanner
        Scanner in = new Scanner(System.in);
        
        //Taking count of testcases
        int t = in.nextInt();
        while (t-- > 0) 
	{            
            //takling count of elements
            int n = in.nextInt();
            
            //Creating an array of size n
            long arr[] = new long[n];

            //inserting elements to the array
            for (int i = 0; i < n; ++i) arr[i] = in.nextLong();

            //calling minCost method of class solve
            System.out.println(new solve().minCost(arr, n));
        }
    }
}


class solve 
{
    /* If we observe the problem closely, we can notice that the lengths of the ropes which are picked first are included more than once in total cost. Therefore, the idea is to connect smallest two ropes first and recur for remaining ropes. 
           
        Following is complete algorithm for finding the minimum cost for connecting n ropes.
        Let there be n ropes of lengths stored in an array len[0..n-1]
        1) Create a min heap and insert all lengths into the min heap.
        2) Do following while number of elements in min heap is not one.
        ……a) Extract the minimum and second minimum from min heap
        ……b) Add the above two extracted values and insert the added value to the min-heap.
        ……c) Maintain a variable for total cost and keep incrementing it by the sum of extracted values.
        3) Return the value of this total cost.
    */
    long minCost(long a[], int n) 
    {
        Queue<Long> minHeap = new PriorityQueue<Long>();
        
        for(int i =0; i < n; i++)
            minHeap.add(a[i]);
        
        long cost = 0;
        
        while(minHeap.size() >= 2)
        {
            long x = minHeap.poll();
            long y = minHeap.poll();
            
            cost += (x + y);
            
            minHeap.add(x + y);
        }
        
        return cost;
    }
}







