/**
 * 给定一个数组array 构建另一个数字
 * 其中这个数组的满足 b[i] = a[1] * a[2] * …… * a[i - 1] * a[i + 1] * …… * a[n]
 * 但是不能使用乘法
 * @param {number[]} array 
 */
function constructMultipyArray(array) {
  // 因此构建这么个二维数组 其中主要分为两部分 来计算 a[1] 到 a[i - 1] 的乘积 a[i + 1] 到 a[n]的乘积
  let left = Array(array.length), right = Array(array.length), constructed = Array(array.length)
  // 初始化
  left[0] = 1
  right[array.length - 1] = 1
  // 构建left数组
  for (let i = 1; i < array.length; i++) {
    left[i] = left[i - 1] * array[i - 1]
  }
  for (let i = array.length - 2; i >= 0; i--) {
    right[i] = right[i + 1] * array[i + 1]
  }
  for (let i = 0; i < array.length; i++) {
    constructed[i] = left[i] * right[i]
  }
  return constructed
}

console.log(constructMultipyArray([1,2,3,4,5,6]))