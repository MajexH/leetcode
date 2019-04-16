/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
  let start = 0, end = nums.length - 1;
  while (start < end) {
    let mid = Math.floor((start + end) / 2)
    if (mid % 2 === 1)
      mid--;
    // 说明在左边
    if (nums[mid] !== nums[mid + 1])
      end = mid
    else 
      start = mid + 2
  }
  return nums[start]
};

console.log(singleNonDuplicate([1,1,2,3,3,4,4,8,8]))
