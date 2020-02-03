/*
 * @lc app=leetcode id=260 lang=javascript
 *
 * [260] Single Number III
 */
// 非线性空间版本
var singleNumber1 = function(nums) {
  let map = new Map()
  for (let i of nums) {
    if (map.has(i)) {
      map.set(i, 2)
    } else {
      map.set(i, 1)
    }
  }
  let res = []
  for (let key of map.keys()) {
    if (map.get(key) === 1) {
      res.push(key)
    }
  }
  return res
};

// @lc code=start
/**
 * 线性空间版本
 * @param {number[]} nums
 * @return {number[]}
 */
var singleNumber = function(nums) {
  // 因为不同的数字只有两个 而 相同的数字异或为0
  // 因此第一遍异或 可以得到两个相同的数字的异或的结果
  let diff = 0
  for (let item of nums) {
    diff ^= item
  }
  // 找到diff的二进制中不同的数
  diff &= -diff
  // 第二遍异或就是为了得到数
  // 因此两个distinct的数是不同的 因此 diff中至少有一位二进制不同 
  // 找到这个二进制数 根据这些二进制位置上的数的不同 
  // 把nums里面的数分为两组 分别异或 就可以得到 最后的值了
  let res = [0, 0]
  for (let item of nums) {
    if ((diff & item) === 0) {
      res[0] ^= item
    } else {
      res[1] ^= item
    }
  }
  return res
};
// @lc code=end

