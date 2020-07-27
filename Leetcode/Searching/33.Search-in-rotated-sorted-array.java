/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

********************************************************************Solution*****************************************************************************/

class Solution 
{
    public int search(int[] a, int target) 
    {
        if(a.length == 0)
            return -1;

        int start = 0, end = a.length - 1;

        //in this case array is rotated
        if(a[start] > a[end])
        {            
            int indexPivot = findPivot(a, start, end, a.length);

            if(target >= a[start])
                return binarySearch(a, start, indexPivot - 1, target);

            return binarySearch(a, indexPivot, end, target);
        }   

        //if array is sorted but not rotated
        return binarySearch(a, start, end, target);
     } 


    //this will return the index of minimum or pivot element of the rotated sorted array
    int findPivot(int a[], int start, int end, int size)
    {
        int toCompare = a[start];
        
        while(start <= end)
        {
            int mid = start + ((end - start) / 2);
            
            int prevMid = (mid + size - 1) % size;
            int nextMid = (mid + 1) % size;

            if(a[mid] < a[prevMid] && a[mid] < a[nextMid])
                return mid;

            else if(a[mid] >= toCompare)
                start = mid + 1;

            else if(a[mid] < toCompare)
                end = mid - 1;
        }  

        return -1;
    } 

    
    //this will return the index of target 
    int binarySearch(int a[], int start, int end, int target)
    {
        while(start <= end)
        {
            int mid = start + ((end - start) / 2);

            if(a[mid] == target)
                return mid;

            else if(a[mid] < target)
                start = mid + 1;

            else //if(a[mid] > target)
                end = mid - 1;
        }

        return -1;
    } 
    
}




