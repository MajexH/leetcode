/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit1 = function(gas, cost) {
  for (let i = 0; i < gas.length; i++) {
    if (gas[i] < cost[i]) continue
    let res = recursion(gas, cost, i, i, 0, false)
    if (res !== -1) {
      return res
    }
  }
  return  -1
};

/**
 * 
 * @param {number[]} gas 
 * @param {number[]} cost 
 * @param {number} start 
 * @param {number} curStation 当前站点
 * @param {number} curGas 当前油量
 * @param {boolean} flag 
 */
function recursion(gas, cost, start, curStation, curGas, flag) {
  if (curStation === start) {
    if (flag) return start
    else {
      return recursion(gas, cost, start, (curStation + 1) % gas.length, curGas + gas[curStation], true)
    }
  }
  curGas = curGas - cost[curStation - 1 < 0 ? gas.length - 1 : curStation - 1] + gas[curStation]
  if (curGas < cost[curStation]) return -1
  return recursion(gas, cost, start, (curStation + 1) % gas.length, curGas, flag)
}

/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
  // 如果总体的加油量 小于 油耗 肯定不能走完
  let gasSum = gas.reduce((pre, cur) => pre + cur, 0)
  let costSum = cost.reduce((pre, cur) => pre + cur, 0)
  if (gasSum < costSum) {
    return -1
  }
  let curGas = 0, curStation = 0
  for (let i = 0; i < gas.length; i++) {
    curGas += gas[i] - cost[i]
    // 说明在i这个点 这个地方是负累加 即从最开始的start开始到i 这个地方是没办法回去的 所以从i+1开始遍历
    // 但是从 start - （i - 1）这个区间上 是正累加的 而如果从 i + 1这个后面也是正累加 意味着 从 i+1 - start 这个位置都是正累加 所有可以过去
    if (curGas < 0) {
      curStation = i + 1
      curGas = 0
    }
  }
  return curStation
};

console.log(canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]))