//Tree and its operations
class TreeNode {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

//Binary Search Tree(BST) and its operations
class BST {
  constructor() {
    this.root = null;
  }

  insert(key) {
    const newNode = new TreeNode(key);

    if (!this.root) {
      return (this.root = newNode);
    }

    this.insertNode(this.root, newNode);
  }

  //Recursive approach
  insertNode(root, newNode) {
    if (!root) {
      return newNode;
    }

    if (newNode.data < root.data) {
      root.left = this.insertNode(root.left, newNode);
    } else {
      root.right = this.insertNode(root.right, newNode);
    }

    return root;
  }

  remove(key) {
    if (!this.root) {
      return "BST is empty! Please add some nodes";
    }

    this.root = this.removeNode(this.root, key);
  }

  removeNode(root, key) {
    if (!root) {
      console.log("The key doesn't exist in the BST");
      return null;
    }

    if (key < root.data) {
      root.left = this.removeNode(root.left, key);
    } else if (key > root.data) {
      root.right = this.removeNode(root.right, key);
    } else {
      //if the deleted node has no left child, then right child will take place of the deleted node
      if (!root.left) {
        return root.right;
      }

      //if the deleted node has no right child, then left child will take place of the deleted node
      if (!root.right) {
        return root.left;
      }

      //if the deleted node has both the childs, then replace the data of the deleted node with its closest greater successor and delete the successor node. To get the greater successor node, we need to find the node with min value at the right subtree of the deleted node
      const greaterSuccessor = this.getMin(root.right);
      root.data = greaterSuccessor.data;
      root.right = this.removeNode(root.right, greaterSuccessor.data);
    }

    return root;
  }

  DFS() {
    console.log("*****************Inorder traversal*******************");
    this.inorder();
    console.log("***************Preorder traversal*****************");
    this.preorder();
    console.log("****************Postorder traversal***************");
    this.postorder();
  }

  inorder(root = this.root) {
    if (!root) return;

    this.inorder(root.left);
    console.log(root.data);
    this.inorder(root.right);
  }

  preorder(root = this.root) {
    if (!root) {
      return;
    }

    console.log(root.data);
    this.preorder(root.left);
    this.preorder(root.right);
  }

  postorder(root = this.root) {
    if (!root) {
      return;
    }

    this.postorder(root.left);
    this.postorder(root.right);
    console.log(root.data);
  }

  BFS() {
    const data = [],
      queue = [];

    if (this.root) {
      queue.push(this.root);
    }

    while (queue.length) {
      const popped = queue.shift();
      data.push(popped.data);

      if (popped.left) {
        queue.push(popped.left);
      }

      if (popped.right) {
        queue.push(popped.right);
      }
    }

    return data;
  }

  search(key, root = this.root) {
    if (!root) {
      return false;
    }

    if (root.data === key) {
      return true;
    }

    if (key < root.data) {
      return this.search(key, root.left);
    } else {
      return this.search(key, root.right);
    }
  }

  getMin() {
    let current = this.root;

    if (!current) {
      return "BST is empty! Please add some nodes";
    }

    while (current.left) {
      current = current.left;
    }

    return current.data;
  }

  getMax() {
    let current = this.root;

    if (!current) {
      return "BST is empty! Please add some nodes";
    }

    while (current.right) {
      current = current.right;
    }

    return current.data;
  }
}

console.log("************************BST Operations**********************");
const bst = new BST();
bst.insert(10);
bst.insert(1);
bst.insert(12);
bst.insert(5);
bst.DFS();

console.log("**********BFS traversal************");
console.log(bst.BFS());
bst.remove(12);
console.log(bst.BFS());
console.log("***************BST Search************");
console.log(bst.search(12));
console.log(bst.search(13));
console.log("*************BST Min-max*************");
console.log(bst.getMin());
console.log(bst.getMax());
