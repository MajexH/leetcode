/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
  let result = [], record = Array(10).fill(true)
  recursion(k, n, 0, result, [], record, 1)
  return result
};

/**
 * 
 * @param {number} k 
 * @param {number} target 
 * @param {Array} result
 * @param {Array} temp
 * @param {Boolean[]} record
 * @param {number} start
 */
function recursion(k, target, index, result, temp, record, start) {
  if (index > k || target < 0) {
    return;
  }
  if (index === k && target == 0) {
    result.push(JSON.parse(JSON.stringify(temp)))
    return;
  }
  for (let i = start; i <= 9; i++) {
    if (record[i]) {
      record[i] = false
      temp.push(i)
      // 用start来记录开始的位置 如果他现在第一个加入数组的是2 这时候再去访问1 其实已经在 [1,2] 这个序列中访问过了 因此 直接跳过 从i+1开始访问 防止重复
      recursion(k, target - i, index + 1, result, temp, record, i + 1)
      temp.pop()
      record[i] = true
    }
  }
}

console.log(combinationSum3(3, 7))