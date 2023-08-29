/*

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 
Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

****************************************************************Solution*********************************************************/

/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
const canConstruct = function (ransomNote, magazine) {
  const ransomNoteMap = new Map();
  const magazineMap = new Map();

  for (const char of ransomNote) {
    ransomNoteMap.set(char, (ransomNoteMap.get(char) || 0) + 1);
  }

  for (const char of magazine) {
    magazineMap.set(char, (magazineMap.get(char) || 0) + 1);
  }

  for (const [key, value] of ransomNoteMap) {
    if (!magazineMap.get(key) || magazineMap.get(key) < value) {
      return false;
    }
  }

  return true;
};
