/*
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two integers N and K. 
Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line print the space separated values denoting counts of distinct numbers in all windows of size k in the array A[].

Your Task:
You don't need to read input or print anything. Your task is to complete the function countDistinct() which takes the array A[], the size of the array(N) 
and the window size(K) as inputs and returns an array containing the count of distinct elements in every contiguous window of size K in the array A[].

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= K <= 105
1 <= A[i] <= 105 , for each valid i

Example:
Sample Input:
2
7 4
1 2 1 3 4 2 3
3 2
4 1 1

Sample Output:
3 4 4 3
2 1

Explanation:
Testcase 1 : 
Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

**********************************************************************Solution******************************************************************************/

import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();

            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 

            System.out.println();

            t--;
        }
    }
}


class Solution
{
    ArrayList<Integer> countDistinct(int a[], int n, int k)
    {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        ArrayList<Integer> op = new ArrayList<Integer>();
        
        //Adding all elements of 1st window into the Map
        for(int i = 0; i < k; i++)
        {
            if(m.containsKey(a[i]))
                m.put(a[i], m.get(a[i]) + 1);
            else
                m.put(a[i], 1);
        }
        
        //as we need count of distinct elements therefore, adding size of the map into the list
        op.add(m.size());
        
        //in the below part of the program, will remove the 1st element of the previous window and add the last element of the current window into the map
        for(int i = k; i < n; i++)
        {
            //this part is to remove the 1st element of the previous window of size 'k' since this element is no more a part of the current window
            if(m.get(a[i - k]) == 1) //if the count of 1st element of the previous window in the map is 1 then will remove it from map, otherwise decrease the count
                m.remove(a[i - k]);
            else
                m.put(a[i - k], m.get(a[i - k]) - 1);
            
            //this part is to add the last element of the current window of size 'k' since this element will become a part of the current window and others were there in the previous window also
            if(m.containsKey(a[i]))
                m.put(a[i], m.get(a[i]) + 1);
            else
                m.put(a[i], 1);
            
            op.add(m.size()); //adding size of the map into the list for each iteration as it's required to know the count of distinct elements in each window  
        }
        
        return op;
    }
}







