/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
  let set1 = new Set(nums1), set2 = new Set(nums2), res = []
  for (let item of set1) {
    if (set2.has(item)) res.push(item)
  }
  return res
};