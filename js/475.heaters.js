/*
 * @lc app=leetcode id=475 lang=javascript
 *
 * [475] Heaters
 */

// @lc code=start
/**
 * @param {number[]} houses
 * @param {number[]} heaters
 * @return {number}
 */
var findRadius = function(houses, heaters) {
  houses.sort((a, b) => a - b)
  heaters.sort((a, b) => a - b)
  let i = 0, max = 0, j = 0
  // 找到每个房子最近的heater
  while (i < houses.length) {
    // 一定要有等于 因为要找到 最近的一个
    while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
      j++
    }
    // 找到最近的heater 就需要去更新最大的半径
    max = Math.max(max, Math.abs(houses[i] - heaters[j]))
    i++
  }
  
  return max
};
// @lc code=end

console.log(findRadius([1,2,3,5,15],[2, 30]))