//Queue and its operations
class Queue {
  constructor() {
    this.items = [];
  }

  add(val) {
    this.items.unshift(val);
  }

  isEmpty() {
    return this.items.length === 0;
  }

  peek() {
    if (this.isEmpty()) {
      return "Underflow! Queue is empty";
    }

    return this.items[this.items.length - 1];
  }

  remove() {
    if (this.isEmpty()) {
      return "Underflow! Queue is empty";
    }

    return this.items.pop();
  }

  printQueue() {
    for (let i = this.items.length - 1; i >= 0; i--) {
      console.log(this.items[i]);
    }
  }
}

console.log("**************Queue operations**************");
const queue = new Queue();
console.log(queue.peek());
queue.add(50);
queue.add(60);
queue.printQueue();
console.log("Peek element of the queue is ", queue.peek());
console.log(queue.remove());
console.log(queue.remove());
console.log(queue.remove());
