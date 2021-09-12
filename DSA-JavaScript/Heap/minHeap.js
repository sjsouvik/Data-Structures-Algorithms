class MinHeap {
  constructor() {
    this.items = [];
  }

  parent(index) {
    return Math.floor((index - 1) / 2);
  }

  left(index) {
    return 2 * index + 1;
  }

  right(index) {
    return 2 * index + 2;
  }

  swap(index1, index2) {
    const temp = this.items[index1];
    this.items[index1] = this.items[index2];
    this.items[index2] = temp;
  }

  //Time complexity: O(log n) as we are swaping the elements along the height of the binary heap
  insert(newItem) {
    this.items.push(newItem);

    let i = this.items.length - 1;
    while (i !== 0 && this.items[i] < this.items[this.parent(i)]) {
      this.swap(i, this.parent(i));
      i = this.parent(i);
    }
  }

  //Time complexity: O(height) = O(log n) as we are swaping the elements along the height of the binary heap
  minHeapify(index) {
    const l = this.left(index),
      r = this.right(index),
      size = this.items.length;

    let smallest = index;

    if (l < size && this.items[l] < this.items[smallest]) {
      smallest = l;
    }

    if (r < size && this.items[r] < this.items[smallest]) {
      smallest = r;
    }

    if (smallest !== index) {
      this.swap(index, smallest);
      this.minHeapify(smallest);
    }
  }

  getMin() {
    return this.items[0];
  }

  //In this operation, we need to delete and return the smallest element i.e. root element from the min heap. For that, we need to swap the root element with the last element in the heap. Then, pop the last element and apply min heapify method for the root element.
  extractMin() {
    if (this.items.length === 0) {
      return;
    }
    if (this.items.length === 1) {
      return this.items.pop();
    }

    this.swap(0, this.items.length - 1);
    const minItem = this.items.pop();

    this.minHeapify(0);

    return minItem;
  }

  //in this operation, the value would be updated for the given index. And once it's updated, we need to compare the new value with its parent just like we do in case of new value insertion.
  decreaseKey(index, newValue) {
    if (index >= this.items.length) {
      return;
    }

    this.items[index] = newValue;

    while (index !== 0 && this.items[index] < this.items[this.parent(index)]) {
      this.swap(index, this.parent(index));
      index = this.parent(index);
    }
  }

  //in this operation, the idea is to replace the value at the given index with -infinity, so we have used decreaseKey() operation for that as we are decreasing the value at that index using the smallest number and then, delete the smallest item from the heap, so we have used extractMin() operation for that.
  delete(index) {
    this.decreaseKey(index, Number.MIN_VALUE);
    this.extractMin();
  }

  //TODO: build heap operation from the given array
}

console.log("************************MinHeap Operations**********************");
const minHeap = new MinHeap();
minHeap.insert(30);
minHeap.insert(20);
minHeap.insert(10);
minHeap.insert(15);
minHeap.insert(1);
minHeap.insert(5);

console.log(minHeap.items);

console.log(minHeap.getMin());

console.log(minHeap.items);
console.log(minHeap.extractMin());
console.log(minHeap.items);

minHeap.decreaseKey(1, 4);
console.log(minHeap.items);

minHeap.delete(2);
console.log(minHeap.items);
