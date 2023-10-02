/*

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 
Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 10^4
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0

***********************************************************Solution**********************************************************/

/**
 * @param {number[]} asteroids
 * @return {number[]}
 */
const asteroidCollision = function (asteroids) {
  const stack = [];

  for (let i = 0; i < asteroids.length; i++) {
    const currentItem = asteroids[i];

    if (currentItem > 0) {
      stack.push(currentItem);
    } else {
      /* If the top value of the stack is positive and smaller than the absolute value of the current item, 
      then pop the item since that will collide with the current item and will be destroyed */
      while (
        stack.length &&
        stack[stack.length - 1] > 0 &&
        stack[stack.length - 1] < Math.abs(currentItem)
      ) {
        stack.pop();
      }

      /* if the top of the stack is equal to the absolute value of the current item, then pop the item */
      if (stack.length && stack[stack.length - 1] === Math.abs(currentItem)) {
        stack.pop();
      } else if (stack.length === 0 || stack[stack.length - 1] < 0) {
        stack.push(currentItem);
      }
    }
  }

  return stack;
};
