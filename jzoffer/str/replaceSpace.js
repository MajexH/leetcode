/**
 * 用in place的方法 讲str字符串里面的空格字符替换成"%20"
 * 如果是其他语言的话 可以首先遍历一遍整个str
 * 查看有多少个空格 可以计算出需要位移的数量
 * 然后从str的末尾开始 两个指针 一个指向现在str的末尾 一个指向完成替换的末尾
 * 然后从后向前扫描
 * 如果遇到的是一个空格，则替换 如果是普通的 则直接复制 这样实现了in place
 * @param {String} str 
 */
function replaceSpace(str) {
  // 有些语言这么做会有问题 比如说java的iterator 声明过后就不能再更改 除非重新赋值
  for (let i = 0; i < str.length; i++) {
    let char = str.charAt(i)
    if (char === ' ') {
      str = str.substring(0, i) + "%20" + str.substring(i + 1)
    }
  }
  return str
}

let a = 'We are happy!'

a = replaceSpace(a)

console.log(a)