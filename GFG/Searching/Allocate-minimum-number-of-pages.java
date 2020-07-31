/*
You are given N number of books. Every ith book has Pi number of pages. 

You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be 
allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages 
allocated to a student is minimum of those in all the other permutations, and print this minimum value. 

Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.
Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see explanation for better understanding).

Input:
The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:Each case begins with a single positive integer N 
denoting the number of books.The second line contains N space separated positive integers denoting the pages of each book.And the third line contains 
another integer M, denoting the number of students.

Output:
For each test case, output a single line containing minimum number of pages each student has to read for corresponding test case.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A [ i ] <= 106
1 <= M <= 106

Example:
Input:
2
4
12 34 67 90
2
3
15 17 20
2
Output:
113
32

Explaination:
Testcase 1:Allocation can be done in following ways:
{12} and {34, 67, 90}     Maximum Pages = 191
{12, 34} and {67, 90}     Maximum Pages = 157
{12, 34, 67} and {90}        Maximum Pages = 113

Therefore, the minimum of these cases is 113, which is selected as output.

Testcase 2: Allocation can be done in following ways:
{15} and {17, 20} Maximum pages = 37
{15, 17} and {20} Maximum Pages = 32

So, the output will be 32.

************************************************************************Solution***************************************************************************/

import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
    	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
    	     int t, n, k;
    	 
    	     t = Integer.parseInt(br.readLine());
    	 
    	     while(t-- > 0)
    	     {
    	         n = Integer.parseInt(br.readLine());
    	     
    	         int a[] = new int[n];
    	     
    	         //to take multiple integers as input
    	         String line = br.readLine();
    	         String strs[] = line.trim().split("\\s+");
    	         for(int i = 0; i < n; i++)
    	             a[i] = Integer.parseInt(strs[i]);
    	     
    	         k = Integer.parseInt(br.readLine());
    	     
    	         System.out.println(allocateMinNumberPages(a, n, k));   
    	     }
	 }
	 
	 /* logn number of iterations are required to do binary search and for each iteration, it'll check validity using isValid() method which takes 'n' number of iterations. So, overall solution complexity is O(nlogn) */ 
	 static long allocateMinNumberPages(int a[], int n, int k)
	 {
	     /* as number of books is less than number of students and we have to allocate at least 1 book to each student 
	        so in this case, book allotment is not possible */
	     if(n < k) 
	        return -1;
	     
	     long start = a[0], end = a[0], minOfMax = -1;
	     
	     //this is to initialise start as max of all array elements and end as sum of all array elements
	     for(int i = 1; i < n; i++)
	     {
	         end += a[i];
	         
	         if(a[i] > start)
	            start = a[i];
	     }
	     
	     while(start <= end)
	     {
	         long mid = start + ((end - start) / 2);
	         
	         if(isValid(a, n, k, mid))
	         {
	             minOfMax = mid; //this will hold one of the valid solution but then to get the most optimal one, we need check further on left side of search space
	             end = mid - 1;
	         }
	         else 
	            start = mid + 1;
	     }
	     
	     return minOfMax;
	 }
	 
	 //this method will take max 'n' number of iterations, so time complexity - O(n)
	 static boolean isValid(int a[], int n, int k, long max)
	 {
	     int student = 1;
	     long pages = 0;
	     
	     for(int i = 0; i < n; i++)
	     {
	         if(pages + a[i] > max)
	         {
	             student++;
	             pages = a[i];
	             
	             if(student > k)
	                return false;
	         }
	         else
	            pages += a[i];
	     }
	     
	     return true;
	 }	 
}




