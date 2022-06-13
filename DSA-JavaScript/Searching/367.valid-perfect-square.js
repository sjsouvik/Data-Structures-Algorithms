/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.


Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false

Constraints:

1 <= num <= 2^31 - 1

***********************************************************Solution***************************************************/

/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    let start = 1, end = num, mid, square;
    
    while(start <= end){
        mid = Math.floor(start + (end - start) / 2);
        square = mid * mid;
        
        if(square === num){
            return true;
        }
        
        if(square > num){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
    }
    
    return false;
};