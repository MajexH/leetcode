/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
  let res = []
  nums = nums.sort((a, b) => { return a - b });
  recursion(nums, res, 0, [])
  return res
};

function recursion(nums, res, start, temp) {
  res.push(JSON.parse(JSON.stringify(temp)))
  for (let i = start; i < nums.length; i++) {
    if (canGenerate(nums, start, i)) {
      temp.push(nums[i])
      recursion(nums, res, i + 1, temp)
      temp.pop()
    }
  }
}

function canGenerate(nums, start, end) {
  for (let i = start; i <= end - 1; i++) {
    if (nums[end] === nums[i])
      return false
  }
  return true
}

console.log(subsetsWithDup([4,4,4,1,4]))