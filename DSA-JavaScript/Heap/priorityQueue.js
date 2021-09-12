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
