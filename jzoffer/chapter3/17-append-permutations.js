/**
 * 给定一组数字 给出其所有的排列组合
 * 其中数字 是不会有重复的
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let res = []
  recursion(nums, res, 0)
  return res
};

/**
 * 给定一组数字 得到其全排列
 * 其中数字是有重复的
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  let res = []
  recursionUnique(nums, res, 0)
  return res
};

/**
 * 
 * @param {Array} nums 
 * @param {Array} res 
 */
function recursion(nums, res, start) {
  if (start === nums.length) {
    res.push([...nums])
    return
  }
  for (let i = start; i < nums.length; i++) {
    swap(nums, i, start)
    recursion(nums, res, start + 1)
    swap(nums, i, start)
  }
}

function swap(nums, i, j) {
  if (i === j) return
  let temp = nums[i]
  nums[i] = nums[j]
  nums[j] = temp
}

console.log(permute([1,2,3]))


/**
 * 
 * @param {Array} nums 
 * @param {Array} res 
 * @param {number} start 
 */
function recursionUnique(nums, res, start) {
  if (start === nums.length) {
    res.push([...nums])
    return
  }
  for (let i = start; i < nums.length; i++) {
    if (canGenerate(nums, start, i)) {
      swap(nums, i, start)
      recursionUnique(nums, res, start + 1)
      swap(nums, i, start)
    }
  }
}

/**
 * 
 * @param {Array} nums 
 * @param {Number} start 
 * @param {Number} end 
 */
function canGenerate(nums, start, end) {
  for (let i = start; i < end; i++) {
    if (nums[i] === nums[end]) return false
  }
  return true
}

console.log(permuteUnique([1,1,2]))