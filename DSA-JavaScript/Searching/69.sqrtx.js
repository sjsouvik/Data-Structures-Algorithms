/*

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1

****************************************************************Solution***********************************************************/

/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if(x < 0 || typeof(x) !== 'number' || Number.isNaN(x)){
        return NaN;
    }

    let l = 0, r = x, mid, square, res;
    
    while(l <= r){
        mid = Math.floor(l + (r - l) / 2);
        square = mid * mid;
        
        if(square === x){
            return mid;
        }
        
        if(square > x){
            r = mid - 1;
        }else{
            l = mid + 1;
            res = mid;
        }        
    }
    
    return res;
};