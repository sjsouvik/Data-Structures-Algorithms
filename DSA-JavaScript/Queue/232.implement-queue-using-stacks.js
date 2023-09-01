/*

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

**************************************************************Solution************************************************************/

class MyQueue {
  constructor() {
    this.mainStack = [];
    this.auxStack = [];
  }

  /* push operation is costly in this solution where we are moving all items from the main stack to the auxiliary stack 
  before pushing the new item to the main stack and then after adding the new item to the main stack, 
  we're again pushing all the items from the auxiliary stack to the main stack - so that we can keep 
  the oldest/first entered item at the top of the main stack */
  push(x) {
    while (this.mainStack.length) {
      this.auxStack.push(this.mainStack.pop());
    }

    this.mainStack.push(x);

    while (this.auxStack.length) {
      this.mainStack.push(this.auxStack.pop());
    }
  }

  pop() {
    if (this.empty()) {
      return -1;
    }

    return this.mainStack.pop();
  }

  peek() {
    if (this.empty()) {
      return -1;
    }

    return this.mainStack[this.mainStack.length - 1];
  }

  empty() {
    return this.mainStack.length === 0;
  }
}
