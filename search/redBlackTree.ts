/** 
 * 红黑树就是用普通的二叉树来标识2-3树
 * 将3节点表示成两个2节点 其中左边的那个2节点是红色的 右边是黑色的
 * 所以叫红黑树
 * */ 
class Tree {
  public val: number;
  public left: Tree;
  public right: Tree;
  // color标识这个节点的父节点连接到这个节点时是红色的还是黑色的
  // 红色的就标识这个节点跟父节点其实合起来是一个3节点
  // true 红色 false 黑色
  public color: boolean;

  constructor(val: number, left: Tree, right: Tree, color: boolean) {
    this.val = val
    this.left = left
    this.right = right
    this.color = color
  }
}

(() => {

})()