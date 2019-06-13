/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  // 因为最后一个跟第一个相连  也就是 选了最后一个 就不能有第一个
  // 因此把他分为两份 第一个数组从0 ~ length - 2 第二个数组从1 ~ length - 1 
  if (nums.length === 1) return nums[0]
  let memo1 = Array(nums.length).fill(-1), memo2 = Array(nums.length).fill(-1)
  let array1 = nums.slice(0, nums.length - 1), array2 = nums.slice(1, nums.length)
  return Math.max(recursion(array1, 0, memo1), recursion(array2, 0, memo2))
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

console.log(rob([1]))