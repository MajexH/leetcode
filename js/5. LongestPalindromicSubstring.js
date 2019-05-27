/**
 * 把他看做一个动态规划问题的话就是
 * 如果一个字符串`aba`是回文数
 * 那么只有再它前一个数和后一个数都是相等的情况下才是回文数
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
  let memo = [], n = s.length, max = ''
  for (let i = 0; i < s.length; i++) {
    memo[i] = Array(s.length).fill(false)
  }
  for (let len = 1; len <= n; len++) {
    for (let start = 0; start < n; start++) {
      let end = start + len - 1
      if (end > n) break;
      memo[start][end] = (len === 1 || len === 2 || memo[start + 1][end - 1]) && s[start] === s[end]
      if (memo[start][end] && len > max.length) {
        max = s.substring(start, end + 1);
      }
    }
  }
  return max
};



console.log(longestPalindrome("babaddtattarrattatddetartrateedredividerb"))