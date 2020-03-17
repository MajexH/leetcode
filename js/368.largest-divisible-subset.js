/*
 * @lc app=leetcode id=368 lang=javascript
 *
 * [368] Largest Divisible Subset
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var largestDivisibleSubset1 = function(nums) {
  if (nums.length === 0) return nums
  nums.sort((a, b) => a - b)
  let res = [], counter = 1
  for (let item of nums) {
    res.push([item])
  }
  let result = []
  // 构建两个的
  // for (let i = 0; i < nums.length; i++) {
  //   for (let j = i; j < nums.length; j++) {
  //     if (nums[i] % nums[j] === 0 || nums[j] % nums[i] === 0) {
  //       if (i === j) 
  //         res.push(nums[])
  //       res.push([nums[i], nums[j]])
  //     }
  //   }
  // }
  let set = new Set(nums)
  // 根据两个的 构建多个的
  let flag = true
  while (flag) {
    // 表示新加了数没有
    let temp = false
    // 根据现有的的再去加数
    for (let array of [...res]) {
      for (let num of set.keys()) {
        // 当前的数不在array中
        if (array.findIndex((val) => val === num) === -1) {
          let addFlag = true
          for (let item of array) {
            if (item % num !== 0 && num % item !== 0) {
              addFlag = false
              break
            }
          }
          if (addFlag) {
            temp = true
            array.push(num)
            if (counter === array.length) {
              res.push(array)
            } else {
              res = [array]
              counter = array.length
            }
          }
          if (result.length === 0 || result.length < array.length) result = array
        }
      }

    }
    if (!temp) flag = false
  }
  // 如果长度为0 说明没加过
  return result.length === 0 ? res[0] : result
};

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var largestDivisibleSubset = function(nums) {
  if (nums.length === 0) return nums
  nums.sort((a, b) => a - b)
  // dp[i] 表示以 nums[i] 结尾的序列的最大长度
  // last 表示 以nums[i] 结尾的序列的上一个数字的下标
  let dp = Array(nums.length).fill(1), last = Array(nums.length).fill(-1)
  let max = Number.MIN_SAFE_INTEGER, end = -1
  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < i; j++) {
      // [2,4,8] 如果来 一个nums[i] = 16
      // 因为是排序的 所以后来的一个一定比前一个大 如果之前的已经形成了一个 数组
      // 那么下一个如果是已经形成的数组最后一个的倍数 也就是之前的所有的数的倍数
      // 有等于的原因是为了保证 能到达到最大
      if (nums[i] % nums[j] === 0 && dp[j] >= dp[i]) {
        dp[i] = dp[j] + 1
        // 如果只有的没有比dp[i]更大的 就不会更新
        last[i] = j
      }
    }
    // 寻找最大值
    if (max < dp[i]) {
      max = dp[i]
      // 记录最大数组的最后一个数的位置
      end = i
    }
  }
  let res = []
  for (let i = end; i !== - 1; i = last[i]) {
    res.push(nums[i])
  }
  console.log(dp)
  console.log(last)
  return res
};
// @lc code=end

console.log(largestDivisibleSubset([1,2,4,8]))