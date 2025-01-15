/*

Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back 
to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]

Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]

Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.

******************************************************Solution****************************************************/

class Solution {
  /**
   * @param {string[]} strs
   * @returns {string}
   */
  encode(strs) {
    let result = "";

    for (const str of strs) {
      result += `${str.length}#${str}`;
    }

    return result;
  }

  /**
   * @param {string} str
   * @returns {string[]}
   */
  decode(str) {
    const result = [];

    let i = 0;
    while (i < str.length) {
      let j = i;
      while (str[j] !== "#") {
        j++;
      }

      const strLength = Number(str.substring(i, j));
      const s = str.substring(j + 1, j + 1 + strLength);
      result.push(s);
      i = j + 1 + strLength;
    }

    return result;
  }
}
