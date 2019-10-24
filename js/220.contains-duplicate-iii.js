/*
 * @lc app=leetcode id=220 lang=javascript
 *
 * [220] Contains Duplicate III
 */

/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} t
 * @return {boolean}
 */
var containsNearbyAlmostDuplicate1 = function(nums, k, t) {
  // 也就是下标的差距最大是K 数字的差距最大的是t
  let map = new Map()
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + k; j >= Math.max(i - k, 0); j--) {
      if (map.has(nums[j]) && j !== i) {
        if (Math.abs(nums[j] - nums[i]) <= t) {
          return true
        }
      }
    }
    map.set(nums[i], i)
  }
  return false
};

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} t
 * @return {boolean}
 */
var containsNearbyAlmostDuplicate = function(nums, k, t) {
  // 也就是下标的差距最大是K 数字的差距最大的是t
  // 绝对值的位置差是负数 是不可能的
  if (k < 1 || t < 0) return false
  // 以K个数为一个桶就行,每个桶是以t为分割
  let map = new Map()
  for (let i = 0; i < nums.length; i++) {
    nums[i] = nums[i]
    let bucket = t === 0 ? nums[i] : Math.floor(nums[i] / t)
    // 三种情况会直接返回true
    // 第一种是有一个数儿直接又落到了这个区间上 第三中分别落到了前一个和后一个区间上
    if (map.has(bucket) || 
      (map.has(bucket - 1) && Math.abs(nums[i] - map.get(bucket - 1)) <= t) ||
      (map.has(bucket + 1) && Math.abs(nums[i] - map.get(bucket + 1)) <= t)) {
        return true
    }
    // 只保留K个
    if (map.size >= k) map.delete(map.keys().next().value)
    map.set(bucket, nums[i])
  }
  return false
};
// @lc code=end

console.log(containsNearbyAlmostDuplicate([-3, 3], 2, 4))