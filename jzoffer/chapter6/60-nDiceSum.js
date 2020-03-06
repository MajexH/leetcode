/**
 * 给定n个骰子 计算骰子所有骰子的朝上一面的出现的概率
 * @param {*} n 
 */
function nDicesSum(n) {
  let res = recurison(n, 1), total = Math.pow(n, n)
  for (let key of res.keys()) {
    res.set(key, res.get(key) / total)
  }
  return res
}

/**
 * 
 * @param {number} n 
 * @param {number} index
 */
function recurison(n, index) {
  let map = new Map()
  if (index === n) {
    for (let i = 1; i <= 6; i++) {
      map.set(i, 1)
    }
    return map
  }
  let res = recurison(n, index + 1)
  for (let i = 1; i <= 6; i++) {
    for (let item of res.keys()) {
      let temp = i + item
      let val = res.get(item)
      if (map.has(temp)) map.set(temp, map.get(temp) + val)
      else map.set(temp, val)
    }
  }
  return map
}

console.log(nDicesSum(6))