/*
 * @lc app=leetcode id=213 lang=javascript
 *
 * [213] House Robber II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  if (nums.length === 0) return 0
  if (nums.length === 1) return nums[0]
  // 选择 0 号房间 rob 其最多只能拿到 倒数第二个
  // 也就是 0 号房间拿 那么最后一个肯定不拿 同时 第一个1 房间不拿
  let firstStart = nums[0] + getRes(nums, 2, nums.length - 2)
  // 选择 1 号房间 rob 其最多只能拿到 倒数第1个
  // 0号房间不拿
  let secondStart = getRes(nums, 1, nums.length - 1)
  return Math.max(firstStart, secondStart)
};

function getRes(nums, start, end) {
  if (start > end) return 0
  let taken = nums[start], notTaken = 0
  for (let i = start + 1; i <= end; i++) {
    let rememberTaken = taken
    taken = notTaken + nums[i]
    notTaken = Math.max(rememberTaken, notTaken)
  }
  return Math.max(taken, notTaken)
}
// @lc code=end

