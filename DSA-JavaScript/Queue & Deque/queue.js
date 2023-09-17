//Queue and its operations
class Queue {
	constructor() {
		this.items = [];
		this.front = 0;
		this.rear = 0;
	}

	add(val) {
		this.items[this.rear++] = val;		
	}

	isEmpty() {
		return this.front === this.rear;
	}

	peek() {
		if (this.isEmpty()) {
			return "Underflow! Queue is empty";
		}

		return this.items[this.front];
	}

	remove() {
		if (this.isEmpty()) {
      this.front = this.rear = 0;      
			return "Underflow! Queue is empty";
		}

		return this.items[this.front++];
	}

	printQueue() {
		for (let i = this.front; i < this.rear; i++) {
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
console.log("Peek element of the queue is", queue.peek());
console.log(queue.remove());
console.log(queue.remove());
console.log(queue.remove());
