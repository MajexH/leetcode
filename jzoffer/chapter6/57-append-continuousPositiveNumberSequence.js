/**
 * 给定一个target 找到一个连续的正数序列 其和为target
 * @param {number} target
 */
function continuousPositiveNumberSequence(target) {
  // 初始化
  let i = 1, j = 2
  let res = []
  while (i < Math.floor((target + 1) / 2)) {
    // 连续数列和
    let sum = (i + j) * (j - i + 1) / 2
    // 和如果比现有的需要的大 则移动小的一面 让整个数列变小
    while (sum > target && i < j) {
      sum -= i
      i++
    }
    // 如果此时 拿到了结果 则介入
    if (sum === target) {
      res.push([i, j])
    }
    j++
  }
  return res
}

console.log(continuousPositiveNumberSequence(15))