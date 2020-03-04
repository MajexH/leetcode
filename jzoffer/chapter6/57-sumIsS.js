/**
 * 给定一个递增序列 查找和为target的两个数
 * @param {number[]} array
 * @param {number} target 
 */
function getTwoNumberSumOfS(array, target) {
  let i = 0, j = array.length - 1
  while (i < j) {
    let sum = array[i] + array[j]
    if (sum < target) {
    // 因为现在 sum < target 所以需要把小的一个数 向大的方向移动
      i++
    } else if (sum > target) {
    // 反之 sum > target 所以需要把大的一个数 向小的方向移动
      j--
    } else {
      return [array[i], array[j]]
    }
  }
  return [-1, -1]
}

console.log(getTwoNumberSumOfS([1,2,4,7,11,15], 15))