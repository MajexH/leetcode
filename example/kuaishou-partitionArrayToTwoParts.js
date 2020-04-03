/**
 * 给定一个数组 其中元素的范围是 0 - 2^32
 * 将该数组分成两部分 s1 s2
 * 要求 |s1.sum() - s2.sum()| 的值最小
 * @param {Number[]} nums 
 */
function partitionArrayToTwoPartsFormMinuDiff(nums) {
  // 这个就是需要寻找的target 也就是说 nums数组 需要找到一个最接近 sum / 2 的值
  let sum = nums.reduce((pre, cur) => pre + cur, 0) 
  let target = Math.floor(sum / 2)
  // dp[i][j] 表示前 i 个的和 为j
  let dp = Array(nums.length + 1)
  for (let i = 0; i <= nums.length; i++) {
    dp[i] = Array(target + 1).fill(false)
    dp[i][0] = true
  }
  for (let i = 1; i <= nums.length; i++) {
    for (let j = 0; j <= sum / 2; j++) {
      if (j >= nums[i - 1]) {
        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
      } else {
        dp[i][j] = dp[i - 1][j]
      }
    }
  }
  let res = null;
  for (let j = target; j >= 0; j--) {
    if (dp[nums.length][j]) {
      res = j
      break;
    } 
  }
  return sum - 2 * res
}

console.log(partitionArrayToTwoPartsFormMinuDiff([2,4,5,6,9]))