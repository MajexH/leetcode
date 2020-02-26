/*
 * @lc app=leetcode id=300 lang=javascript
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
  if (nums.length === 0) return 0
  // dp[i] 表示 以 i结尾的时候 其最长的序列是多少
  let dp = Array(nums.length).fill(0)
  dp[0] = 1
  // 因为只有一个的时候 只需要取第一个数即可
  let max = dp[0]
  for (let i = 1; i < nums.length; i++) {
    let temp = 0
    for (let j = 0; j < i; j++) {
      // 意味着可以加入最长的序列
      // 这个时候要选择前面一段的最长的加入
      if (nums[j] < nums[i]) {
        temp = Math.max(temp, dp[j])
      }
    }
    // 加1是因为这个时候 还要算上i这个数
    dp[i] = temp + 1
    max = Math.max(dp[i], max)
  }
  return max
};
// @lc code=end

/**
 * 如果返回所有的结果 会爆堆
 * 因此 直接返回数字结果算了
 * @param {number[]} nums 
 * @param {number} index 
 * @param {number} preIndex 
 * @param {number[][]} memo 
 */
function recursionWithMemo(nums, index, preIndex, memo) {
  if (index === nums.length) {
    memo[index][preIndex + 1] = 0
    return 0
  }
  if (memo[index][preIndex + 1] !== -1) return memo[index][preIndex + 1]
  let one = null, second
  // 有两种可能 分别代表
  if (preIndex === - 1 || nums[index] > nums[preIndex]) {
    one = 1 + recursionWithMemo(nums, index + 1, index, memo)
  }
  second = recursionWithMemo(nums, index + 1, preIndex, memo)
  if (one && one > second) {
    second = one
  }
  memo[index][preIndex + 1] = second
  return second
}

function recursion(nums, index, low) {
  if (index === nums.length) {
    let temp = []
    if (nums[index] > low) {
      temp.push(nums[index])
    }
    return temp
  }
  let one = null, second
  // 有两种可能 分别代表
  if (nums[index] > low) {
    one = [nums[index], ...recursion(nums, index + 1, nums[index])]
  }
  second = recursion(nums, index + 1, low)
  if (one && one.length > second.length) {
    second = one
  }
  return second
}

console.log(lengthOfLIS([10,9,2,5,3,7,101,18]))