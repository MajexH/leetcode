/**
 * 
 * @param {Array} list 
 * @param {number} start indicate the start position of the array 
 * @param {Array} result
 */
function perm(list, start, result) {
  // stop
  if (start === list.length - 1) {
    let temp = JSON.parse(JSON.stringify(list));
    result.push(temp)
    return
  }
  for (let i = start; i < list.length; i++) {
    // swap
    swap(list, start, i);
    perm(list, start + 1, result);
    // 交换回来
    swap(list, start, i)
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