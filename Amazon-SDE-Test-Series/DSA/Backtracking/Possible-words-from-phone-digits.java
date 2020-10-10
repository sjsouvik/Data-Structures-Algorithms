/*
Given a keypad as shown in the diagram, and an N digit number which is represented by array a[], the task is to list all words which are possible by 
pressing these numbers.

Example 1:

Input: N = 3, a[] = {2, 3, 4}
Output:
adg adh adi aeg aeh aei afg afh
afi bdg bdh bdi beg beh bei bfg
bfh bfi cdg cdh cdi ceg ceh cei
cfg cfh cfi 
Explanation: When we press 2,3,4 
then adg,adh,adi , ......,cfi are
the list of possible words.

Example 2:

Input: N = 3, a[] = {3, 4, 5}
Output:
dgj dgk dgl dhj dhk dhl dij dik
dil egj egk egl ehj ehk ehl eij 
eik eil fgj fgk fgl fhj fhk fhl 
fij fik fil
Explanation: When we press 3,4,5 
then dgj,dgk,dgl,.......,fil are 
the list of possible words.

Your Task:
You don't need to read input or print anything. You just need to complete the function possibleWords() that takes an array a[] and N as parameters and 
returns an array of all the possible words in lexicographical order. 

Expected Time Complexity: O(4N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 10
2 ≤  a[i] ≤ 9

********************************************************************Solution****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new PhoneDigit().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

//using Hypothesis-Base-Induction method or Faith-Expectation method

class PhoneDigit
{
    static String codes[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; //keypad with letters starting from digit 2
    
    static ArrayList<String> possibleWords(int a[], int N)
    {
        //Base condition
        if(N == 0)
        {
            ArrayList<String> allWords = new ArrayList<>();
            allWords.add("");
            return allWords;
        }
        
        String code = codes[a[0] - 2];
        
        int smallerInput[] = Arrays.copyOfRange(a, 1, N); //this is to remove the 1st element from the array and to make the array smaller
        ArrayList<String> words = possibleWords(smallerInput, N - 1); //Hypothesis
        
        //Induction
        ArrayList<String> allWords = new ArrayList<>();
        
        for(int i = 0; i < code.length(); i++)
        {
            for(String word : words)
            {
                allWords.add(code.charAt(i) + word);
            }
        }
        
        return allWords;
    }
}







