/*
Given a keypad as shown in diagram, and an N digit number. List all words which are possible by pressing these numbers.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The 
first line of each test case is N, N is the number of digits. The second line of each test case contains D[i], N number of digits.

Output:
Print all possible words from phone digits with single space in lower case.

Constraints:
1 <= T <= 10
1 <= N <= 10
2 <=  D[i] <= 9

Example:
Input:
1
3
2 3 4

Output:
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi

******************************************************************Solution******************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args) throws IOException
    {
    	 Scanner sc = new Scanner(System.in);
    	 
    	 int t, n;
    	 
    	 t = sc.nextInt();
    	 
    	 while(t-- > 0)
    	 {
    	     n = sc.nextInt();
    	     
    	     int a[] = new int[n];
    	     
    	     for(int i = 0; i < n; i++)
    	        a[i] = sc.nextInt();    	     
    	     
    	     possibleWords(a, 0, n, ""); 
    	     System.out.println();
    	 }
    }
	 
	 static String codes[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; //Keypad with letters starting from digit 2	 
	 
	 //using input-ouput method or level-option method
	 static void possibleWords(int input[], int index, int n, String output)
	 {
	     if(index == n)
	     {
	         System.out.print(output + " ");
	         return;
	     }
	     
	     String code = codes[input[index] - 2];
	     
	     for(int i = 0; i < code.length(); i++)
	     {
	         possibleWords(input, index + 1, n, output + code.charAt(i));
	     }
	 }
}




 