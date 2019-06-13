function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {number} n
 * @return {TreeNode[]}
 */
var generateTrees = function(n) {
  if (n === 0) return []
  return recursion(1, n, new Map())
};

/**
 * 左边的只能是小于他的 右边的 只能是大于他的
 * @param {number} start
 * @param {number} end
 * @param {Map} memo
 */
function recursion(start, end, memo) {
  if (memo.has(start + '-' + end)) {
    return memo.get(start + '-' + end)
  }
  // 用这个来保存每个for里面的生成的节点
  let temp = []
  if (start > end) {
    temp.push(null)
    memo.set(start + '-' + end, temp)
    return temp
  }
  for (let i = start; i <= end; i++) {
    let left = recursion(start, i - 1, memo), right = recursion(i + 1, end, memo)
    for (let leftItem of left) {
      for (let rightItem of right) {
        let node = new TreeNode(i)
        node.left = leftItem
        node.right = rightItem
        temp.push(node)
      }
    }
    memo.set(start + '-' + end, temp)
  }
  return temp
}

console.log(generateTrees(4))
