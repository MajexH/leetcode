/**
 * 只能用o(1)的空间 和o(n^2)的时间
 * 这个是错误的 为什么呢 因为Boye是寻找里面的 Majority
 * 也就是说 出现次数达到 n / 2以上的数儿的
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicateBoye = function(nums) {
  let number = nums[0], counter = 1
  for (let i = 1; i < nums.length; i++) {
    if (counter === 0) {
      number = nums[i]
      counter++
    }
    else if (nums[i] !== number) {
      counter--
    } else {
      counter++
    }
  }
  return number
};

/**
 * 这个nums有n+1个数字 包含了从[1-n]的所有数儿
 * 只能用o(1)的空间 和o(n^2) 以下的时间
 * 也就是基本上锁定的 二分
 * 也是由于其数据的特殊性才能这样做
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
  let i = 1, j = nums.length - 1
  while (i <= j) {
    let mid = Math.floor((i + j) / 2)
    let counter = getCount(nums, i, mid)
    if (i === j) return i
    // 如果左边的 数量比较多 说明重复再左边
    if (counter > mid - i + 1) {
      j = mid
    } else{
      i = mid + 1
    }
  }
  return i
};

/**
 * 
 * @param {Array} nums 
 * @param {Number} start 
 * @param {Number} end 
 */
function getCount(nums, start, end) {
  let counter = 0
  for (let item of nums) {
    if (item >= start && item <= end)
      counter++
  }
  return counter
}

console.log(findDuplicate([1,3,4,2,2]))