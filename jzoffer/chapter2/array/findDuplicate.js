/**
 * 一个长度为n的数组array
 * 包含了一组[0 -> n-1]的数
 * 找到第一个重复的数字
 * o(n)的时间复杂度 o(1)的空间复杂度
 * 因为长度为n且只包含有0 -> n-1的数
 * 因此 一个下标为i的位置 一定能放到一个i的数
 * 从头向后扫描即可 将数放到它在的位置
 * @param {Array} array 
 * @param {Number} n
 */
function findDuplicate(array, n) {
  // 检查数组满足要求
  for (let i = 0; i < n; i++) {
    if (array[i] >= n) return false
  }
  for (let i = 0; i < n; i++) {
    while (array[i] !== i) {
      // 找到了重复
      if (array[array[i]] === array[i]) {
        console.log(array[i])
        return true
      }
      let temp = array[array[i]]
      array[array[i]] = array[i]
      array[i] = temp
    }
  }
}

console.log(findDuplicate([2, 3, 1, 0, 2, 5, 3], 7))


/**
 * 一个数组包含了长度为n+1,其中的数字从[1 - n]
 * 因此其中一定有重复的数字 找到重复的数字
 * 解法：选择一个中间的数 统计从start到mid里面包含的数的多少，如果比中的数大 说明 从start到mid中间有重复数字
 * 因此重复以上过程 就可以找到重复的数字
 * @param {Array} array 
 * @param {Number} n
 */
function findDuplicatWithoutChangeTheArray(array, n) {
  let start = 1, end = n
  while (start <= end) {
    let mid = Math.floor((start + end) / 2)
    let counter = getCount(array, start, mid)
    if (start === end) {
      // 如果此时已经到了最后一个数
      // 判断其是否重复
      if (counter > 1) return start
      else return -1
    }
    if (counter > mid - start + 1) {
      end = mid
    } else {
    // else说明在右边的数组的范围内 因为现在左边的已经检查完了 只可能在右边的有
      start = mid + 1
    }
  }
  return -1
}

/**
 * 统计array中在start到end之间的数
 * @param {Array} array
 * @param {*} start 
 * @param {*} end 
 */
function getCount(array, start, end) {
  let counter = 0
  for (let item of array) {
    if (item >= start && item <= end) {
      counter++
    }
  }
  return counter
}

console.log(findDuplicatWithoutChangeTheArray([2, 3, 5, 4, 3, 2, 6, 7], 7))