/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  let result = [];
  recursion(nums, result, 0, []);
  return result;
};

function recursion(nums, result, start, temp) {
  result.push(JSON.parse(JSON.stringify(temp)));
  for (let i = start; i < nums.length; i++) {
    temp.push(nums[i])
    recursion(nums, result, i + 1, temp)
    temp.pop()
  }
}

console.log(subsets([1, 2, 3]))