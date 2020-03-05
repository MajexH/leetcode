/**
 * 找到所有的 以windows size为大小的滑动窗口中的 最大的数字
 * @param {number[]} array
 * @param {number} windowSize
 */
function findAllMaxValueInWindow(array, windowSize) {
  let res = [], dequeue = []
  // 初始化的 第一个窗口期的 最大值数组
  for (let i = 0; i < windowSize; i++) {
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