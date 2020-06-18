/*
Given an unsorted array of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these 
two numbers.

Note: If you find multiple answers then print the Smallest number found. Also, expected solution is O(n) time and constant extra space.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case 
contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the 
array.

Output:
Print B, the repeating number followed by A which is missing in a single line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ A[i] ≤ N

Example:
Input:
2
2
2 2
3 
1 3 3

Output:
2 1
3 2

Explanation:
Testcase 1: Repeating number is 2 and smallest positive missing number is 1.
Testcase 2: Repeating number is 3 and smallest positive missing number is 2.

*******************************************************************Solution******************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t=sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n=sc.nextInt();
    	     
    	     int a[]=new int[n];
    	     
    	     for(int i=0;i<n;i++)
    	        a[i]=sc.nextInt();
	        
    	     findMissingRepeating2(a, n);
    	 }
	 }
	 
	 
	 static void findMissingRepeating2(int a[], int n)
	 {
	     boolean visited[]=new boolean[n+1];
	     
	     Arrays.fill(visited, Boolean.FALSE);
	     
	     for(int i=0;i<n;i++)
	     {
	         if(visited[a[i]])
	            System.out.print(a[i]+" "); //Repeating element
	         
	         visited[a[i]]=true;   
	     }
	     
	     for(int i=1;i<n+1;i++)
	     {
	         if(!visited[i])
	         {
	             System.out.println(i); //Missing element
	             break;
	         }
	     }
	 }
	 
	 
	 //Using sum operations
	 static void findMissingRepeating(int a[], int n)
	 {
	     long sum=0, actualSum=0, repeating=0, missing=0;
	     
	     sum=(n * (n+1))/2;
	     
	     boolean visited[]=new boolean[n+1];
	     
	     for(int i=0;i<n;i++)
	     {
	         if(visited[a[i]])
	            repeating=a[i];
	         
	         actualSum+=a[i];
	         visited[a[i]]=true;   
	     }
	     
	     missing=sum - (actualSum - repeating);
	     System.out.println(repeating+" "+missing);
	 }
	 
}





