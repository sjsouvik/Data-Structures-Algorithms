/*

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 
Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

****************************************************************Solution*****************************************************/

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

/* The idea is to store each unique character of 's' as a key and the corresponding character 
at the same index of 't' as the value in an object or map while traversing the string 's'. */
const isIsomorphic = function (s, t) {
  const obj = {};
  const set = new Set();

  for (let i = 0; i <= s.length; i++) {
    const sChar = s[i];
    const tChar = t[i];

    // if the sChar is seen before
    if (obj[sChar]) {
      // and the 1st occurrence of the sChar is not mapped to the character of 't' at the current index(tChar), then the strings are not isomorphic
      if (obj[sChar] !== tChar) {
        return false;
      }
    } else {
      // if the sChar is not seen before and the corresponding character(tChar) of 't' is mapped to some other character of 's', then the strings are not isomorphic
      if (set.has(tChar)) {
        return false;
      }

      obj[sChar] = tChar;
      set.add(tChar);
    }
  }

  return true;
};
