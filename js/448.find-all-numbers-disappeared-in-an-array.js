/*
 * @lc app=leetcode id=448 lang=javascript
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function(nums) {
  let remember = Array(nums.length + 1).fill(0)
  for (let item of nums) {
    remember[item] = 1
  }
  let res = []
  for (let i = 1; i <= nums.length; i++) {
    if (remember[i] === 0) res.push(i)
  }
  return res
};
// @lc code=end

console.log(findDisappearedNumbers([4,3,2,7,8,2,3,1]))