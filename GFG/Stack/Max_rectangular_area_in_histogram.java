/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, 
assume that all bars have same width and the width is 1 unit.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T test-cases follow. In each test cases, the first line contains an 
integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array. The 
elements of the array represents the height of the bars.

Output:
For each test-case, in a separate line, the maximum rectangular area possible from the contiguous bars.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 104

Example:
Input: 
2
7
6 2 5 4 5 1 6
4
6 3 4 2
Output:
12
9

***********************************************************************Solution****************************************************************************/

import java.util.*;

class GFG
 {
	public static void main (String[] args)
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
    	     
    	     System.out.println(maxRectangleArea(a, n));   
    	 }
	 }
	 
	 //this is comparatively efficient solution
	 static int maxRectangleArea(int a[], int n)
	 {
	     int maxArea = 0, currArea = 0, popped;
	     Stack<Integer> s = new Stack<Integer>();
	     
	     //Note : we'll store the index of each item into the stack as it'll help to calculate the area and to compare with other elements
	     
	     /*will push elements into stack such that the below element of the current element will be the next smaller element to left of the current item and if we pop any element from stack that means we have found the next smaller to right of the current item, 
	     we'll calculate the area for a particular item only when that item is being popped from stack i.e. we have found both next smaller to right and left for that particular item */ 
	     
	     /* will traverse the entire array and push the items into stack if the stack is empty or peek item of the stack contains the next smaller to left of the current item i.e. if current item > s.peek() then will push the element into the stack,
	     if any item is at bottom of the stack that means that item doesn't have any next smaller item to left, in this edge case we can calculate the area by taking the index of the next smaller item to left as -1, 
	     so area = item * (indexOfNextSmallerRight(current index 'i') - indexOfNextSmallerLeft(-1) - 1) = item * (i + 1 - 1) = item * currentIndex(i) */
	     for(int i = 0; i < n; i++)
	     {
	         while(s.isEmpty() == false && a[i] <= a[s.peek()])
	         {
	             popped = s.pop();
	             currArea = a[popped] * (s.isEmpty() ? i : (i - s.peek() - 1)); //here, after popping one element, the current peek element has the index of next smaller item to left for the current element and current index is the index of next smaller item to right for the current item  
	             maxArea = Integer.max(maxArea, currArea);
	         }
	         
	         s.push(i);
	     }
	     
	     /*if still stack has any elements left that means those elements don't have any next smaller item to right, so now we'll have to calculate area for these left items in the stack
	     here, we can calculate the area by taking the index of the next smaller item to right as 'n'(size of the input array), so, area = item * (indexOfNextSmallerRight(size of the array 'n') - indexOfNextSmallerLeft(s.peek()) - 1). 
	     the item at bottom of the satck doesn't have any next smaller to right or left, in this corner case, we can calculate the area by taking the index of the next smaller item to right as 'n'(size of the input array) and the index of the next smaller item to left as '-1'
	     so area = item * (indexOfNextSmallerRight(size of array 'n') - indexOfNextSmallerLeft(-1) - 1) = item * (n + 1 - 1) = item * size of array(n) */
	     
	     while(!s.isEmpty())
	     {
	         popped = s.pop();
	         currArea = a[popped] * (s.isEmpty() ? n : (n - s.peek() - 1));
	         maxArea = Integer.max(maxArea, currArea);
	     }
	     
	     return maxArea;
	 }
	 
	 //Highly recommended - Understand this solution 1st - easy to understand - it'll help to understand the above efficient solution
	 //this is the 1st solution which is relatively easy to understand but it requires multiple traversals of the array to get previous smaller and next smaller element with extra spaces to store those elements
	 static int maxRectangleArea1(int a[], int n)
	 {
	     int maxArea = 0;
	     
	     ArrayList<Integer> nsr = nextSmallerRight(a, n); //list containing nearest smaller element's index to right for each array element 
	     ArrayList<Integer> nsl = nextSmallerLeft(a, n); //list containing nearest smaller element's index to left for each array element 
	     
	     for(int i = 0; i < n; i++)
	     {
	         //for current element, get the nearest smaller element's index to right and nearest smaller element's index to left then find the width of the rectangle for the current element
	         //width = for current element (nearest smaller element's index to right - nearest smaller element's index to left - 1)
	         int currArea = a[i] * (nsr.get(i) - nsl.get(i) - 1); //area = length * width
	         maxArea = Integer.max(maxArea, currArea);
	     }
	     
	     return maxArea;
	 }
	 
	 //to get the nearest smaller element's index to right for each array element 
	 static ArrayList<Integer> nextSmallerRight(int a[], int n)
	 {
	     ArrayList<Integer> nsr = new ArrayList<Integer>();
	     Stack<Integer> s = new Stack<Integer>();
	     
	     for(int i = n-1; i >= 0; i--)
	     {
	         while(s.isEmpty() == false && a[i] <= a[s.peek()])
	            s.pop();
	         
	         nsr.add(s.isEmpty() ? n : s.peek());
	         s.push(i);
	     }
	     
	     Collections.reverse(nsr);
	     
	     return nsr;
	 }
	 
	 //to get the nearest smaller element's index to right for each array element 
	 static ArrayList<Integer> nextSmallerLeft(int a[], int n)
	 {
	     ArrayList<Integer> nsl = new ArrayList<Integer>();
	     Stack<Integer> s = new Stack<Integer>();
	     
	     for(int i = 0; i < n; i++)
	     {
	         while(s.isEmpty() == false && a[i] <= a[s.peek()])
	            s.pop();
	         
	         nsl.add(s.isEmpty() ? -1 : s.peek());
	         s.push(i);
	     }
	     
	     return nsl;
	 }
	 
}













