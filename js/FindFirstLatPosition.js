function leftSearch(nums, target) {
  let start = 0, end = nums.length - 1;
  while (start < end) {
    let mid = Math.floor((start + end) / 2);
    if (target > nums[mid]) {
      start = mid + 1;
    } else {
      end = mid;
    }
  }
  if (nums[end] === target) {
    return end;
  }
  return -1;
}

function rightSearch(nums, target) {
  let start = 0, end = nums.length - 1;
  while (start < end) {
    let mid = Math.floor((start + end + 1) / 2);
    if (target >= nums[mid]) {
      start = mid;
    } else {
      end = mid - 1;
    }
    console.log(start, end)
  }
  if (nums[start] === target)
    return start;
  return -1;
}

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  let left = leftSearch(nums, target)
  let right = rightSearch(nums, target)
  return [left, right]
};

console.log(searchRange([1], 1));