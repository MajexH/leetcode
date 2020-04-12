/**
 * 给定一个等差数列 找到其最长等差数列 无所谓其顺序
 * 也就是说 跳着 也是可以的
 * @param {Number[]} nums 
 */
function getLongestProgression(nums) {
  nums.sort()
  // 保存数字的最大间隔 也就是 等差数列的 差 是多少
  let maxDiff = nums[nums.length - 1] - nums[0]
  // dp[i][j] 表示 nums[i] 结尾的 等差 为 j 的等差数列的长度为多少
  let dp = Array(nums.length)
  for (let i = 0; i < nums.length; i++) {
    // fill 1 是因为 最短的长度 都是自己形成一个等差数列 就是1
    dp[i] = Array(maxDiff + 1).fill(1)
  }
  let res = 0
  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < i; j++) {
      // 去跟自己的所有子串比较
      dp[i][nums[i] - nums[j]] = dp[j][nums[i] - nums[j]] + 1
      res = Math.max(res, dp[i][nums[i] - nums[j]])
    }
  }
  console.log(dp)
  return res
}

console.log(getLongestProgression([1,4,2,5,3]))