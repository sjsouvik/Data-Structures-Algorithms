/*

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.


Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]

Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-2^31 <= val <= 2^31 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.

**************************************************************Solution*******************************************************/

const swap = (list, index1, index2) => {
  [list[index1], list[index2]] = [list[index2], list[index1]];
};

/*

We can use an object or map to insert and delete an item in O(1) operation easily. But, to perform getRandom() in O(1), 
we need to maintain a list also which we can use return an item using a randomly generated index. 

Now, if we're maintaining a list, while performing delete operation, we need to remove the item from the list as well. 
The trick to perform delete operation from the list is to swap the item to be removed with the last item of the list 
and pop the last item. To swap the item to be removed with the last item in the list, we need the index of the item, 
so we'll keep the index for each item as the value in the object or map that we would be maintaining. 

We also need to update the index of the swapped item in the object since the index has been updated after swapping 
with the item to be removed.

*/
class RandomizedSet {
  constructor() {
    this.items = {};
    this.list = [];
  }

  size() {
    return this.list.length;
  }

  /**
   * @param {number} val
   * @return {boolean}
   */
  insert(val) {
    if (this.items[val] !== undefined) {
      return false;
    }

    this.items[val] = this.size();
    this.list.push(val);
    return true;
  }

  /**
   * @param {number} val
   * @return {boolean}
   */
  remove(val) {
    if (this.items[val] === undefined) {
      return false;
    }

    const valIndexInList = this.items[val];
    delete this.items[val];

    if (valIndexInList === this.size() - 1) {
      this.list.pop();
      return true;
    }

    swap(this.list, valIndexInList, this.size() - 1);
    this.list.pop();
    this.items[this.list[valIndexInList]] = valIndexInList;
    return true;
  }

  /**
   * @return {number}
   */
  getRandom() {
    const randomIndex = Math.floor(Math.random() * this.size());
    return this.list[randomIndex];
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
