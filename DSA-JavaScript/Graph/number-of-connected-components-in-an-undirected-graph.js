/*

There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that 
there is an edge between node a and node b in the graph.

The nodes are numbered from 0 to n - 1.

Return the total number of connected components in that graph.

Example 1:

Input:
n=3
edges=[[0,1], [0,2]]

Output:
1

Example 2:

Input:
n=6
edges=[[0,1], [1,2], [2,3], [4,5]]

Output:
2

Constraints:

1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2

********************************************************Solution**************************************************/

function countComponents(n, edges) {
  const adjacencyList = Array(n)
    .fill(null)
    .map((_) => []);
  const visited = Array(n).fill(false);

  for (const [u, v] of edges) {
    adjacencyList[u].push(v);
    adjacencyList[v].push(u);
  }

  function bfs(vertex) {
    const queue = [];
    queue.push(vertex);
    visited[vertex] = true;

    while (queue.length) {
      const removedVertex = queue.shift();

      for (const item of adjacencyList[removedVertex]) {
        if (!visited[item]) {
          visited[item] = true;
          queue.push(item);
        }
      }
    }
  }

  let output = 0;
  for (let i = 0; i < n; i++) {
    if (!visited[i]) {
      bfs(i);
      output += 1;
    }
  }

  return output;
}
