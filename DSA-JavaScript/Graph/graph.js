//Graph and its basic operations
class Graph {
	constructor() {
		this.adjacencyList = {};
	}

	addVertex(vertex) {
		if (!this.adjacencyList[vertex]) {
			this.adjacencyList[vertex] = [];
		}
	}

	addEdge(vertex1, vertex2){
		this.adjacencyList[vertex1].push(vertex2);
		this.adjacencyList[vertex2].push(vertex1);
	}

	removeEdge(vertex1, vertex2){
		this.adjacencyList[vertex1] = this.adjacencyList[vertex1].filter(vertex => vertex !== vertex2);
		this.adjacencyList[vertex2] = this.adjacencyList[vertex2].filter(vertex => vertex !== vertex1);
	}

	removeVertex(vertex){
		//remove all the edges between the removed vertex and its adjacent vertices
		while(this.adjacencyList[vertex].length){
			const adjacentVertex = this.adjacencyList[vertex].pop();
			this.removeEdge(vertex, adjacentVertex);
		}

		delete this.adjacencyList[vertex]; //removing the key from the adjacency list
	}

	DFS(startingVertex){
		const visited = {}, result = [];

		return this.DFSUtil(startingVertex, visited, result);		
	}

	DFSUtil(startingVertex, visited, result){
		if(!startingVertex){
			return result;
		}

		visited[startingVertex] = true;
		result.push(startingVertex);		

		this.adjacencyList[startingVertex].forEach(neighbor => {
			if(!visited[neighbor]){
				result = this.DFSUtil(neighbor, visited, result);
			}
		});

		return result;
	}

	BFS(startingVertex){
		const visited = {}, queue = [], result = [];

		visited[startingVertex] = true;
		queue.push(startingVertex);

		let currentVertex;
		while(queue.length){
			currentVertex = queue.shift();
			result.push(currentVertex);

			this.adjacencyList[currentVertex].forEach(neighbor => {
				if(!visited[neighbor]){
					visited[neighbor] = true;
					queue.push(neighbor);
				}
			});			
		}

		return result;
	}
}

console.log("*********************Graph Operations**********************");
const graph = new Graph();
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");
graph.addVertex("E");
graph.addVertex("F");

graph.addEdge('A', 'B');
graph.addEdge('A', 'D');
graph.addEdge('A', 'E');
graph.addEdge('B', 'C');
graph.addEdge('D', 'E');
graph.addEdge('E', 'F');
graph.addEdge('E', 'C');
graph.addEdge('C', 'F');

console.log(graph.adjacencyList);

graph.removeEdge("A", "E");

console.log(graph.adjacencyList);

graph.removeVertex("B");

console.log(graph.adjacencyList);

console.log(graph.DFS("A"));
console.log(graph.BFS("A"));