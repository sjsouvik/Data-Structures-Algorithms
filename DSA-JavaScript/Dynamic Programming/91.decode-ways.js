/*

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.


Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).

************************************************************Solution******************************************************/

/**
 * @param {string} s
 * @return {number}
 */
const numDecodings = function (s) {
  const cache = {};

  /* Total number of ways to decode for any given string is equal to the total ways to decode 
  if we select only the 1st character + total ways to decode if we select only the 1st 2 characters */
  const util = (index = 0) => {
    if (s[index] === "0") {
      return 0;
    }

    if (index === s.length) {
      return 1;
    }

    if (cache[index] !== undefined) {
      return cache[index];
    }

    /* selecting the 1st character to decode and making the recursive call to find the number of ways 
    to decode for rest of the string */
    let result = util(index + 1);

    /* selecting the 1st 2 characters to decode only if that's less than or equal to 26 
    and making the recursive call to find the number of ways to decode for rest of the string */
    if (index < s.length - 1 && Number(s.substring(index, index + 2)) <= 26) {
      result += util(index + 2);
    }

    cache[index] = result;
    return result;
  };

  return util();
};
