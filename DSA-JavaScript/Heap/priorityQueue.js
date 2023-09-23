// Priority Queue - the better implementation

class PriorityQ {
  /**
   * @param {(a: any, b: any) => -1 | 0 | 1} compare -
   * compare function, similar to parameter of Array.prototype.sort
   */
  constructor(compare) {
    this.compare = compare;
    this.items = [];
  }

  left(index) {
    return 2 * index + 1;
  }

  right(index) {
    return 2 * index + 2;
  }

  parent(index) {
    return Math.floor((index - 1) / 2);
  }

  swap(index1, index2) {
    [this.items[index1], this.items[index2]] = [
      this.items[index2],
      this.items[index1],
    ];
  }

  /**
   * return {number} amount of items
   */
  size() {
    return this.items.length;
  }

  /**
   * returns the head element
   */
  peek() {
    return this.items[0];
  }

  /**
   * @param {any} element - new element to add
   */
  add(element) {
    this.items.push(element);

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

  /**
   * remove the head element
   * @return {any} the head element
   */
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

const minHeap = new PriorityQ((a, b) => a - b > 0);
const maxHeap = new PriorityQ((a, b) => a - b < 0);
minHeap.add(3);
minHeap.add(2);
minHeap.add(1);

maxHeap.add(1);
maxHeap.add(2);
maxHeap.add(3);

console.log("************************MinHeap**********************");

while (minHeap.size() !== 0) {
  console.log(minHeap.poll());
}

console.log("************************MaxHeap**********************");
while (maxHeap.size() !== 0) {
  console.log(maxHeap.poll());
}

//Priority queue and its operations
class PriorityQueueElement {
  constructor(value, priority) {
    this.element = value;
    this.priority = priority;
  }
}

class PriorityQueue {
  constructor() {
    this.items = [];
  }

  isEmpty() {
    return this.items.length === 0;
  }

  peek() {
    if (this.isEmpty()) {
      return "There's no element in the priority queue";
    }

    return this.items[0];
  }

  enqueue(value, priority) {
    const newElement = new PriorityQueueElement(value, priority);
    let added = false;

    for (let i = 0; i < this.items.length; i++) {
      if (newElement.priority < this.items[i].priority) {
        //adding the new element if the new element's priority is less than the current element's priority. Priority less means that has to be processed earlier or dequeued before than the elements with greater priority.
        this.items.splice(i, 0, newElement);
        added = true;
        break;
      }
    }

    if (!added) {
      this.items.push(newElement);
    }
  }

  dequeue() {
    if (this.isEmpty()) {
      return "Underflow";
    }

    return this.items.shift();
  }
}

console.log(
  "************************Priority Queue Operations**********************"
);
const priorityQueue = new PriorityQueue();
priorityQueue.enqueue(10, 4);
priorityQueue.enqueue(20, 6);
priorityQueue.enqueue(60, 2);
priorityQueue.enqueue(40, 8);

console.log(priorityQueue.items);

priorityQueue.dequeue();

console.log(priorityQueue.items);
