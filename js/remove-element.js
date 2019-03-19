/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let i = 0;
    for (let index = 0; index < nums.length; index++) {
      if (nums[index] === val) {
        continue;
      }
      nums[i++] = nums[index];
    }
    return i;
};

console.log(removeElement([0,1,2,2,3,0,4,2], 2))