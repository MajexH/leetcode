/*
 * @lc app=leetcode id=401 lang=javascript
 *
 * [401] Binary Watch
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string[]}
 */
var readBinaryWatch = function(num) {
  let res = []
  for (let i = 0; i < 12; i++) {
    for (let j = 0; j < 60; j++) {
      if (bitCount(i) + bitCount(j) === num) {
        res.push(`${i}:${getStr(j)}`)
      }
    }
  }
  return res
};

function getStr(num) {
  if (num < 10) return `0${num}`
  else return num.toString()
}

function bitCount (n) {
  n = n - ((n >> 1) & 0x55555555)
  n = (n & 0x33333333) + ((n >> 2) & 0x33333333)
  return ((n + (n >> 4) & 0xF0F0F0F) * 0x1010101) >> 24
}
// @lc code=end

console.log(readBinaryWatch(1))