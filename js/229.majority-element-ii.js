/*
 * @lc app=leetcode id=229 lang=javascript
 *
 * [229] Majority Element II
 */

// @lc code=start
/**
 * 在o(n)时间和o(1)空间上完成是boyer-moore算法
 * 这个算法的思想是找到一个数组中的最多的数 这个最多的数 
 * 可以通过 数组中 不同的数 两两相抵消
 * 最后一定会剩下这个最多的数儿
 * 
 * 而在本题中 为了满足 n / 3的数量的数儿 
 * 只会在数组中有三种可能 0个数儿 1个数儿 2个数儿
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
  let num1 = nums[0], counter1 = 0
  let num2 = nums[0], counter2 = 0
  // 第一个循环去寻找数儿 找到出现次数最多的两个数儿
  for (let item of nums) {
    if (item === num1) {
      counter1++
    } else if (item === num2) {
      counter2++
    }
    // 如果现在记录的两个数 有一个还未初始化
    else if (counter1 === 0) {
      num1 = item
      counter1 = 1
    } else if (counter2 === 0) {
      num2 = item
      counter2 = 1
    }
    // 抵消最多的数
    else {
      counter1--
      counter2--
    }
  }
  counter1 = 0
  counter2 = 0
  // 第二个循环验证这两个数 是否满足 n / 3的条件
  for (let item of nums) {
    if (item === num1) counter1++
    if (item === num2) counter2++
  }
  let res = []
  if (counter1 > Math.floor(nums.length / 3)) res.push(num1)
  if (num1 !== num2 && counter2 > Math.floor(nums.length / 3))
    res.push(num2)
  return res
};
// @lc code=end

con