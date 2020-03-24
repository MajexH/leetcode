/*
 * @lc app=leetcode id=377 lang=javascript
 *
 * [377] Combination Sum IV
 */
/**
 * 不用备忘录 会直接 超时 
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4WithRecurison = function(nums, target) {
  return recursion(nums, target, new Map())
};

function recursion(nums, target, memo) {
  if (target < 0) return 0
  if (target === 0) {
    return 1
  }
  if (memo.has(target)) return memo.get(target)
  let res = 0
  for (let i = 0; i < nums.length; i++) {
    res += recursion(nums, target - nums[i], memo)
  }
  memo.set(target, res)
  return res
}
// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(nums, target) {
  // dp[i] 表示 target 为时的 结果
  let dp = Array(target + 1).fill(0);
  // target 为0 的时候 选择0个
  dp[0] = 1
  for (let i = 1; i <= target; i++) {
    for (let j = 0; j < nums.length; j++) {
      if (i - nums[j] >= 0)
        dp[i] += dp[i - nums[j]]
    }
  }
  return dp[target]
};

// @lc code=end
console.log(combinationSum4WithRecurison([2,1,3], 34))
console.log(combinationSum4([2,1,3], 34))