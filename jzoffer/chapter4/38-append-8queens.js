/**
 * 8皇后问题
 * 一个8 * 8的国际棋盘上 摆8个皇后
 * 8个皇后中任意两个不能再同一行 同一列 和 同意对角线上
 * 一共有多少种排列方法
 */
function queens() {
  // 首先 这8个皇后 肯定是在8个不同的行上
  // 这个Array表示了每一行 的每一个皇后 所在的列号
  let clounmsIndex = Array(8)
  for (let i = 0; i < clounmsIndex.length; i++) {
    clounmsIndex[i] = i
  }
  // 得到这些列号的所有排列
  let per = [], res = []
  recursion(clounmsIndex, per, 0)
  // 遍历这些排列 看是否符合要求
  for (let oneRes of per) {
    let flag = true
    for (let i = 0 ; i < oneRes.length; i++) {
      for (let j = i + 1; j < oneRes.length; j++) {
        // 不在对角线上的
        if (j - i === Math.abs(oneRes[i] - oneRes[j])) {
          // console.log(i, j, clounmsIndex[i], clounmsIndex[j])
          flag = false
          break
        }
      }
    }
    if (flag) res.push(oneRes)
  }
  return res
}

function recursion(array, res, start) {
  if (start >= array.length) {
    res.push([...array])
    return
  }
  for (let i = start ; i < array.length; i++) {
    swap(array, start, i)
    recursion(array, res, start + 1)
    swap(array, start, i)
  }
}

function swap(array, i, j) {
  let temp = array[i]
  array[i] = array[j]
  array[j] = temp
}

console.log(queens().length)