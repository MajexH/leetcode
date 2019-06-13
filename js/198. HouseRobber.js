/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  let memo = Array(nums.length).fill(-1)
  return recursion(nums, 0, memo)
};

function recursion (nums, index, memo) {
  if (index >= nums.length)
    return 0
  if (memo[index] !== -1) {
    // 因为memo的构建是从下向上的 也就是每次都是去用memo里面剩下的最大的
    // 但是也是因为memo是从下往上构建的 这样保障每次构建的 都会是在index 和 index + 1两个位置
    // 讨论两个位置的大小即可
    return Math.max(memo[index], memo[index + 1])
  }
  if (index === nums.length - 1) {
    memo[index] = nums[index]
    return memo[index]
  }
  if (index === nums.length - 2) {
    memo[index] = nums[index]
    memo[index + 1] = nums[index + 1]
    return Math.max(memo[index], memo[index + 1])
  }
  
  memo[index] = nums[index] + recursion(nums, index + 2, memo)
  memo[index + 1] = nums[index + 1] + recursion(nums, index + 3, memo)
  return Math.max(memo[index], memo[index + 1])
}
console.log(rob([6,3,10,8,2,10,3,5,10,5,3]))