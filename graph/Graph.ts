import { Node } from './Node';

// 无向图
export class Graph {
  // 用邻接表来表示图 Node使用了泛型来保存每个point的标识
  private _pointNumber: number;
  private _array: Node<number>[];

  constructor (pointNumber: number) {
    this._pointNumber = pointNumber
    this._array = Array(pointNumber)
    // 初始化邻接表
    for (let i = 0; i < pointNumber; i++) {
      // 在数组中保存一个链表的引用
      this._array[i] = new Node<number>();
    }
  }

  get pointNumber(): number {
    return this._pointNumber
  }

  set pointNumber(pointNumber: number) {
    this._pointNumber = pointNumber
  }

  /**
   * 增加一条x-y的边
   * @param pointX 
   * @param pointY 
   */
  public addEdge(pointX: number, pointY: number): void {
    // 需要判断当前的这个是不是已经存在边了 这两个节点
    // 因为是无向图 所以需要在两边都加上
    let node = this.adjacent(pointX), nodeY = this.adjacent(pointY)
    while (node.next) {
      if (node.val && node.val === pointY) {
        return
      }
      node = node.next
    }
    node.next = new Node<number>(pointY)
    while (nodeY.next) {
      nodeY = nodeY.next
    }
    nodeY.next = new Node<number>(pointX)
  }

  /**
   * 返回point相邻的所有节点
   * @param pointNumber 
   */
  public adjacent(point: number): Node<number> {
    return this._array[point]
  }
}

