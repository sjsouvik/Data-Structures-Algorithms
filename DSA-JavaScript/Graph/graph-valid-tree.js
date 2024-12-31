/*

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:

Input:
n = 5
edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

Output:
true
Example 2:

Input:
n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

Output:
false
Note:

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2

****************************************************Solution******************************************************/

class Solution {
  /**
   * @param {number} n
   * @param {number[][]} edges
   * @returns {boolean}
   */

  /*
  
  According to the definition of a tree, a tree is an undirected graph with no cycles, all the nodes are 
  connected as one component, and any two nodes have exactly one path.
  
  Time complexity: O(V + E), space complexity: O(V) where V is the number of vertices and 
  E is the number of edges

  */
  validTree(n, edges) {
    const adjacencyList = Array(n)
      .fill(null)
      .map(() => []);

    for (const [u, v] of edges) {
      adjacencyList[u].push(v);
      adjacencyList[v].push(u);
    }

    let visitedNodes = 0;

    /*
    // DFS solution
    const visited = Array(n).fill(false);

    function detectCycle(node, parent) {
      visited[node] = true;
      visitedNodes++;

      for (const neighbor of adjacencyList[node]) {
        if (visited[neighbor] === false) {
          detectCycle(neighbor, node);
        } else if (neighbor !== parent) {
          return true;
        }
      }

      return false;
    }

    return detectCycle(0, -1) === false && visitedNodes === n;
    */

    // BFS solution
    function detectCycle() {
      const queue = [[0, -1]]; // [currentNode, parentNode]
      const visited = Array(n).fill(false);

      while (queue.length) {
        const [node, parent] = queue.shift();
        visited[node] = true;
        visitedNodes++;

        for (const neighbor of adjacencyList[node]) {
          if (visited[neighbor] === false) {
            queue.push([neighbor, node]);
          } else if (neighbor !== parent) {
            return true;
          }
        }
      }

      return false;
    }

    return detectCycle() === false && visitedNodes === n;
  }
}
