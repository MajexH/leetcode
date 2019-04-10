/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
  // sort之后 后面好做
  nums.sort((a, b) => { return a - b })
  let result = [];
  ksum(nums, 4, target, 0, result, [])
  return result;
};

/**
 * 
 * @param {Array} nums 
 * @param {Number} k 表示几个数求和
 * @param {Number} target
 * @param {NUmber} start
 * @param {Array} result
 * @param {Array} temp
 */
function ksum(nums, k, target, start, result, temp) {
  // 两个数相加的情况
  if (k === 2) {
    let i = start, j = nums.length - 1;
    while (i < j) {
      let sum = nums[i] + nums[j];
      if (sum < target) i++
      else if (sum > target) j--;
      else {
        temp.push(nums[i], nums[j])
        result.push(temp)
        // 跳过重复数字
        do {
          i++;
        } while (i < j && nums[i] === nums[i - 1])
        do {
          j--;
        } while (i < j && nums[j] === nums[j + 1])
      }
    }
    return 
  }
  for (let i = start; i < nums.length - k + 1; i++) {
    if (i !== start && nums[i] === nums[i - 1]) continue;
    temp.push(nums[i])
    ksum(nums, k - 1, target - nums[i], start + 1, result, JSON.parse(JSON.stringify(temp)))
    temp.pop()
  }
}

console.log(fourSum([1, 0, -1, 0, -2, 2], 0))