/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak1 = function(s, wordDict) {
  return recursion(s, 0, wordDict, new Map())
};

/**
 * memo用一个index来保存结果 因为memo[index]可以来表示一个从index开始的字符串是否存在在dict里面的结果 不用再重复访问了
 * @param {string} str 
 * @param {number} start 
 * @param {string[]} wordDict 
 * @param {Map} memo
 */
function recursion(str, start, wordDict, memo) {
  if (start === str.length) {
    memo.set(start, true)
    return true
  }
  if (memo.has(start)) return memo.get(start)
  // flag来记录所有可能
  let flag = false
  for (let i = start + 1; i <= str.length; i++) {
    // 如果当前字符子串在wordDict的里面
    let temp = str.substring(start, i)
    if (wordDict.includes(temp, 0)) {
      flag = flag || recursion(str, i, wordDict, memo)
      if (flag) return flag
    }
  }
  memo.set(start, flag)
  return flag
}

/**
 * dp[i]代表的是0-i的字符串是可以被在dict里面找到的
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
  let dp = Array(s.length + 1).fill(false)
  // 空字符串肯定是能找到的
  dp[0] = true
  for (let i = 1; i <= s.length; i++) {
    for (let j = 0; j < i; j++) {
      let temp = s.substring(j, i)
      // 表示 0-j j-i都是可以在dict里面找到的 所以dp[i]是true
      if (wordDict.includes(temp, 0) && dp[j]) {
        dp[i] = true
      }
    }
  }
  return dp[s.length]
};


console.log(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]))