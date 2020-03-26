/*
 * @lc app=leetcode id=78 lang=javascript
 *
 * [78] Subsets
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  let res = recursion(nums, 0)
  res.push([])
  return res
};

function recursion(nums, index) {
  if (index >= nums.length) {
    return []
  }
  let temp = []
  for (let tempArray of recursion(nums, index + 1)) {
    temp.push([nums[index], ...tempArray])
    temp.push(tempArray)
  }
  temp.push([nums[index]])
  return temp
}
// @lc code=end

console.log(subsets([1,2,3]))