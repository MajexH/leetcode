import { Graph } from './Graph'
import { Node } from './Node'

export class Search {

  private _graph: Graph;
  private _point: number;
  private _node: Node<number>;

  constructor(graph: Graph, point:number) {
    this._graph = graph;
    this._point = point;
    this._node = graph.adjacent(point);
  }

  set graph(graph: Graph) {
    this._graph = graph;
  }

  get graph() {
    return this._graph;
  }
  
  set point(point: number) {
    this._point = point;
  }

  get point() {
    return this._point;
  }

  /**
   * 判断point和pointAnother是否是连通的
   * @param pointAnother 
   */
  public marked (pointAnother: number): boolean {
    let node = this._node || this._graph.adjacent(this._point);
    while (node) {
      if (node.val === pointAnother) return true
      node = node.next
    }
    return false
  }

  /**
   * 与point连接的节点总数
   */
  public count(): number {
    let node = this._node || this._graph.adjacent(this._point), res = 0;
    while (node) {
      if (node.val) res++;
      node = node.next;
    }
    return res
  }
}

export class DepthFirstSearch {

  private marked: boolean[];
  private graph: Graph;

  constructor(graph: Graph) {
    this.graph = graph;
    this.marked = new Array(graph.pointNumber)
    for (let i = 0; i < this.marked.length; i++) {
      this.marked[i] = false
    }
  }

  /**
   * 递归实现dfs
   * @param start 开始的节点
   */
  public dfsWithRecursion(start?: number) {
    start = start || 0
    console.log(start)
    this.marked[start] = true
    let node = this.graph.adjacent(start)
    while (node) {
      if (node.val && !this.marked[node.val])
        this.dfsWithRecursion(node.val)
      node = node.next
    }
  }

  /**
   * 非递归实现
   * @param start 开始的节点
   */
  public dfsWithoutRecursion(start?: number) {
    start = start || 0
    let stack: number[] = []
    stack.push(start)
    while (stack.length !== 0) {
      let current = stack.pop(), node = this.graph.adjacent(current)
      this.marked[current] = true
      console.log(current)
      while (node) {
        if (node.val && !this.marked[node.val]) {
          stack.push(node.val)
          this.marked[node.val] = true
        }
        node = node.next
      }
    }
  }
}

export class BreadthFirstSearch{

  private marked: boolean[];
  private graph: Graph;
  private edgeTo: number[];

  constructor(graph: Graph) {
    this.graph = graph;
    this.edgeTo = Array(graph.pointNumber)
    this.marked = new Array(graph.pointNumber)
    for (let i = 0; i < this.marked.length; i++) {
      this.marked[i] = false
    }
  }

  public bfs(start?: number) {
    start = start || 0
    let queue = []
    queue.push(start)
    this.marked[start] = true
    while (queue.length !== 0) {
      let item = queue.shift(), node = this.graph.adjacent(item);
      while (node) {
        if (node.val && !this.marked[node.val]) {
          queue.push(node.val)
          this.marked[node.val] = true
          console.log(node.val, item)
          this.edgeTo[node.val] = item
        }
        node = node.next
      }
    }
  }

  public hasPathTo(target: number) {
    return this.marked[target];
  }

  public pathTo(start, target) {
    if (!this.hasPathTo(target)) return null
    let res = []
    for (let i = target; i !== start; i = this.edgeTo[i]) {
      res.push(i)
    }
    res.push(start)
    return res.reverse().join('-')
  }
}

export class Paths {

  private _graph: Graph;
  // 起点
  private _point: number;
  public _edgeTo: number[];
  private _marked: boolean[];

  constructor(graph: Graph, point: number) {
    this._graph = graph
    this._point = point
    this._edgeTo = Array(graph.pointNumber)
    this._marked = Array(graph.pointNumber)
    for (let i = 0; i < graph.pointNumber; i++) {
      this._marked[i] = false;
      this._edgeTo[i] = -1;
    }
    this.dfs(point)
  }

  private dfs(start: number) {
    this._marked[start] = true
    let node = this._graph.adjacent(start)
    while (node) {
      if (node.val && !this._marked[node.val]) {
        this._edgeTo[node.val] = start
        this.dfs(node.val)
      }
      node = node.next
    }
  }

  public hasPathTo(target: number) {
    return this._marked[target];
  }

  public pathTo(target) {
    if (!this.hasPathTo(target)) return null
    let res = []
    for (let i = target; i !== this._point; i = this._edgeTo[i]) {
      res.push(i)
    }
    res.push(this._point)
    return res.reverse().join('-')
  }

  /**
   * 利用dfs 找到所有从start到target的路径
   * @param temp 
   * @param res 结果存储的数组
   * @param start 
   * @param target 
   * @param visited 防止出现0-0这种闭环 死循环
   */
  public allPath(temp: number[], res: number[][], start: number, target: number, visited: boolean[]) {
    if (start === target) {
      temp.push(start)
      res.push(JSON.parse(JSON.stringify(temp)))
      temp.pop()
      return
    }
    let node = this._graph.adjacent(start)
    while (node) {
      if (node.val && !visited[node.val]) {
        temp.push(start)
        visited[start] = true
        this.allPath(temp, res, node.val, target, visited)
        temp.pop()
        visited[start] = false
      }
      node = node.next
    }
  }

}
