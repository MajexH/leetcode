function searchByDivision(begin, end, target, nums) {
  let mid = Math.floor((begin + end) / 2);
  if (begin === end) {
    return nums[begin] === target ? begin : -1
  }
  if (nums[mid] === target) {
    return mid;
  }
  if (nums[mid] >= nums[begin]) {
    if (target >= nums[begin] && target < nums[mid])
      // 执行二分查找
      return searchByDivision(begin, mid - 1, target, nums);
    else 
      return searchByDivision(mid + 1, end, target, nums)
  } else {
    if (target > nums[mid] && target <= nums[end])
      // 执行二分查找
      return searchByDivision(mid + 1, end, target, nums);
    else 
      return searchByDivision(begin, mid - 1, target, nums)
  }
}
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  if (nums === null || nums.length === 0)
    return -1;
  return searchByDivision(0, nums.length - 1, target, nums);
};

console.log(search([4], 4));
