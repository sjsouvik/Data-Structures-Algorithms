/*
You are given two numbers n and p. You need to find np.

Example 1:

Input:
n = 9 p = 9 
Output: 387420489‬
Explanation: 387420489 is the value 
obtained when 9 is raised to the 
power of 9.

Example 2:

Input:
n = 2 p = 9
Output: 512
Explanation: 512 is the value 
obtained when 2 is raised to 
the power of 9.  

Your Task:
You don't need to read input or print anything. You only need to complete the function RecursivePower() that takes n and p as parameters and returns np.

Expected Time Complexity: O(p).
Expected Auxiliary Space: O(p).

Constraints:
1 <= n <= 9
0 <=  p <= 9

*********************************************************************Solution******************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int p = sc.nextInt();
            
            System.out.println(new Power().RecursivePower(n,p));
        }
    }
}


class Power
{
    //time complexity of this solution is O(p)
    static int RecursivePower1(int n,int p)
    {
        if(p == 0)
            return 1;
        
        int ans = RecursivePower(n, p - 1); //this will given the value of (n ^ (p -1)), so if we multiply 'n' with it, we'll get (n ^ p)
        
        return n * ans;
    }
    
    //time complexity of this solution is O(logp)
    //here, the idea is to find out the value of (n ^ p) is to define (n ^ p) as (n ^ 2) ^ (p/2) if p is even, otherwise define it as n * ((n ^ 2) ^ (p/2))
    static int RecursivePower(int n,int p)
    {
        if(p == 0)
            return 1;
        
        //if p is even    
        if(p % 2 == 0)
            return RecursivePower(n * n, p / 2);
        
        //if p is odd    
        return n * RecursivePower(n * n, p / 2);
    }
}








