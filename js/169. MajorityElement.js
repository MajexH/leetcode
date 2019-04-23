/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  let map = new Map()
  let item = {
    max: nums[0],
    count: 1
  }
  map.set(nums[0], 1)
  for (let i = 1; i < nums.length; i++) {
    if (map.get(nums[i]) === undefined) {
      map.set(nums[i], 1)
    } else {
      map.set(nums[i], map.get(nums[i]) + 1)
      if (map.get(nums[i]) > item.count)
        item = {
          max: nums[i],
          count: map.get(nums[i])
        }
    }
  }
  return item.max
};

console.log(majorityElement([6, 5, 5]))