/**
 * 红黑树就是用普通的二叉树来标识2-3树
 * 将3节点表示成两个2节点 其中左边的那个2节点是红色的 右边是黑色的
 * 所以叫红黑树
 * */
var Tree = /** @class */ (function () {
    function Tree(val, left, right, color) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.color = color;
    }
    return Tree;
}());
function isRed(node) {
    // 默认空节点是黑色的
    if (!node)
        return false;
    return node.color;
}
/**
 * 有时候节点的右连接是红色的 所以需要将该节点向下旋转
 * 将左边的连接改成红色
 * @param {Tree} node
 * @return {Tree}
 */
function rotateLeft(node) {
    var right = node.right;
    node.right = right.left;
    right.left = node;
    right.color = node.color;
    node.color = true;
    return right;
}
/**
 * 与rotateLeft相对 现在rotateright
 * 即将左边的红色连接改到右边
 * @param node
 */
function rotateRight(node) {
    var left = node.left;
    node.left = left.right;
    left.right = node;
    left.color = node.color;
    node.color = true;
    return left;
}
/**
 * 红黑树的插入
 * @param node 根节点
 * @param val 要插入的值
 */
function put(node, val) {
    if (!node)
        return new Tree(val, null, null, true);
    if (val < node.val)
        node.left = put(node.left, val);
    else
        node.right = put(node.right, val);
    if (isRed(node.right) && !isRed(node.left))
        node = rotateLeft(node);
    if (isRed(node.left) && isRed(node.left.left))
        node = rotateRight(node);
    if (isRed(node.left) && isRed(node.right))
        changeColor(node);
    return node;
}
/**
 * 用于在旋转后改变颜色
 * @param {Tree} node
 */
function changeColor(node) {
    node.color = true;
    node.left.color = false;
    node.right.color = false;
}
(function () {
    var node = null;
    for (var i = 0; i <= 90; i++) {
        node = put(node, i);
    }
    console.log(node);
})();
