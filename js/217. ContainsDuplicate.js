/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
  let set = new Set()
  nums.forEach((val) => { set.add(val) })
  return !(set.size === nums.length)
};

console.log(containsDuplicate([]))