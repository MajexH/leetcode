/**
 * 加上两个数字 不使用加减乘除
 * @param {number} num1 
 * @param {number} num2 
 */
function addTwoNumber(num1, num2) {
  let sum = 0, add
  // 分为三步走
  // 第一步 算各位的和 不计进位
  // 第二步 加上进位
  // 第三步 如果这时候没有进位了 因为着没有两位上存在相同的1 
  // 也就是说 在第一步按位异或的时候 得到的就是最后的值
  do {
    // 第一步在进位为0的时候 表示不存在一位上存在两个相同的1 
    // 这个时候 按位异或出来的就是 结果 因为相当于 把 10 合并成1 00 合并成0
    sum = num1 ^ num2
    // 第二步就是算出进位 因为按位与 就可以得出 一个位上同时为1的地方 然后再向左移动一位就代表进位
    add = (num1 & num2) << 1
    num1 = sum
    num2 = add
  } while (num2 !== 0)
  return num1
}

console.log(addTwoNumber(1,2))