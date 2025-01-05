/*

There is a foreign language which uses the latin alphabet, but the order among letters is not 
"a", "b", "c" ... "z" as in English.

You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically 
based on the rules of this new language.

Derive the order of letters in this language. If the order is invalid, return an empty string. If there are 
multiple valid order of letters, return any of them.

A string a is lexicographically smaller than a string b if either of the following is true:

The first letter where they differ is smaller in a than in b.
There is no index i such that a[i] != b[i] and a.length < b.length.

Example 1:

Input: ["z","o"]

Output: "zo"

Explanation:
From "z" and "o", we know 'z' < 'o', so return "zo".

Example 2:

Input: ["hrn","hrf","er","enn","rfnn"]

Output: "hernf"

Explanation:

from "hrn" and "hrf", we know 'n' < 'f'
from "hrf" and "er", we know 'h' < 'e'
from "er" and "enn", we know get 'r' < 'n'
from "enn" and "rfnn" we know 'e'<'r'
so one possible solution is "hernf"

Constraints:

The input words will contain characters only from lowercase 'a' to 'z'.
1 <= words.length <= 100
1 <= words[i].length <= 100

********************************************************Solution***************************************************/

/*

Time complexity: O(N + V + E)
Space complexity: O(V + E)

Where V is the number of unique characters, E is the number of edges and 
N is the sum of lengths of all the strings.

*/

class Solution {
  /**
   * @param {string[]} words
   * @returns {string}
   */
  alienDictionary(words) {
    const wordsLength = words.length;
    const adjacencyList = {};
    const inDegree = {};

    for (const word of words) {
      for (const char of word) {
        adjacencyList[char] = [];
        inDegree[char] = 0;
      }
    }

    for (let i = 0; i < wordsLength - 1; i++) {
      const word1 = words[i],
        word2 = words[i + 1];
      const minLength = Math.min(word1.length, word2.length);

      /* found invalid order since a word is found which is longer than the next one and the each character 
      of the next word matches with each character of the 1st word */
      if (
        word1.length > word2.length &&
        word1.slice(0, minLength) === word2.slice(0, minLength)
      ) {
        return "";
      }

      for (let j = 0; j < minLength; j++) {
        if (word1[j] !== word2[j]) {
          adjacencyList[word1[j]].push(word2[j]);
          inDegree[word2[j]] += 1;
          break;
        }
      }
    }

    const queue = [];
    for (const key of Object.keys(inDegree)) {
      if (inDegree[key] === 0) {
        queue.push(key);
      }
    }

    const result = [];
    while (queue.length) {
      const char = queue.shift();
      result.push(char);

      for (const neighbor of adjacencyList[char]) {
        inDegree[neighbor] -= 1;

        if (inDegree[neighbor] === 0) {
          queue.push(neighbor);
        }
      }
    }

    /* found invalid order since a cycle is found in the directed graph and topological sorting doesn't 
    work in case of cyclic directed graph */
    if (result.length !== Object.keys(inDegree).length) {
      return "";
    }

    return result.join("");
  }
}
