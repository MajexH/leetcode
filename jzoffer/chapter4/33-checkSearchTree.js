/**
 * 
 * @param {Array} array 
 */
function checkSearchTree(array) {
  return recursion(array, 0, array.length - 1, Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER)
}

/**
 * 
 * @param {Array} array 
 * @param {number} start 
 * @param {number} end 
 * @param {number} max 
 * @param {number} min 
 */
function recursion(array, start, end, max, min) {
  // 越界
  if (start > end || start < 0 || end >= array.length)
    return false
  let rootVal = array[end]
  // 遍历到最后一个了 完成
  if (start === end) return rootVal < max && rootVal > min
  let i = end - 1
  // 找到第一个小于它的数儿 这个地方就是左右子树的分界点
  for (; i >= start; i--) {
    // 不符合二叉搜索树的定义
    if (array[i] > max || array[i] < min) return false
    if (array[i] < rootVal) break
  }
  return recursion(array, start, i, rootVal, min) && recursion(array, i + 1, end - 1, max, rootVal)
}

console.log(checkSearchTree([5,7,6,9,11,10,8]))