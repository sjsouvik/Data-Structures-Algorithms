/*

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

********************************************************Solution***************************************************/

/*

The idea is to iterate the string and for each index, consider that as the center of the 
palindrome string. Next, try to expand the window, from that index to its left and right 
if the characters at left and right matches.

Time complexity: O(n^2)
Space complexity: O(1)

*/

function longestPalindrome(s) {
  let resultLength = 0,
    result = "";

  function findPalindrome(left, right) {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
      if (right - left + 1 > resultLength) {
        resultLength = right - left + 1;
        result = s.substring(left, right + 1);
      }

      left--;
      right++;
    }
  }

  for (let i = 0; i < s.length; i++) {
    // to find odd length palindrome, left and right both pointers are set to index i.
    let left = i,
      right = i;
    findPalindrome(left, right);

    // to find even length palindrome, left and right pointers are set to index i and i + 1 respectively.
    left = i;
    right = i + 1;
    findPalindrome(left, right);
  }

  return result;
}
