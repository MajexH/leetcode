/*
 * @lc app=leetcode id=167 lang=javascript
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  for (let i = 0; i < numbers.length; i++) {
    let tempTarget = target - numbers[i]
    let start = i + 1, end = numbers.length - 1
    if (start > end) break
    while (start <= end) {
      let mid = Math.floor((start + end) / 2)
      if (tempTarget > numbers[mid]) {
        start = mid + 1
      } else if (tempTarget < numbers[mid]){
        end = mid - 1
      } else {
        return [i + 1, mid + 1]
      }
    }
  }
  return []
};
// @lc code=end

console.log(twoSum([2,7,11,15], 9))