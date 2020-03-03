/**
 * 给定一个数组 其中有一个数字 只出现了一次 其它的出现了3次
 * @param {number[]} array 
 */
function findAppearOnce(array) {
  return (3 * [...new Set(array).keys()].reduce((pre, cur) => pre + cur) - array.reduce((pre, cur) => pre + cur)) / 2
}

/**
 * 给定一个数组 其中有一个数字 只出现了一次 其它的出现了3次
 * 因为其它的出现了三次 也就是说 如果 按位数来看 
 * 如果这个数字在某一位出现1 1次 那么这个地方的1 是（1 + 3n）次 n从0开始 因为有其他的3个数来组成
 * @param {number[]} array 
 */
function findAppearOnceWioutExtraSpace(array) {
  let num = Array(32).fill(0)
  for (let item of array) {
    for (let i = 0; i < 32; i++) {
      if (item & 1 === 1) {
        num[i] += 1
      }
      item >>>= 1
    }
  }
  let res = 0
  for (let i = 31; i >= 0; i--) {
    res <<= 1
    res += num[i] % 3
  }
  return res
}

console.log(findAppearOnce([1,1,1,2,2,2,3]))
console.log(findAppearOnceWioutExtraSpace([1,1,1,2,2,2,3]))