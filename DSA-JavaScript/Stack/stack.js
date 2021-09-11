//Stack and its operations
class Stack {
  constructor() {
    this.items = [];
  }

  push(data) {
    this.items.push(data);
  }

  isEmpty() {
    return this.items.length === 0;
  }

  peek() {
    if (this.isEmpty()) {
      return "Stack is empty";
    }

    return this.items[this.items.length - 1];
  }

  pop(data) {
    if (this.isEmpty()) {
      return "Underflow! Stack is empty";
    }

    return this.items.pop();
  }

  printStack() {
    this.items.forEach((item) => console.log(item));
  }
}

console.log("**************Stack operations**************");
const stack = new Stack();
console.log(stack.peek());
stack.push(50);
stack.push(60);
stack.printStack();
console.log("Peek element of the stack is ", stack.peek());
console.log(stack.pop());
console.log(stack.pop());
console.log(stack.pop());
