/**
 * 因为这个要平分成相等的两份 又是整数 所以 nums 的合一定是偶数
 * 递归会超时 其实 递归 就是建立了一个 二叉树 遍历所有结果
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition1 = function(nums) {
  let sum = nums.reduce((pre, cur) => pre + cur, 0)
  if (sum % 2 !== 0) return false
  return recursion(sum / 2, nums, 0)
};

/**
 * 一个index上的数 可以有取和不取两种状态
 * @param {number} target 
 * @param {number[]} nums 
 * @param {number} index 
 */
function recursion(target, nums, index) {
  if (target === 0) return true
  if (index >= nums.length) return false
  if (nums[index] > target) return false
  return recursion(target - nums[index], nums, index + 1) || recursion(target, nums, index + 1)
}

/**
 * 因为这个要平分成相等的两份 又是整数 所以 nums 的合一定是偶数
 * dp[i][j] 表示 前i个数和为j 可不可以
 * 状态转移方程为 dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {
  let sum = nums.reduce((pre, cur) => pre + cur, 0)
  if (sum % 2 !== 0) return false
  let dp = Array(nums.length + 1)
  for (let i = 0; i <= nums.length; i++) {
    dp[i] = Array(sum / 2 + 1).fill(false)
  }
  // 初始化 sum为0的时候 所有的都行
  for (let i = 0; i <= nums.length; i++) {
    dp[i][0] = true
  }
  for (let i = 1; i <= nums.length; i++) {
    for (let j = sum / 2; j >= 0; j--) {
      if (j >= nums[i]) dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]
      else dp[i][j] = dp[i - 1][j]
    }
  }
  return dp[nums.length][sum / 2]
};

console.log(canPartition([5, 2, 1, 4]))
