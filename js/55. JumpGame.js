/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
  // 表示所有点都还没有被访问过
  let memo = Array(nums.length).fill(-1)
  return dp(nums, 0, memo)
};

/**
 * 超时
 * @param {number[]} nums 
 * @param {number} start 
 */
function recursion(nums, start) {
  if (start === nums.length - 1) return true
  let far = Math.min(start + nums[start], nums.length - 1)
  for (let j = far; j > start; j--) {
    if (recursion(nums, j)) return true
  }
  return false
}

/**
 * 自顶向下的动态规划 通过memo来优化
 * 其实际的想法就是 我一个点跳到下一个点 如果下一个点是无法到达的 我自己就无法达到 如果下一个点事可以达到的 那么我这个点就可以达到
 * 如果这个点还没有被访问过 就去试试能不能达到
 * 这个问题 其实就是 一个大问题 划分成几个小问题 就是
 * 当前这个点能不能到达最后一点 是取决于 下一个点能否到达最后一点的 所有 一个深度优先+memo 就组成了 从上向下的动态规划
 */
function dp(nums, start, memo) {
  if (start === nums.length - 1) {
    memo[start] = true
    return true
  }
  let far = Math.min(start + nums[start], nums.length - 1), flag = false
  for (let j = far; j > start; j--) {
    if (memo[j] === -1) {
      // 递归求解
      memo[j] = dp(nums, j, memo)
    }
    if (memo[j]) { 
      flag = true
      break
    }
  }
  memo[start] = flag
  return flag
}

console.log(canJump([2,3,1,1,4]))