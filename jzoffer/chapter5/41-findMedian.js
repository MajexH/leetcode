const Heap = require('../../data-structure/heap');
/**
 * 为了找到一个乱序输入的array的中位数
 * 而中位数 其实就是中间的数儿 或者 中间的两个数儿的和 / 2
 * 将整体冲中间分开 则中位数 要么是左边的最大的数儿 和 右边最小的数儿 / 2 或者是其中之一
 * 将array分为两个部分 第一个部分是第一个大顶堆 第二部个部分是一个小顶堆
 * 这样 第一个部分的头 和第二个部分的头就是整个数组的中间位置
 * @param {Array} array 
 */
function findMedian(array) {
  // 大顶堆
  let left = new Heap(Number.MAX_SAFE_INTEGER, (a, b) => a - b)
  // 小顶堆
  let right = new Heap(Number.MAX_SAFE_INTEGER, (a, b) => b - a)
  
  for (let i = 0; i < array.length; i++) {
    if (i % 2 === 0) {
      // 插入左边的时候 可能插入的数 比right的某些大 需要插在右边
      // 这是可以把右边的最小的拿出来插入左边
      if (array[i] >= right.top()) {
        let top = right.pop()
        left.add(top)
        right.add(array[i])
      } else {
        left.add(array[i])
      }
    } else {
      // 插入的right 可能比left的某些小 需要插在左边
      // 此时把左边的最大的并入右边即可
      if (array[i] <= left.top()) {
        let top = left.pop()
        left.add(array[i])
        right.add(top)
      } else {
        right.add(array[i])
      }
    }
  }
  console.log(left, right)
  // 奇数
  if (array.length % 2 !== 0) {
    // 因为奇数是插在左边的 因此返回左边
    return left.top()
  } else {
    return Math.floor((left.top() + right.top()) / 2)
  }

}

console.log(findMedian([6,3,4,1,2,5]))