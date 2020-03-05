/*
 * @lc app=leetcode id=496 lang=javascript
 *
 * [496] Next Greater Element I
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var nextGreaterElement = function(nums1, nums2) {
  let map = new Map()
  let res = []
  for (let i = 0; i < nums2.length; i++) {
    map.set(nums2[i], i)
  }
  for (let num of nums1) {
    let flag = true
    for (let i = map.get(num) + 1; i < nums2.length; i++) {
      if (nums2[i] > num) {
        res.push(nums2[i])
        flag = false
        break;
      }
    }
    if (flag) res.push(-1)
  }
  return res
};
// @lc code=end

console.log(nextGreaterElement(nums1 = [4,1,2], nums2 = [1,3,4,2]))