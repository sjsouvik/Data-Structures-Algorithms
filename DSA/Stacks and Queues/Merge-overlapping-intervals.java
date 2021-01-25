/*
1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.
Input Format
Input is managed for you 
Output Format
Print a merged meeting start time and end time separated by a space in a line
.. print all merged meetings one in each line.

Constraints:-

1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100

Sample Input:-

6
22 28
1 8
25 27
14 19
27 30
5 12

Sample Output:-

1 12
14 19
22 30

******************************************************************************************Solution********************************************************************************************/

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) 
        {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }


    /* The idea is to sort the intervals as per the start time and push into stack. Before pushing into a stack 
    compare start time of current interval is less than the end time top of the stack(previous interval) or not. 
    If it's less, then merge the 2 intervals and update the end time of the merged intervals by greater end time 
    among these 2 intervals, else just push the current interval into the stack. At the end, we need to take the 
    reverse of stack items to get the order these were pushed into the stack  */
    public static void mergeOverlappingIntervals(int[][] arr) 
    {
        Pair intervals[] = new Pair[arr.length];
        
        for(int i = 0; i < arr.length; i++)
            intervals[i] = new Pair(arr[i][0], arr[i][1]);
        
        Arrays.sort(intervals);
        
        Stack<Pair> st = new Stack<>();
        st.push(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++)
        {
            Pair top = st.peek();
            
            if(intervals[i].startTime > top.endTime)
                st.push(intervals[i]);
            else
                top.endTime = Integer.max(top.endTime, intervals[i].endTime);
            
        }
        
        //to get the intervals as result in the order these were pushed into the previous stack
        Stack<Pair> s = new Stack<>(); 
        while(!st.isEmpty())
            s.push(st.pop());
        
        while(s.size() > 0)
        {
            Pair popped = s.pop();
            
            System.out.println(popped.startTime + " " + popped.endTime);
        }
    }
}


class Pair implements Comparable<Pair>
{
    int startTime, endTime;
    
    Pair(int st, int et)
    {
        startTime = st;
        endTime = et;
    }
    
    /* this > other return +ve
       this < other return -ve
       this == other return 0
    */
    public int compareTo(Pair other)
    {
        if(this.startTime != other.startTime)
            return this.startTime - other.startTime;
        else
            return this.endTime - other.endTime;    
    }
}