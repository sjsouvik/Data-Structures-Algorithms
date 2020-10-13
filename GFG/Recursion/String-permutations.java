/*
Given a string S. The task is to find all permutations of a given string.

Example 1:

Input:
S = ABC
Output: ABC ACB BAC BCA CAB CBA 

Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA

 

Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in 
lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ size of string ≤ 5

Expected Time Complexity: O(N * N!), N = length of string.
Expected Auxiliary Space: O(1)

**********************************************************************Solution****************************************************************************/

import java.io.*;
import java.util.*;

class Recursion 
{
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Permutation obj=new Permutation();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = obj.permutation(S);
		    for(String s : arr)
		    {
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}		
	}
}


class Permutation
{
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> allPermutations = new ArrayList<>();
        
        allPermutations(S, "", allPermutations);
        Collections.sort(allPermutations); //this is to sort all the permutations lexicographically
        
        return allPermutations;
    }
	
	void allPermutations(String input, String output, ArrayList<String> res)
	{
	    if(input.length() == 0)
	    {
	        res.add(output);
	        return;
	    }
	    
	    for(int i = 0; i < input.length(); i++)
	    {
	        allPermutations(input.substring(0, i) + input.substring(i + 1), output + input.charAt(i), res);
	    }
	}
}







