/**
 * 一个数组中 除了两个数 之外 其它的数字都出现了两次
 * 找到这两个数
 * @param {Number[]} nums 
 */
function findNumberAppearance(nums) {
  // 相同的数 异或 为0 因此 这个结果是两个不同的数的异或结果
  let divideParam = 0
  for (let num of nums) {
    divideParam ^= num
  }
  // 两个不同的数儿 肯定在某一位上异或的结果为1 找到这个1的位置 
  // 因为是异或的结果为1 因此 这两个 不同的数 在这一位上的 两个2进制的数是不同的
  let rightMostOneIndex = 0
  while (divideParam !== 0) {
    if (divideParam & 1 === 1) {
      break
    }
    rightMostOneIndex++
    divideParam >>>= 1
  }
  // 因此根据这个 rightMostOneIndex 这1位是否为1 来划分数组
  let res1 = 0, res2 = 0
  for (let num of nums) {
    if (((num >> rightMostOneIndex) & 1) === 1) {
      res1 ^= num
    } else {
      res2 ^= num
    }
  }
  return [res1, res2]
}

console.log(findNumberAppearance([1,2,5,2]))
