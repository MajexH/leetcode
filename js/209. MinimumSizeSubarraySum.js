/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen1 = function(s, nums) {
  // left 保存连续数组的起始位置
  let sum = 0, left = 0, length = Number.MAX_SAFE_INTEGER
  for (let i = 0; i < nums.length; i++) {
    sum += nums[i]
    while (sum >= s) {
      length = Math.min(length, i - left + 1)
      sum -= nums[left++]
    }
  }
  return length === Number.MAX_SAFE_INTEGER ? 0 : length
};

/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(s, nums) {
  let n = nums.length, sum = Array(n).fill(0), res = Number.MAX_SAFE_INTEGER
  sum[0] = nums[0]
  for (let i = 1; i < n; i++) {
    sum[i] += sum[i - 1] + nums[i]
  }
  for (let i = 0; i < n; i++) {
    let end = binarySearch(sum, s + sum[i] - nums[i], 0, n - 1)
    if (end < i || sum[end] - sum[i] + nums[i] < s) continue
    res = Math.min(res, end - i + 1)
  }
  return res === Number.MAX_SAFE_INTEGER ? 0 : res
};

function binarySearch(nums, target, start, end) {
  while (start < end) {
    let mid = Math.floor((start + end) / 2)
    if (nums[mid] >= target) {
      end = mid
    } else {
      start = mid + 1
    }
  }
  return end
}

console.log(minSubArrayLen(4, [1, 4, 4]))