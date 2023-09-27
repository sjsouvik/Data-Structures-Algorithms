/*

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

***************************************************************Solution******************************************************/

/**
 * @param {string[]} strs
 * @return {string[][]}
 */

const groupAnagrams = function (strs) {
  const obj = {};
  for (const str of strs) {
    const key = getKey(str);

    if (obj[key]) {
      obj[key] = obj[key].concat(str);
    } else {
      obj[key] = [str];
    }
  }

  return Object.values(obj);
};

const getKey = (str) => {
  const arr = Array(26).fill(0);

  /* ASCII value of 'a' is 97 and since all characters are in lowercase, we're subtracting the ASCII value of 'a' 
    to get the index to store the count of the character. e.g. for character 'a' index would be 0 */
  for (let i = 0; i < str.length; i++) {
    arr[str.charCodeAt(i) - 97]++;
  }

  return arr.join(",");
};

// in this solution, we're sorting the characters of a string to get the key to store in the object

/* 
const groupAnagrams = function(strs) {    
    const obj = {};
    for(const str of strs){
        const key = str.split("").sort().join("")
        if(obj[key]){
            obj[key] = obj[key].concat(str)
        }else{
            obj[key] = [str]
        }
    }

    return Object.values(obj)
};
*/
