/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  return 2 * [...(new Set(nums))].reduce((total, num) => {
    return total + num
  }) - nums.reduce((total, num) => {
    return total + num
  })
};

console.log(singleNumber([4,1,2,1,2]))