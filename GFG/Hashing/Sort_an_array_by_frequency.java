/*
Given an array of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of 
two elements are same, then smaller number comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case 
contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the 
array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Your Task:
This is a function problem. You only need to complete the function sortByFreq that takes arr, and n as parameters and returns the sorted array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N). 

Constraints:
1 ≤ T ≤ 300
1 ≤ N ≤ 105
1 ≤ Ai ≤ 105 

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5
Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 
comes first then comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.
Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we 
print smaller element first.
The output is 9 9 9 2 5.

**********************************************************************Solution*****************************************************************************/

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Map.Entry;


class Driverclass 
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
	    while(n != 0)
		{
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");
			
			for(int i = 0; i < size; i++)
			    arr[i] = Integer.parseInt(temp[i]);
			    
			 ArrayList<Integer> ans = new ArrayList<Integer>();
			 ans = new Sorting().sortByFreq(arr, size);
			 for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
		    System.out.println();
			n--;
		}
	}
}


class sortByCount implements Comparator<Map.Entry<Integer, Integer>>
{
    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b)
    {
        //element with greater count will come first
        if(a.getValue() != b.getValue())
            return b.getValue().compareTo(a.getValue());
        
        //if frequencies are same then smaller element will come first    
        return a.getKey().compareTo(b.getKey());
    }
}


class Sorting
{
    static ArrayList<Integer> sortByFreq(int a[], int n)
    {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n; i++)
            m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        
        //to convert the map into an ArrayList
        ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList<Map.Entry<Integer, Integer>>(m.entrySet());
        
        Collections.sort(l, new sortByCount());
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < l.size(); i++)
        {
            int k = l.get(i).getValue(); //to get the frequency of the element 
            
            while(k-- > 0)
                res.add(l.get(i).getKey());
        }
        
        return res;
    }
}






