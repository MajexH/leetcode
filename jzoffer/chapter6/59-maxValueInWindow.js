/**
 * 找到所有的 以windows size为大小的滑动窗口中的 最大的数字
 * @param {number[]} array
 * @param {number} windowSize
 */
function findAllMaxValueInWindow(array, windowSize) {
  if (array.length == 0 || windowSize == 0) return []
  let res = [], dequeue = []
  // 初始化的 第一个窗口期的 最大值数组
  for (let i = 0; i < windowSize; i++) {
    // 这个地方的时候 一定不可能存在超过 滑动窗口 的大小超过 k 的大小的问题
    while (dequeue.length !== 0 && array[i] >= array[dequeue[dequeue.length - 1]]) {
      dequeue.pop()
    }
    dequeue.push(i)
  }
  for (let i = windowSize; i < array.length; i++) {
    // 这个时候的窗口最大值 由 dequeue 中的最大值 决定
    res.push(array[dequeue[0]])
    // 更新最大值的 dequeue 数组
    while (dequeue.length !== 0 && array[i] >= array[dequeue[dequeue.length - 1]]) {
      dequeue.pop()
    }
    // 当前的最大值 超过了窗口范围
    // 超过了之后 之前的 dequeue 中 第一个已经不可能再是最大值了
    if (dequeue.length !== 0 && dequeue[0] <= (i - windowSize)) {
      dequeue.shift()
    }
    dequeue.push(i)
  }
  // 最后一个
  res.push(array[dequeue[0]])

  return res
}


console.log(findAllMaxValueInWindow([2,3,4,2,6,2,5,1],3))