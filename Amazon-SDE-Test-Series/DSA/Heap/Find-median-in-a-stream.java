/*
Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X 
to the new stream.
Input:
The first line of input contains an integer N denoting the number of elements in the stream. Then the next N lines contains integer x denoting the number 
to be inserted into the stream.
Output:
For each element added to the stream print the floor of the new median in a new line.
 
Constraints:
1 <= N <= 106
1 <= x <= 106
 
Example:
Input:
4
5
15
1 
3
Output:
5
10
5
4
 
Explanation:
Testcase 1:
Flow in stream : 5, 15, 1, 3
5 goes to stream --> median 5 (5)
15 goes to stream --> median 10 (5, 15)
1 goes to stream --> median 5 (5, 15, 1)
3 goes to stream --> median 4 (5, 15, 1, 3) 

*******************************************************************Solution*****************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
    	 Scanner sc = new Scanner(System.in);
    	 
	     int n = sc.nextInt();
	     
	     int a[] = new int[n];
	    
	     for(int i = 0; i < n; i++)
	        a[i] = sc.nextInt();
	     
	     findMedian(a, n);   
	 }
	 
	 /* 
	    We can use a max heap on left side to represent elements that are less than effective median, and a min heap on right side to represent elements that are greater than effective median.
        
        NOTE : if there're equal number of elements in both of the heaps then the next element would be added to the heap that contains the smaller elements than effective median
        
        After processing an incoming element, the number of elements in heaps differ utmost by 1 element. When both heaps contain same number of elements, we pick average of heaps root data as effective median. 
        When the heaps are not balanced, we select effective median from the root of heap containing more elements.
	 */
	 
	 static void findMedian(int a[], int n)
	 {
	     Queue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder()); //max heap to store the elements that are smaller than effective median.
	     Queue<Integer> greater = new PriorityQueue<Integer>(); //min heap to store the elements that are greater than effective median.
	     
	     //if there's single element then that would be added to the heap of smaller elements and that would be the current median
	     smaller.add(a[0]);
	     System.out.println(a[0]);
	     
	     for(int i = 1; i < n; i++)
	     {
	         int x = a[i];
	         
	         //if the number of elements in the smaller heap is greater than the number of elements in the greater heap then the next element would be added to the heap that contains the greater elements than effective median
	         if(smaller.size() > greater.size())
	         {
	             if(smaller.peek() > x) //if the peek of smaller heap is greater than the element to be inserted i.e. the new element needs to be added to the smaller heap and the peek of smaller heap needs to be added to the greater heap to keep all elements smaller than the effective median at smaller heap and all elements greater than the effective median at greater heap 
	             {
	                 greater.add(smaller.poll());
	                 smaller.add(x);
	             }
	             else
	                greater.add(x);
	             
	             System.out.println((smaller.peek() + greater.peek()) / 2);   
	         }
	         
	         //if there're equal number of elements in both of the heaps then the next element would be added to the heap that contains the smaller elements than the effective median
	         else
	         {
	             if(x > smaller.peek())
	             {
	                 greater.add(x);
	                 smaller.add(greater.poll());
	             }
	             else
	                smaller.add(x);
	                
	             System.out.println(smaller.peek());   
	         }
	     }
	 }
}






