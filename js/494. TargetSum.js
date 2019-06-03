/**
 * @param {number[]} nums
 * @param {number} S
 * @return {number}
 */
var findTargetSumWays = function(nums, S) {
  let memo = []
  for (let i = 0; i < nums.length; i++) {
    // 因为题目中他说最大 最小 都不超过1000
    memo[i] = Array(2001).fill(Number.MIN_SAFE_INTEGER)
  }
  return recursion(nums, S, 0, 0, memo)
};

function recursion (nums, target, index, current, memo) {
  if (index < nums.length) {
    if (memo[index][current + 1000] !== Number.MIN_SAFE_INTEGER) {
      return memo[index][current + 1000]
    }
    let add = recursion(nums, target, index + 1, current + nums[index], memo)
    let sub = recursion(nums, target, index + 1, current - nums[index], memo)
    memo[index][current + 1000] = add + sub
    return memo[index][current + 1000]
  }
  else if (nums.length === index && target === current) {
    return 1
  }
  else return 0
}

console.log(findTargetSumWays([1, 1, 1, 1, 1], 3))