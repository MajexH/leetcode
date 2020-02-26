/**
 * 数字以0123456789101112131415……的顺序格式化
 * 求第n位的数字是什么 如13位的数字是1 19位的数字是4
 * @param {Number} n n代表从0开始的正数 其实就是字符的位置 也就是前面的所有字符的和
 * @returns {Number}
 */
function getNumberInSequence(n) {
  // maxNumber代表前面一共有多少个数字 因为是从0开始的 所以不用减一
  let time = 1, count = 0, mount = 10, maxNumber = 0
  while (count <= n) {
    maxNumber += mount
    // 当前的字符数
    count += mount * time
    // 从1个数一个字符 开始增长 每次增加一位 
    time++
    mount *= time === 2 ? 9 : 10
    
  }
  // 出来的count是n的字符位数的上线
  // time 是当前一个数字的 字符的长度
  // mount 是数的上线
  // 从maxNumber 根据字符数找到 数字
  let number = maxNumber - Math.ceil((count - n) / (time - 1)).toString()
  // 找到数字 再根据字符数 找到当前的数字
  return Number.parseInt(number.toString().charAt((count - n) % (time - 1)))
}

console.log(getNumberInSequence(8))