/*

Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.


Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 10^5
s and t consist of uppercase and lowercase English letters.

***************************************************************Solution*****************************************************/

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */

// Reference: https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
const minWindow = function (s, t) {
  const obj = {};
  // store the occurrence of characters of the given pattern 't' in an object or map
  for (const char of t) {
    obj[char] = (obj[char] || 0) + 1;
  }

  let left = 0,
    matchCount = 0,
    result = "";
  const sObj = {};

  /* Start matching the characters of the pattern with the characters of the string and 
  increment the matchCount if a character matches. */
  for (let right = 0; right < s.length; right++) {
    const char = s[right];
    sObj[char] = (sObj[char] || 0) + 1;
    if (sObj[char] <= obj[char]) {
      matchCount++;
    }

    /* Check if (matchCount == length of the given pattern), this means a window(or, substring) is found 
    with all the characters of the given pattern. */
    if (matchCount === t.length) {
      /* minimize the length of the window by removing extra characters from the beginning of the current window. */
      let charToRemove = s[left];
      while (
        obj[charToRemove] === undefined ||
        sObj[charToRemove] > obj[charToRemove]
      ) {
        sObj[charToRemove] = sObj[charToRemove] - 1;
        left++;
        charToRemove = s[left];
      }

      // update the possible result if the length of possible result is less than the current result
      const possibleRes = s.substring(left, right + 1);
      if (result.length === 0 || possibleRes.length < result.length) {
        result = possibleRes;
      }
    }
  }

  return result;
};
