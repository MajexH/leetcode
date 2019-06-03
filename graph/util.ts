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
