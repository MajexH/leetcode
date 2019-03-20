/**
 * 
 * @param {number[]} nums 
 * @param {number} target 
 */
function binarySearch(nums, target) {
  let head = 0, tail = nums.length - 1;
  while (head <= tail) {
    let mid = Math.floor((head + tail) / 2);
    if (nums[mid] === target) {
      return mid;
    }
    if (nums[mid] > target) {
      tail = mid - 1;
    } else {
      head = mid + 1;
    }
  }
  return head;
}

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
  return binarySearch(nums, target);
};


console.log(searchInsert([1,3,5,6], 7))