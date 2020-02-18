/**
 * 给定两个数组 第一个是 压栈的顺序 第二个是 出栈的顺序
 * 判断 第二个 出栈的顺序 是否是压栈顺序的 合法输出 并返回
 * 模拟题
 * related to leetcode 946
 * @param {Array} inOrder 
 * @param {Array} outOrder
 * @returns {boolean} 
 */
function checkStackPath(inOrder, outOrder) {
  let stack = []

  // 两个栈的指针
  let i = 0, j = 0
  // 把入栈压入栈顶 如果发现 入栈时头跟 出栈的头是一样
  // 说明现在这个时候该出栈 出栈即可
  for (i = 0; i < inOrder.length; i++) {
    if (inOrder[i] === outOrder[j]) {
      // 找到一个outOrder中的弹出元素了
      j++
      // 如果栈里面的 有相同的元素 继续弹栈
      while (j < outOrder.length && stack.length > 0 && stack[stack.length - 1] === outOrder[j]) {
        stack.pop()
        j++
      }
    }
    else {
      stack.push(inOrder[i])
    }
  }
  return stack.length === 0
}

console.log(checkStackPath([1,2,3,4,5], [4,5,3,2,1]))
console.log(checkStackPath([1,2,3,4,5], [4,3,5,1,2]))