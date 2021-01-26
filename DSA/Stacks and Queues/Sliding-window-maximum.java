/*
Question:-

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]

Input Format:-

Input is managed for you

Output Format:-

Maximum of each window in separate line

Constraints:-

0 <= n < 100000
-10^9 <= a[i] <= 10^9
0 < k < n

Sample Input:-

1
3
-1
-3
5
3
6
7

Sample Output:-

3
3
5
5
6
7

******************************************************************************************Solution*************************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) 
            a[i] = Integer.parseInt(br.readLine());
        
        int k = Integer.parseInt(br.readLine());
        
        int res[] = slidingMax(a, k);
        
        for(int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
    
    static int[] slidingMax(int a[], int k)
    {
        int res[] = new int[a.length];
        Stack<Integer> st = new Stack<>();
        
        //this is to calculate next greater element to the right for each element
        for(int i = a.length - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && a[st.peek()] <= a[i])
                st.pop();
                
            res[i] = st.isEmpty() ? a.length : st.peek();    
            
            st.push(i);
        }
        
        /* the idea is to find next greater element for each item in the current window until you find a next greater element 
        which is not present in the current window. So, if you get an element in current window for which the next greater 
        element is not in the current window i.e. all other elements in the current window is smaller or equal to the current 
        element i.e. current element is the max element in the current window. */ 
        
        //number of windows = array.length - windowSize(k here) + 1
        int ans[] = new int[res.length - k + 1]; 
        int j = 0;
        
        for(int i = 0; i < res.length - k + 1; i++)
        {
            if(j < i)
                j = i;
                
            while(res[j] < i + k)
                j = res[j];
            
            ans[i] = a[j];    
        }
        
        return ans;
    }
}