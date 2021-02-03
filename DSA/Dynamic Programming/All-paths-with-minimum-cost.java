/*
Question:-

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.

Input Format:-

A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements

Output Format:-

Check the sample output and question video.

Constraints:-

1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000

Sample Input:-

6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Sample Output:-

23
HVVHHVHVHV
HVVHHVHHVV

**************************************************************************************Solution******************************************************************************************************/

import java.io.*;
import java.util.*;

public class Main {

    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        printAllPaths(arr);
    }

    static void printAllPaths(int a[][]) 
    {
        int dp[][] = new int[a.length][a[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) //if we are in last cell of last row
                    dp[i][j] = a[i][j];
                else if (i == dp.length - 1) //when we are at last row 
                    dp[i][j] = dp[i][j + 1] + a[i][j];
                else if (j == dp[0].length - 1) //when we are at last column   
                    dp[i][j] = dp[i + 1][j] + a[i][j];
                else
                    dp[i][j] = Integer.min(dp[i][j + 1], dp[i + 1][j]) + a[i][j];
            }
        }

        System.out.println(dp[0][0]); //min.cost to traverse from top left most cell to bottom right most cell - there's question in level 1 as well where we have to just find the min cost to traverse not all paths, so can refer to that for detailed explaination

        //Used BFS to find all min cost paths from top left most cell to bottom right most cell
        Queue < Pair > paths = new LinkedList < > ();

        paths.add(new Pair("", 0, 0));

        while (!paths.isEmpty()) {
            Pair removedPair = paths.poll();
            String psf = removedPair.psf;
            int i = removedPair.i;
            int j = removedPair.j;

            //if we are in last cell of last row, then we've reached to the destination. So, print path so far
            if (i == dp.length - 1 && j == dp[0].length - 1)
                System.out.println(psf);

            //if we are at last row, then we have only option to traverse horizontally to reach to the destination 
            else if (i == dp.length - 1)
                paths.add(new Pair(psf + "H", i, j + 1));

            //if we are at last column, then we have only option to traverse vertically to reach to the destination     
            else if (j == dp[0].length - 1)
                paths.add(new Pair(psf + "V", i + 1, j));
            //else, we'll have 2 options to traverse horizontally or vertically and we'll choose the min cost between 2. In case both have equal cost then we have to take 2 take 2 paths into consideration.
            else {
                if (dp[i][j + 1] < dp[i + 1][j])
                    paths.add(new Pair(psf + "H", i, j + 1));
                else if (dp[i + 1][j] < dp[i][j + 1])
                    paths.add(new Pair(psf + "V", i + 1, j));
                else {
                    paths.add(new Pair(psf + "V", i + 1, j));
                    paths.add(new Pair(psf + "H", i, j + 1));
                }
            }
        }
    }
}