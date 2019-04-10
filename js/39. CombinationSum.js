/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
  let list = [], result = []
  for (let item of candidates) {
    if (item <= target)
      list.push(item)
  }
  backTrack(candidates, target, [], 0, result)
  return result
};

// 其实 就是DFS
function backTrack(list, target, tempList, start, result) {
  if (target < 0) return;
  if (target === 0) {
    result.push(JSON.parse(JSON.stringify(tempList)))
    return
  }
  for (let i = start; i < list.length; i++) {
    tempList.push(list[i]);
    backTrack(list, target - list[i], tempList, i, result)
    tempList.pop()
  }
}

console.log(combinationSum([2,3,5], 8))