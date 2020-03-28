/**
 * 给定一个数组 其中 只有一个数 出现了一次 另外的数 出现三次
 * 第二种方式
 * 定义一个特殊的3进制 不进位加法
 * 因为如果 这个数组 是所有的数字 出现两次 而只有一个出现一次
 * 那么异或就可以 异或 就是一个特殊的 二进制 加法 并且不进位
 * 而从array中的 number 上看 将其看成 二进制
 * 因为一个出现3次 一个出现1次 也就是说 如果出现三次 则需要归零 
 * 因此 对于每个数的 的每一位二进制数 需要有两个数来保持它的状态
 * @param {Number[]} array 
 */
function anotherFindAppearOnceWioutExtraSpace(array) {
  // 保存每一位的状态 完成一个不进位的 3 进制加法
  let once = 0, twice = 0
  for (let num of array) {
    once = (once ^ num) & ~twice  
    twice = (twice ^ num) & ~once
  }
  return once
}

/**
 * 给定一个数组 其中 只有一个数 出现了一次 另外的数 出现三次
 * 第一种方式
 * 从数的二进制的角度看 如果一个数儿出现三次 那么其在某一位上时 二进制的
 * 表示中 1 的个数 肯定是3的倍数 如果出现一次 肯定不是
 * @param {Number[]} array 
 */
function findAppearOnceWioutExtraSpace(array) {
  let res = 0
  for (let i = 31; i >= 0; i--) {
    let index = 0
    for (let num of array) {
      if (((num >>> i) & 1) === 1) index++
    }
    res = (res << 1) + (index % 3)

  }
  return res
}

console.log(findAppearOnceWioutExtraSpace([1,1,1,2,2,2,3,3,3,100]))