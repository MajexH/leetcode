/*
 * @lc app=leetcode id=299 lang=javascript
 *
 * [299] Bulls and Cows
 */

// @lc code=start
/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function(secret, guess) {
  let i = 0, a = 0, b = 0, array = Array(10).fill(0)
  while (i < secret.length) {
    if (secret.charAt(i) === guess.charAt(i)) {
      a++
    } else {
      // 如果有 但是位置错了 但是之前已经访问过了
      if (array[Number.parseInt(secret.charAt(i))]++ < 0) b++
      if (array[Number.parseInt(guess.charAt(i))]-- > 0) b++
    }
    i++
  }
  return `${a}A${b}B`
};
// @lc code=end

console.log(getHint("1122", "2211"))
