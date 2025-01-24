/*

You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval 
can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: 
there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.


Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 
3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals 
have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling 
twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100

*******************************************************Solution***************************************************/

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

function leastInterval(tasks, n) {
  const tasksCount = Array(26).fill(0);

  for (const task of tasks) {
    tasksCount[task.charCodeAt(0) - "A".charCodeAt(0)]++;
  }

  const maxHeap = new PriorityQ((a, b) => a - b < 0);

  for (const taskCount of tasksCount) {
    if (taskCount > 0) {
      maxHeap.add(taskCount);
    }
  }

  const queue = [];
  let time = 0;
  while (maxHeap.size() || queue.length) {
    time++;

    if (maxHeap.size() > 0) {
      const updatedCount = maxHeap.poll() - 1;
      if (updatedCount > 0) {
        queue.push([updatedCount, time + n]);
      }
    }

    if (queue.length && queue[0][1] === time) {
      maxHeap.add(queue.shift()[0]);
    }
  }

  return time;
}
