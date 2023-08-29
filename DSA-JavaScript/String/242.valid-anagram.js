/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

********************************************************************Solution***********************************************************/

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isAnagram = function (s, t) {
  if (s.length !== t.length) {
    return false;
  }

  const count = new Array(26);
  count.fill(0);

  // ASCII value of 'a' is 97 and as all characters are in lowercase, we're subtracting ASCII value of 'a' to get the index to store the count of the character. e.g. for character 'a' index would be 0
  for (let i = 0; i < s.length; i++) {
    count[s.charCodeAt(i) - 97]++;
    count[t.charCodeAt(i) - 97]--;
  }

  return !count.find((c) => c !== 0);
};

// Solution 2:

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isAnagramAnotherSolution = function (s, t) {
  if (s.length !== t.length) {
    return false;
  }

  const count = {};

  // to find out count of each character of 's'
  for (const currentChar of s) {
    count[currentChar] = (count[currentChar] || 0) + 1;
  }

  // then, reducing count for each character of 't' and after that if we get all values of count object as 0 i.e. 's', 't' are anagram of each other
  for (let i = 0; i < t.length; i++) {
    const currentChar = t[i];

    if (!count[currentChar]) {
      return false;
    }

    count[currentChar] -= 1;
  }

  return !Object.keys(count).some((key) => count[key] !== 0);
};
