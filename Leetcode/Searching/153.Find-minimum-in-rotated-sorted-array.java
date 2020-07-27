/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1

Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

********************************************************************Solution*******************************************************************************/

class Solution 
{
    public int findMin(int[] a) 
    {
        int start = 0, size = a.length, end = size - 1, toCompare = a[start];
        
        //in this case array is sorted but not rotated or size of the array is 1 then we can return the 1st element of it
        if(a[start] < a[end] || size == 1)
            return a[start];        
        
        while(start <= end)
        {
            int mid = start + ((end - start) / 2);
            
            int prevMid = (mid + size - 1) % size; //for the 1st element, the previous element of it would be the last element of the array 
            int nextMid = (mid + 1) % size; //for the last element, the next element of it would be the 1st element of the array
	    
	    //if the mid element is less than both of its neighbours then that's the min element
            if(a[mid] < a[prevMid] && a[mid] < a[nextMid])
                return a[mid];

            else if(a[mid] >= toCompare)
                start = mid + 1;

            else if(a[mid] < toCompare)
                end = mid - 1;
        } 

        return -1;        
    }
}




