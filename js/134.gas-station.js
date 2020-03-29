/*
 * @lc app=leetcode id=134 lang=javascript
 *
 * [134] Gas Station
 */

// @lc code=start
/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
  let gasSum = gas.reduce((pre, cur) => pre + cur, 0)
  let costSum = cost.reduce((pre, cur) => pre + cur, 0)
  // 这种情况下 能加的油 少于整体的消耗量 因此不可能绕圈
  if (gasSum < costSum) return -1
  let curGas = 0, currentStation = 0
  // 遍历所有的开始节点
  for (let i = 0; i < gas.length; i++) {
    curGas += gas[i] - cost[i]
    // 当前的油量少了 不可能到达下一个站点
    // 因此选择下一个节点作为开始节点 是有可能能到达的
    // 而因为 整体的加油量 大于 耗油量 因此 是绝对可以到达的
    // 所以 单纯的让开始点向后移动即可
    if (curGas < 0) {
      currentStation = (i + 1) % gas.length
      // 在下一个站点重新出发
      curGas = 0
    }
  }
  return currentStation
};
// @lc code=end

console.log(canCompleteCircuit([3,3,4], [3,4,4]))