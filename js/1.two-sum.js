/*
 * @lc app=leetcode id=1 lang=javascript
 *
 * [1] Two Sum
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
  let map = new Map()
  for (let i = 0; i < nums.length; i++) {
    if (!map.has(nums[i])) {
      map.set(nums[i], [i])
    } else {
      map.set(nums[i], [...map.get(nums[i]), i])
    }
  }
  for (let item of map.keys()) {
    // 如果取到了同一个数
    if (target - item === item && map.get(item).length === 1) continue
    //  如果两个数相同 但是有多个index 返回前两个
    if (target - item === item) {
      return map.get(item).slice(0, 2)
    }
    else if (map.has(target - item)) {
      console.log(1)
      return [map.get(item), map.get(target - item)]
    }
  }
};
// @lc code=end

console.log(twoSum([3,3], 6))