/**
 * 给定一个递增的数列 长度为n-1
 * 其中的数字范围为 0-n
 * 并且每个数字不重复 
 * 因此 会少一个0-n的数字 没有出现在数字中 找到这个数字
 * 其实就是找到第一个下标和其值不等的数儿
 * @param {number[]} array 
 */
function findMissingNumber(array) {
  // 这个解法忽略了n不存在的时候
  let i = 0, j = array.length - 1
  while (i < j - 1) {
    let mid = Math.floor((i + j) / 2)
    if (array[mid] === mid) {
    // 说明 缺的在右边
      i = mid + 1
    } else {
      j = mid
    }
  }
  if (array[i] !== i) return i
  else if (j !== array[j]) return j
  // 处理最后一个数儿不存在的情况
  else return j + 1
}

/**
 * 事例解法 跟上面那个不同的是这个里面的判断部分 不一样
 * @param {number[]} array 
 */
function findMissingNumberDemo(array) {
  let start = 0, end = array.length - 1
  while (start <= end) {
    let mid = Math.floor((start + end) / 2)
    if (array[mid] === mid) {
    // 说明在右边
      start = mid + 1
    } else {
    // 说明这个时候这个 丢失的数字在左边
      // 这个地方分两种情况是 因为
      // 可能找到的这个中间数就已经是第一个下标不同的数儿了
      // 这个时候知道知道它前面一个数就可以知道它是不是下标不对的数儿
      if (mid === 0 || array[mid - 1] === mid - 1)
        return mid
      else
        end = mid - 1
    }
  }

  if (start === array.length)
    return array.length
  return -1
}

console.log(findMissingNumber([0,1,2,3,4]))
console.log(findMissingNumberDemo([0,1,2,3,4]))