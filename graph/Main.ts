import { Graph } from './Graph';
import { Search, DepthFirstSearch, Paths, BreadthFirstSearch } from './util'

let graph = new Graph(7);
graph.addEdge(0, 1)
graph.addEdge(0, 2)
graph.addEdge(0, 5)
graph.addEdge(0, 6)
graph.addEdge(3, 4)
graph.addEdge(3, 5)
graph.addEdge(4, 5)
graph.addEdge(4, 6)
graph.addEdge(4, 3)

let node = graph.adjacent(3)
while (node) {
  console.log(node.val)
  node = node.next
}

let search = new Search(graph, 3);
console.log(search.count(), search.marked(6))

console.log('-------------------------')

let dfsWithRecursion = new DepthFirstSearch(graph)
dfsWithRecursion.dfsWithRecursion();

console.log('-------------------------')

let dfsWithoutRecursion = new DepthFirstSearch(graph)
dfsWithoutRecursion.dfsWithoutRecursion()

console.log('-------------------------')

let paths = new Paths(graph, 0)
console.log(paths.pathTo(6))

console.log('-------------------------')

let res = [], marked = []
for (let i = 0; i < graph.pointNumber; i++) {
  marked[i] = false
}
paths.allPath([], res, 0, 6, marked)
console.log(res)
res.sort((a, b) => {
  return a.length - b.length
})
console.log(res)

console.log('-------------------------')
console.log('----------BFS------------')

let bfs = new BreadthFirstSearch(graph);
bfs.bfs(0)
for (let i = 1; i < graph.pointNumber; i++) {
   console.log(bfs.pathTo(0, i))
}
