/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    nums is a non decreasing array.
    -10^9 <= target <= 10^9

********************************************************************Solution*******************************************************************************/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int output[] = {-1, -1};
        
        output[0] = leftMostIndex(nums, target);
        output[1] = rightMostIndex(nums, target);            
        
        return output;
    }
    
    int leftMostIndex(int nums[], int target)
    {
        int l = 0, r = nums.length - 1, mid = 0;
        
        while(l <= r)
        {
            mid = l + ((r - l) / 2);
            
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
                return mid;
            else if(nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        
        return -1;
    }
    
    int rightMostIndex(int nums[], int target)
    {
        int l = 0, r = nums.length - 1, mid = 0;
        
        while(l <= r)
        {
            mid = l + ((r - l) / 2);
            
            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target))
                return mid;
            else if(nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return -1;
    }
    
}



