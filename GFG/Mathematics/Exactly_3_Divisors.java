

/*

Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Output:
For each testcase, in a new line, print the answer of each test case.

Your Task:
This is a function problem. You only need to complete the function exactly3Divisors() that takes N as parameter and returns count of numbers less than 
or equal to N with exactly 3 divisors.

Constraints :
1 <= T <= 105
1 <= N <= 109

*/

/*****Solution*****/


import java.io.*;
import java.util.*;
class Mathematics {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0)
		{
		    Divisors obj=new Divisors();
		    int N;
		    N=sc.nextInt();
		    
		    System.out.println(obj.exactly3Divisors(N));
		   
		    
		}
		
	}
}


class Divisors
{
    public boolean isPrime(int N)
    {
        for(int i=2;i<N;i++)
        {
            if(N%i==0)
            {
                return false;
            }
        }
        return true;
    }
    
    public int exactly3Divisors(int N)
    {
        int c=0;
        
        for(int i=2;i<=Math.sqrt(N);i++)
        {
            if(isPrime(i) && (i*i <= N))
                c++;
        }
        
        return c;
    }
}













