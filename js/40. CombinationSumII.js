/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
  let list = [], result = []
  for (let item of candidates) {
    if (item <= target) {
      list.push(item)
    }
  }
  // 排序 保证相同的数字排在一起
  list.sort()
  backTrack(list, [], 0, result, target)
  return result
};

function backTrack(list, temp, start, result, target) {
  if (target < 0) return 
  if (target === 0) {
    result.push(JSON.parse(JSON.stringify(temp)))
    return
  }
  for (let i = start; i < list.length; i++) {
    // 因为相同的数字排在了一起，因此 直接看现在是数字 是不是跟上一个数字相同 跟上一个数字相同 说明已经排过了
    if (i !== start && list[i - 1] === list[i]) continue
    temp.push(list[i])
    backTrack(list, temp, i + 1, result, target - list[i])
    temp.pop()
  }
}
console.log(combinationSum2([10,1,2,7,6,1,5], 8))