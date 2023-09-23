/*

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10^-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-10^5 <= num <= 10^5
There will be at least one element in the data structure before calling findMedian.
At most 5 * 10^4 calls will be made to addNum and findMedian.

**************************************************************Solution*******************************************************/

class PriorityQ {
  constructor(compare) {
    this.compare = compare;
    this.items = [];
  }

  parent(i) {
    return Math.floor((i - 1) / 2);
  }

  left(i) {
    return 2 * i + 1;
  }

  right(i) {
    return 2 * i + 2;
  }

  swap(index1, index2) {
    [this.items[index1], this.items[index2]] = [
      this.items[index2],
      this.items[index1],
    ];
  }

  peek() {
    return this.items[0];
  }

  size() {
    return this.items.length;
  }

  add(item) {
    this.items.push(item);

    let i = this.items.length - 1;
    while (i !== 0 && this.compare(this.items[this.parent(i)], this.items[i])) {
      this.swap(i, this.parent(i));
      i = this.parent(i);
    }
  }

  heapify(index) {
    const left = this.left(index),
      right = this.right(index);
    let rootIndex = index;

    if (
      left < this.size() &&
      this.compare(this.items[rootIndex], this.items[left])
    ) {
      rootIndex = left;
    }

    if (
      right < this.size() &&
      this.compare(this.items[rootIndex], this.items[right])
    ) {
      rootIndex = right;
    }

    if (rootIndex !== index) {
      this.swap(rootIndex, index);
      this.heapify(rootIndex);
    }
  }

  poll() {
    if (this.size() === 0) {
      return;
    }

    if (this.size() === 1) {
      return this.items.pop();
    }

    this.swap(0, this.items.length - 1);
    const rootItem = this.items.pop();
    this.heapify(0);
    return rootItem;
  }
}

/*

Median of an array = middle element of the sorted array when the array size is odd, average of the 2 middle items of the sorted array if the array size is even.

The idea is to segregate the entire stream into 2 lists where we'll keep the smaller items in a max heap and the greater 
items in a min heap and calculate the median by taking the average of max item, min item from the max and min heap 
respectively if the list size is even. If the list size is odd, we'll keep the extra item in the max heap and return 
the max item from the max heap as the median of the stream.

*/

class MedianFinder {
  constructor() {
    this.maxHeap = new PriorityQ((a, b) => a - b < 0); // will contain the smaller items
    this.minHeap = new PriorityQ((a, b) => a - b > 0); // will contain the greater items
  }

  /**
   * @param {number} num
   * @return {void}
   */
  addNum(num) {
    if (this.maxHeap.size() === 0) {
      this.maxHeap.add(num);
      return;
    }

    /* when we have more items in the max heap(in case the processed data stream so far was odd length), 
    we should add the current item into the min heap next */
    if (this.minHeap.size() < this.maxHeap.size()) {
      if (num < this.maxHeap.peek()) {
        this.minHeap.add(this.maxHeap.poll());
        this.maxHeap.add(num);
      } else {
        this.minHeap.add(num);
      }
    }
    // when we have the equal number of items in both of the heaps, we should add the current item into the max heap next
    else {
      if (num <= this.maxHeap.peek()) {
        this.maxHeap.add(num);
      } else {
        this.minHeap.add(num);
        this.maxHeap.add(this.minHeap.poll());
      }
    }
  }

  /**
   * @return {number}
   */
  findMedian() {
    if (this.maxHeap.size() > this.minHeap.size()) {
      return this.maxHeap.peek();
    }

    return (this.maxHeap.peek() + this.minHeap.peek()) / 2;
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * const obj = new MedianFinder()
 * obj.addNum(num)
 * const param_2 = obj.findMedian()
 */
