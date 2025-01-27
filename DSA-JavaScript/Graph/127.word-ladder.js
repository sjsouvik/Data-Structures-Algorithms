/*

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of 
words beginWord -> s1 -> s2 -> ... -> sk such that:

- Every adjacent pair of words differs by a single letter.
- Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
- sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the 
shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.

*******************************************************Solution****************************************************/

/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
/*

time complexity of this solution - n * m * 26 *m = O(n * m^2)
where n is the number of words in the list and m is the length of the word

*/
const ladderLength = function (beginWord, endWord, wordList) {
  const words = new Set(wordList);
  const queue = [[beginWord, 1]];

  while (queue.length) {
    const [word, steps] = queue.shift();

    if (word === endWord) {
      return steps;
    }

    /* time complexity of the following code - word length * 26 * word length
    (for substring operation to get the updated word) */
    for (let i = 0; i < word.length; i++) {
      for (let j = "a".charCodeAt(0); j <= "z".charCodeAt(0); j++) {
        const updatedWord =
          word.substring(0, i) + String.fromCharCode(j) + word.substring(i + 1);
        if (words.has(updatedWord)) {
          queue.push([updatedWord, steps + 1]);
          words.delete(updatedWord);
        }
      }
    }
  }

  return 0;
};
