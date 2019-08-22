/**
 * 一个数字后面跟了2个#号的时候，必然会形成一个 数字的叶子节点 即这个节点不能再被插入任何数字
 * 因此 使用栈来保存这个前序序列 当出现上述情况时 吧这个数字节点退栈 并加入一个#
 * 代表上层的节点的这个子树已经访问完毕
 * 因此 如果最后正确的话 这个栈内应该只有一个#号存在 
 * @param {string} preorder
 * @return {boolean}
 */
var isValidSerialization = function(preorder) {
  let stack = [], strs = preorder.split(',')
  for (let str of strs) {
    stack.push(str)
    while (stack[stack.length - 1] === '#' && stack[stack.length - 2] === '#') {
      if (stack.length - 2 < 0 || stack.length - 3 < 0) return false
      stack = stack.slice(0, stack.length - 3)
      stack.push('#')
    }
  }
  return stack.length === 1 && stack[stack.length - 1] === '#'
};

console.log(isValidSerialization("1,#,#,#,#"))