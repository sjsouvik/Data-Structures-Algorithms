/*
Write a program to find transpose of a square matrix mat[][] of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case contains an integer N, denoting 
the size of the square matrix. Then in the next line are N*N space separated values of the matrix.

Output:
For each test case output will be the space separated values of the transpose of the matrix

User Task:
The task is to complete the function transpose() which finds the transpose of the matrix. The printing is done by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 100
-103 <= mat[i][j] <= 103

Example:
Input:
2
4
1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4
2
1 2 -9 -2
Output:
1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4
1 -9 2 -2

Explanation:
Testcase 1: The matrix after rotation will be: 1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4.
Testcase 2: The matrix after rotation will be: 1 -9 2 -2.

******************************************************************Solution********************************************************************************/

import java.io.*;
import java.util.*;
import java.lang.*;

class Driverclass
{
    public static void main (String[] args)throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int a[][] = new int[n][n];
            String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                    a[i][j] = Integer.parseInt(st[k++]);
            }
            new TransposeMatrix().transpose(a, n);
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n;j++)
                    System.out.print(a[i][j] + " ");
            }
            
            System.out.println();
        }
    }
}

class TransposeMatrix
{    
    static void transpose(int a[][], int n)
    {        
        int c;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                c=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=c;
            }
        }
    }
}







