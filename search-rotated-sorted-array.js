function searchByDivision(begin, end, target, nums) {
  let mid = Math.floor((begin + end) / 2);
  if (begin === end) {
    return nums[begin] === target ? begin : -1
  }
  if (nums[mid] === target) {
    return mid;
  }
  if ((target < nums[begin] || (target >= nums[mid] && (nums[mid] > nums[begin] && nums[mid] < nums[end])))) {
    return searchByDivision(mid + 1, end, target, nums);
  }
  return searchByDivision(begin, mid - 1, target, nums);
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

console.log(search([1, 3], 2));
