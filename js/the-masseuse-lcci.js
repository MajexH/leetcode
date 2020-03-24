/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * @param {number[]} nums
 * @return {number}
 */
var massage = function(nums) {
  if (nums.length === 0) return 0
  // 下面两个dp[i] 分别表示 i 位数 拿不拿的 之前的最大值
  let dpNotTaken = Array(nums.length).fill(0)
  let dpTaken = Array(nums.length).fill(0)
  dpTaken[0] = nums[0]
  for (let i = 1; i < nums.length; i++) {
    // 第i位数不拿的话 那么 第 i -1 位数 拿不拿 无所谓
    // 所以取两个的最大值
    dpNotTaken[i] = Math.max(dpTaken[i - 1], dpNotTaken[i - 1])
    // 第i位数拿的话 第 i - 1位肯定不拿
    dpTaken[i] = dpNotTaken[i - 1] + nums[i]
  }
  return Math.max(dpNotTaken[dpNotTaken.length - 1], dpTaken[dpNotTaken.length - 1])
};

console.log(massage([]))