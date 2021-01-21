/*
You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
 
Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation:
For number 2 in the first array, the next greater number for it in the second array is 3.
For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 
Constraints:

    1 <= nums1.length <= nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 104
    All integers in nums1 and nums2 are unique.
    All the integers of nums1 also appear in nums2.

 
Follow up: Could you find an O(nums1.length + nums2.length) solution?

**********************************************************************************************Solution*********************************************************************************************/

class Solution 
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {        
        //this map will store each element as key whereas next greater element to its right will be stores as value
        Map<Integer, Integer> m = new HashMap<>(); 
        Stack<Integer> st = new Stack<>();
        
        /* the idea is to 
        1) traverse from right side of the array as we need to find next greater element at right side and remove all smaller or equal to the current element from stack if the stack is non-empty. Once we get the greater element in stack that would be the next greater element for the current element. If we get the stack as empty then there's no element greater than the current element. 
        
        2)Push the current element into stack once we have the next greater element for the current element*/
        for(int i = nums2.length - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums2[i])
                st.pop();
            
            int res = st.isEmpty() ? -1 : st.peek();
            m.put(nums2[i], res);
            
            st.push(nums2[i]);
        }
        
        for(int i = 0; i < nums1.length; i++)        
            nums1[i] = m.get(nums1[i]);        
        
        return nums1;
    }
}