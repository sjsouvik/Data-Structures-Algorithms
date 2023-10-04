/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

************************************************************Solution**************************************************/

/**
 * @param {string} digits
 * @return {string[]}
 */

const digitsToLettersMap = {
  2: "abc",
  3: "def",
  4: "ghi",
  5: "jkl",
  6: "mno",
  7: "pqrs",
  8: "tuv",
  9: "wxyz",
};

const letterCombinations = function (digits) {
  const result = [];

  if (digits.length === 0) {
    return result;
  }

  if (digits.length === 1) {
    return digitsToLettersMap[digits[0]].split("");
  }

  const firstChar = digits[0];
  const resChars = digits.slice(1);
  const subResult = letterCombinations(resChars);

  for (const char of digitsToLettersMap[firstChar]) {
    for (const item of subResult) {
      result.push(char + item);
    }
  }

  return result;
};
