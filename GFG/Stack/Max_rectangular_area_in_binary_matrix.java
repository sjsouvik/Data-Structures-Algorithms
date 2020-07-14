/*
Given a binary matrix. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Input:
The first line of input is an integer T denoting the no of test cases . Then T test cases follow. The first line of each test case are 2 integers n and m 
denoting the size of the matrix M . Then in the next line are n*m space separated values of the matrix M.

Output:
For each test case output will be the area of the maximum rectangle .

Your Task: 
Your task is to complete the function maxArea which returns the maximum size rectangle area in a binary-sub-matrix with all 1’s. The function takes 3 
arguments the first argument is the Matrix M[ ] [ ] and the next two are two integers n and m which denotes the size of the matrix M. 

Expected Time Complexity : O(n*m)
Expected Auixiliary Space : O(m)

Constraints:
1<=T<=100
1<=n,m<=1000
0<=M[][]<=1

Example:
Input
1
4 4 
0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0

Output
8

Explanation
For the above test case the matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a 
function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

*********************************************************************Solution*******************************************************************************/

import java.util.*;
import java.lang.*;

class MaxRect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
            GfG g = new GfG();

            System.out.println(g.maxArea(a, m, n));
        }
    }
}


class GfG 
{
    //the idea is we need to find max area for each row of the given matrix by taking each row as histogram
    public int maxArea(int a[][], int m, int n) 
    {
        int arr[] = new int[n];
        
        for(int j = 0; j < n; j++)
            arr[j] = a[0][j];    //here, we are taking 1st row of the matrix in an array
        
        int max = maxRectangularArea(arr, n); //finding out the max rectangular area for the 1st row of the matrix
        
        //now, from next row onwards we'll increase the height of the bar if a[i][j] == 1 or else will update height as 0 as a[i][j] == 0
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(a[i][j] == 0)
                    arr[j] = 0;
                else
                    arr[j] += a[i][j];
            }
            
            max = Integer.max(max, maxRectangularArea(arr, n)); //finding out the max rectangular area for the each row of the matrix   
        }
        
        return max;
    }
    
    //this is the same solution as to find the max rectangular area in histogram
    static int maxRectangularArea(int a[], int n)
    {
        int maxArea = 0, popped = 0, currArea = 0;
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i = 0; i < n; i++)
        {
            while(s.isEmpty() == false && a[i] <= a[s.peek()])
            {
                popped = s.pop();
                currArea = a[popped] * (s.isEmpty() ? i : (i - s.peek() - 1));
                maxArea = Integer.max(maxArea, currArea);
            }
            
            s.push(i);
        }
        
        while(!s.isEmpty())
        {
            popped = s.pop();
            currArea = a[popped] * (s.isEmpty() ? n : (n - s.peek() - 1));
            maxArea = Integer.max(maxArea, currArea);
        }
        
        return maxArea;
    }
    
}





