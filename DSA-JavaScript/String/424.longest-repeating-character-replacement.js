/*

You are given a string s and an integer k. You can choose any character of the string and change it to any 
other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above 
operations.


Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

********************************************************Solution**************************************************/

/*

Time complexity: O(n)
Space complexity: O(m)
Where n is the length of the string and m is the total number of unique characters in the string.

*/

function characterReplacement(s, k) {
  let left = 0,
    countOfMaxFreqChar = 0,
    result = 0;
  const frequency = {};

  for (let right = 0; right < s.length; right++) {
    frequency[s[right]] = (frequency[s[right]] || 0) + 1;
    countOfMaxFreqChar = Math.max(countOfMaxFreqChar, frequency[s[right]]);
    let windowLength = right - left + 1;

    while (windowLength - countOfMaxFreqChar > k) {
      frequency[s[left]] -= 1;
      left++;
      windowLength = right - left + 1;
    }

    result = Math.max(result, windowLength);
  }

  return result;
}
