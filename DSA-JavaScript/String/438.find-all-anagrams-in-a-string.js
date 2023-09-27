/*

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

****************************************************************Solution******************************************************/

/*

The idea is to traverse the source string for the length of pattern string and create a map or object(sObj) to have 
the count for each character and compare that with the character count object(pObj) created using the pattern string. 
If both of the objects match, then we found one anagram. 

Next, we can slide the window in the source string by adding the next character in the object(sObj) and 
removing or reducing the count from the object(sObj) of the 1st character in the previous window. 
Then, compare the objects(sObj, pObj) again, if they match, then we found one more anagram. 
Follow the same till we reach the end of the string.

*/

/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
const findAnagrams = function (s, p) {
  const sObj = {},
    pObj = {};
  for (let i = 0; i < p.length; i++) {
    sObj[s[i]] = (sObj[s[i]] || 0) + 1;
    pObj[p[i]] = (pObj[p[i]] || 0) + 1;
  }

  const result = [];
  let i = p.length;
  while (i < s.length) {
    if (compare(sObj, pObj)) {
      result.push(i - p.length);
    }

    sObj[s[i]] = (sObj[s[i]] || 0) + 1;
    const charOfPrevWindow = s[i - p.length];
    if (sObj[charOfPrevWindow] === 1) {
      delete sObj[charOfPrevWindow];
    } else {
      sObj[charOfPrevWindow] = sObj[charOfPrevWindow] - 1;
    }

    i++;
  }

  if (compare(sObj, pObj)) {
    result.push(i - p.length);
  }

  return result;
};

const compare = (obj1, obj2) => {
  for (const key of Object.keys(obj1)) {
    if (obj1[key] !== obj2[key]) {
      return false;
    }
  }

  return true;
};
