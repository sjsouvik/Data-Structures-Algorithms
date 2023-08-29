/*

Given a string s, find the length of the longest substring without repeating characters.

 
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

**************************************************************Solution*********************************************************/

/**
 * @param {string} s
 * @return {number}
 */
const lengthOfLongestSubstring = function (s) {
  /* creating an array of size 256 since the the input string consists of English letters, digits, symbols, spaces 
  and we need to store the index of each character in the lastIndex array at the index of the ascii code of the character. 
  lastIndex array would be used to find out the index of last occurrence for each character */
  const lastIndex = Array(256).fill(-1);
  let i = 0,
    result = 0;

  for (let j = 0; j < s.length; j++) {
    const asciiOfCurrentChar = s.charCodeAt(j);
    i = Math.max(i, lastIndex[asciiOfCurrentChar] + 1);
    result = Math.max(result, j - i + 1);
    lastIndex[asciiOfCurrentChar] = j;
  }

  return result;
};
