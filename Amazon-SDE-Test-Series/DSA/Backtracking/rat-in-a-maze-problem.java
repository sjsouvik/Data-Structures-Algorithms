/*
Consider a rat placed at (0, 0) in a square matrix of order N*N. It has to reach the destination at (N-1, N-1). Find all possible paths that the rat 
can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a 
cell in the matrix represents that it is blocked and cannot be crossed while value 1 at a cell in the matrix represents that it can be traveled through.

Example 1:

Input: N = 4, m[][] = {{1, 0, 0, 0},
                       {1, 1, 0, 1}, 
                       {1, 1, 0, 0},
                       {0, 1, 1, 1}}
Output: DDRDRR DRDDRR
Explanation: The rat can reach the 
destination at (3, 3) from (0, 0) by two 
paths ie DRDDRR and DDRDRR when printed 
in sorted order we get DDRDRR DRDDRR.

Example 2:

Input: N = 2, m[][] = {{1, 0},
                       {1, 0}}
Output: -1
Explanation: No path exits


Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2d array m[][] as input parameters and returns a 
sorted list of paths.
 
Note:  In case of no path, return an empty list. The driver will output -1 automatically.

Expected Time Complexity: O((N2)4).
Expected Auxiliary Space: O(L*X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1

*********************************************************************Solution****************************************************************************/

import java.util.*;

class Rat 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) 
	{
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++)
	    {
                for (int j = 0; j < n; j++) 
		    a[i][j] = sc.nextInt();
	    }

            GfG g = new GfG();
            ArrayList<String> res = g.printPath(a, n);
            if (res.size() > 0) 
	    {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } 
	    else 
	    {
                System.out.println(-1);
            }
        }
    }
}


// m is the given matrix and n is the order of matrix
class GfG 
{
    public static ArrayList<String> printPath(int[][] m, int n) 
    {
        ArrayList<String> paths = new ArrayList<String>();
        
        boolean visited[][] = new boolean[n][n];
        allPaths(m, 0, 0, "", visited, paths);
        
        return paths;
    }
    
    static void allPaths(int maze[][], int row, int col, String psf, boolean visited[][], ArrayList<String> paths)
    {
        if(row < 0 || row == maze.length || col < 0 || col == maze.length || maze[row][col] == 0 || visited[row][col] == true)
            return;
        
        if(row == maze.length - 1 && col == maze.length - 1)
        {
            paths.add(psf);
            return;
        }
            
        visited[row][col] = true;
        allPaths(maze, row + 1, col, psf + "D", visited, paths);
        allPaths(maze, row, col - 1, psf + "L", visited, paths);
        allPaths(maze, row, col + 1, psf + "R", visited, paths);
        allPaths(maze, row - 1, col, psf + "U", visited, paths);
        visited[row][col] = false; //This is the backtracking step, so that we can explore all the existing paths from source to destination
    }
}




