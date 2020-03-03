/**
 * 一个数组中 除了两个数字之外 其他的都出现了两次
 * 因此 可以根据once这个结果 将数组分为两部分 最后这两部分
 * 分开的标准就是 根据 一个位数 是否
 * @param {Array} array 
 */
function findNumberAppearanceTwo(array) {
  let once = 0
  // 因为有两个数字 不同 因此 最后出来的once的结果 一定有一位是1
  // 根据这位的结果 将arra分成两部分 分别求 最后就可以得到 这两个数
  for (let item of array) {
    once ^= item
  }
  let index = 0
  while (once > 0) {
    if (once & 1 === 1) {
      break
    } 
    index++
    once >>>= 1
  }
  let temp1 = 0, temp2 = 0
  // 这个时候index表示 这个数中最开始哪一位是1
  for (let item of array) {
    if (((item >> index) & 1) === 1) {
      temp1 ^= item
    } else {
      temp2 ^= item
    }
  }
  return [temp1, temp2]
}

/**
 * 一个数组中 除了1个数字之外 其他的都出现了两次
 * 
 * @param {Array} array 
 */
function findNumberAppearanceOne(array) {
  // 因为 1 ^ 1 = 0 而 0 ^ 1 = 1
  let res = 0
  for (let item of array) {
    res ^= item
  }
  return res
}

console.log(findNumberAppearanceOne([1,1,2,1,1,1,1]))

console.log(findNumberAppearanceTwo([1,2,5,2]))