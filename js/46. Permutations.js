/**
 * 
 * @param {Array} list 
 * @param {Number} start indicate the start position of the array 
 * @param {Array} result
 */
function perm(list, start, result) {
  // TODO: stop
  if (start === list.length - 1) {
    result.push(list)
    return
  }
  for (let i = 0; i < list.length; i++) {
    let temp = JSON.parse(JSON.stringify(list))
    // swap
    swap(list, start, i);
    perm(temp, i + 1, result);
  }
}

/**
 * 
 * @param {Array} nums 
 * @param {Number} i 
 * @param {Number} j 
 */
function swap(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
  let result = []
  perm(nums, 0, result);
  return result;
};

console.log(permute([1, 2 ,3]))