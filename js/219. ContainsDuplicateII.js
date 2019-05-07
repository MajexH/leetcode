/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate1 = function(nums, k) {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j <= i + k; j++) {
      if (j > nums.length - 1) break
      if (nums[j] === nums[i])
        return true
    }
  }
  return false
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
  // 可以用hashmap来保存访问过的数和索引
  let map = new Map()
  for (let i = 0; i < nums.length; i++) {
    if (map.has(nums[i])) {
      let j = map.get(nums[i])
      if (i - j <= k)
        return true
    }
    map.set(nums[i], i)
  }
  return false
};

console.log(containsNearbyDuplicate([99, 99], 1))