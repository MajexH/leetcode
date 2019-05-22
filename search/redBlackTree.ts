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

function isRed(node: Tree) {
  // 默认空节点是黑色的
  if (!node) return false
  return node.color
}

/**
 * 有时候节点的右连接是红色的 所以需要将该节点向下旋转
 * 将左边的连接改成红色
 * @param {Tree} node
 * @return {Tree}
 */
function rotateLeft(node : Tree) : Tree {
  let right = node.right
  node.right = right.left
  right.left = node
  right.color = node.color
  node.color = true
  return right
}

/**
 * 与rotateLeft相对 现在rotateright
 * 即将左边的红色连接改到右边
 * @param node 
 */
function rotateRight(node: Tree) : Tree {
  let left = node.left
  node.left = left.right
  left.right = node
  left.color = node.color
  node.color = true
  return left
}

/**
 * 红黑树的插入
 * @param node 根节点
 * @param val 要插入的值
 */
function put(node : Tree, val : number) {
  if (!node) return new Tree(val, null, null, true)
  if (val < node.val) node.left = put(node.left, val)
  else node.right = put(node.right, val)
  if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node)
  if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node)
  if (isRed(node.left) && isRed(node.right)) changeColor(node)
  return node
}

/**
 * 用于在旋转后改变颜色
 * @param {Tree} node 
 */
function changeColor(node : Tree) : void {
  node.color = true
  node.left.color = false
  node.right.color = false
}

(() => {
  let node = null;
  for (let i = 0; i <= 90; i++) {
    node = put(node, i)
  }
  console.log(node)
})()