/*
Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (mat[][]). The task to print a solved Sudoku. For simplicity you may 
assume that there will be only one unique solution.

Sample Sudoku for you to get the logic for its solution:

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated 
values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case, in a new line, print the space separated values of the solution of the the sudoku.

Constraints:
1 <= T <= 10
0 <= mat[] <= 9

Example:
Input:
1
3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 1 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0

Output:
3 1 6 5 7 8 4 9 2 5 2 9 1 3 4 7 6 8 4 8 7 6 2 9 5 3 1 2 6 3 4 1 5 9 8 7 9 7 4 8 6 3 1 2 5 8 5 1 7 9 2 6 4 3 1 3 8 9 4 7 2 5 6 6 9 2 3 5 1 8 7 4 7 4 5 2 8 6 3 1 9

Explanation:
Testcase 1: The solved sudoku is:
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9

*********************************************************************Solution******************************************************************************/

import java.util.*;
import java.io.*;

class GFG
{
    public static void main (String[] args) throws IOException
    {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     int a[][] = new int[9][9];
    	     
    	     for(int i = 0; i < 9; i++)
    	     {
    	         for(int j = 0; j < 9; j++)
    	            a[i][j] = sc.nextInt();   
    	     }
    	     
    	     solveSudoku(a, 0, 0);
    	     System.out.println();
    	 }
    }
	 
    static void solveSudoku(int grid[][], int row, int col)
    {
        if(row == grid.length)
        {
            printGrid(grid);
            return; 
        }
        
        int nextRow, nextCol;
        if(col == grid[0].length - 1)
        {
            nextRow = row + 1;
            nextCol = 0;
        }
        else
        {
            nextRow = row;
            nextCol = col + 1;
        }
        
        //if the cell is not empty then we'll move to the next cell in the matrix, else we'll try to place any number from 1 to 9 if that's a valid number to be placed
        if(grid[row][col] != 0)
            solveSudoku(grid, nextRow, nextCol);
        else
        {
            for(int option = 1; option <= 9; option++)
            {
                if(canWePlace(grid, row, col, option))
                {
                    grid[row][col] = option;
                    solveSudoku(grid, nextRow, nextCol);
                    grid[row][col] = 0;
                }
            }
        }
    }
    
    static boolean canWePlace(int grid[][], int row, int col, int option)
    {
        //checking if the number is present in that column or not
        for(int j = 0; j < grid[0].length; j++)
        {
            if(grid[row][j] == option)
                return false;
        }
        
        //checking if the number is present in that row or not 
        for(int i = 0; i < grid.length; i++)
        {
            if(grid[i][col] == option)
                return false;
        }
        
        //checking if the number is present in the small 3 x 3 matrix or not
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(grid[startRow + i][startCol + j] == option)
                    return false;
            }
        }
        
        return true;
    }
    
    static void printGrid(int grid[][])
    {
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
                System.out.print(grid[row][col] + " ");
        }
    }
}

