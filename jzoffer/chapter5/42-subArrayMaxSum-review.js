/**
 * 找到一个数组下面的连续子数组的最大值
 * @param {Number[]} nums 
 */
function maxSubArraySum(nums) {
  // dp[i] 表示以 nums[i] 结尾的最大子数组和
  let dp = Array(nums.length).fill(0), max = Number.MIN_SAFE_INTEGER
  for (let i = 0; i < nums.length; i++) {
    // 如果之前的和小于0 那么 nums[i] + dp[i - 1] < nums[i] 所以 需要划分 重新开始计算子数组
    // 因为从nums[i] 开始的子数组 一定比之前划分的大
    if (i === 0 || dp[i - 1] < 0) {
      dp[i] = nums[i]
    } else {
      dp[i] = nums[i] + dp[i - 1]
    }
    max = Math.max(max, dp[i])
  }
  return max
}

console.log(maxSubArraySum([1,-2,3,10,-4,7,2,-5]))