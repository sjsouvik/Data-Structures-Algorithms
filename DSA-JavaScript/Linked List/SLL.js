//Singly Linked List and its operations
class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class SLL {
  constructor() {
    this.head = null;
  }

  insertAtFirst(val) {
    const newNode = new Node(val);

    if (!this.head) {
      return (this.head = newNode);
    }

    newNode.next = this.head;
    this.head = newNode;
  }

  insertAtMiddle(index, newVal) {
    const newNode = new Node(newVal);

    let temp = this.head,
      prev = null,
      i = 0;

    if (index === 0) {
      newNode.next = this.head;
      return (this.head = newNode);
    }

    while (i !== index && temp) {
      prev = temp;
      temp = temp.next;
      i++;
    }

    prev.next = newNode;
    newNode.next = temp;
  }

  insertAtEnd(val) {
    const newNode = new Node(val);

    if (!this.head) {
      return (this.head = newNode);
    }

    let temp = this.head;
    while (temp.next) {
      temp = temp.next;
    }

    temp.next = newNode;
  }

  printList() {
    let temp = this.head;
    while (temp) {
      console.log(temp.data);
      temp = temp.next;
    }
  }
}

console.log("**************Singly Linked List operations**************");
const sll = new SLL();
sll.insertAtEnd(10);
sll.insertAtEnd(20);
sll.insertAtEnd(30);
sll.insertAtFirst(5);
sll.insertAtMiddle(2, 15);
sll.printList();
