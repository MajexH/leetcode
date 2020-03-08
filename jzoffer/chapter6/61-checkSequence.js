/**
 * 给定一个array数组 判断是不是连子
 * 其中2-10代表各自的数字 j 11 q 12 k 13 a为1
 * 大王小王为任意的数字 在这里用特殊的字符0表示
 * @param {number[]} array 表示抽到的数字 
 */
function checkSequence(array) {
  // 从小到大排序
  array.sort((a, b) => a - b)
  let numberOfZero = 0
  // 统计其中的任意的数有多少 即0有多少个
  for (let i = 0; i < array.length && array[i] === 0; i++) {
      numberOfZero++
  }
  // 非0开始的index
  let pre = numberOfZero
  let next = pre + 1
  // 只要其中的0的数儿能够填满中间的其他数儿之间的空隙就可以
  let gap = 0
  while (pre < array.length - 1) {
    // 有对子 不可能是连续的
    if (array[next] === array[pre]) return false
    gap += array[next] - array[pre] - 1
    pre++
    next++
  }
  return numberOfZero >= gap ? true : false
}

console.log(checkSequence([4,8,7,6,0]))