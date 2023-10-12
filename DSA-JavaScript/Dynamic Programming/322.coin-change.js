/*

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.


Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

***********************************************************Solution********************************************************/

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
const coinChange = function (coins, amount) {
  const cache = {};

  const util = (amount, n = coins.length) => {
    if (amount === 0) {
      return 0;
    }

    if (n === 0) {
      return Number.POSITIVE_INFINITY;
    }

    const key = `${amount}_${n}`;
    if (cache[key] !== undefined) {
      return cache[key];
    }

    if (coins[n - 1] <= amount) {
      cache[key] = Math.min(
        1 + util(amount - coins[n - 1], n),
        util(amount, n - 1)
      );
    } else {
      cache[key] = util(amount, n - 1);
    }

    return cache[key];
  };

  const output = util(amount);
  return output === Number.POSITIVE_INFINITY ? -1 : output;
};
