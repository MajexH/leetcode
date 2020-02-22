/**
 * 给定一个包含8个数字的的数组
 * 判断有没有可能这个8个数字在正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和相等
 * @param {Number[]} array
 * @returns {Boolean}
 */
function checkCube(array) {
  let per = [], res = []
  // 拿到所有的排列 再判断
  recursion(array, per, 0)
  for (let array of per) {
    if (array[0] + array[1] + array[2] + array[3] === array[4] + array[5] + array[6] + array[7] &&
        array[0] + array[2] + array[4] + array[6] === array[1] + array[3] + array[5] + array[7] &&
        array[0] + array[1] + array[4] + array[5] === array[2] + array[3] + array[6] + array[7])
    res.push(array)
  } 
  return res
}

/**
 * 得到这8个数组的所有排列组合
 * @param {Number[]} array 
 * @param {Number[]} res 
 * @param {Number} start
 */
function recursion(array, res, start) {
  if (start >= array.length) {
    res.push([...array])
    return
  }
  for (let i = start; i < array.length; i++) {
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