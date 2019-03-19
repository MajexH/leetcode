function searchLeft(nums, begin, last, target) {
  while (begin < last) {
    let mid = Math.floor((begin + last) / 2);
    if (target <= nums[mid]) {
      last = mid;
    } else {
      begin = mid + 1;
    }
  }
  if (nums[begin] === target) {
    return begin
  }
  return -1;
}

function searchRight(nums, begin, last, target) {
  while (begin < last) {   
    let mid = Math.floor((begin + last) / 2);
    if (target >= nums[mid]) {
      begin = mid + 1;
    } else {
      last = mid;
    }
  }
  if (nums[last] === target) {
    return last
  }
  return -1;
}

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  let left = searchLeft(nums, 0, nums.length - 1, target);
  let right = searchRight(nums, 0, nums.length - 1, target);
  return [left, right]
};

console.log(searchRange([1, 1, 1, 1, 2], 1))