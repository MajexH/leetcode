/*
 * @lc app=leetcode id=137 lang=javascript
 *
 * [137] Single Number II
 */

/**
 * 实际上
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  let res = 0
  // 分别取统计每一位上的1的数量
  for (let i = 0; i < 32; i++) {
    // 这个地方是统计每个数儿的 在i 位上1的数量
    let count = 0
    for (let num of nums) {
      count += (num >> i) & 1
    }
    res |= (count % 3) << i
  }
  return res
}

// @lc code=start
/**
 * 实际上就是讲 nums 中的每个 num 看成一个32位的二进制
 * 然后要拉到每一个位上 不能被 3 整除的 余下的数儿 组合起来就是结果
 * 因此可以把这个 32 位看成一个不进位的 3进制 的假发
 * 如果一个位上一个数字出现三次 重新回到0 然后再继续
 * 
 * 因此 为了创造这个 状态机 需要两个变量来保存状态
 * 
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  let one = 0, two = 0
  for (let num of nums) {
//     注意观察 once 只有两种情况下转移后为 1 。
//  一种是 once=0, twice=0, x=1 ，另一种是 once=1, twice=0, x=0 。
// 其他所有情况下 once 都转移为 0 。这两种情况都满足 x^once=1 并且 twice=0 ，所以 once 的转移就是 once = (x^once) & (~twice) 。

// 同理，观察 twice 只有两种情况下转移后为 1 。一种是 once=1, twice=0, x=1 ，另一种是 once=0, twice=1, x=0 。
// 其他所有情况下 twice 都转移为 0 。这两种情况都满足 x^twice=1 并且 once^twice=1 ，所以 twice 的转移就是 twice = (x^twice) & (once^twice) 。但是！！！ once 已经抢先一步转移过了，所以值已经变掉了，一个解决方法就是用临时变量保存一下前一个状态的 once 值。另一个方法就是，
//这两种情况下，once 都会转移到 0 ，所以判断条件直接用转移后的 once=0 就行了，随后转移就是 twice = (x^twice) & (~once) 。

    one = (one ^ num) & ~two
    two = (two ^ num) & ~one
  }
  return one
};
// @lc code=end

