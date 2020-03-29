/*
 * @lc app=leetcode id=820 lang=javascript
 *
 * [820] Short Encoding of Words
 */

// @lc code=start
function TierNode() {
  // count来保存现在的子节点数
  this.count = 0
  // 只保留26个英文字母
  // 不是英文字母的话 用hashmap
  // 其中null是初始化
  this.children = Array(26).fill(null)
}

TierNode.prototype.get = function(char) {
  if (this.children[char.charCodeAt(0) - 97] === null) {
    this.children[char.charCodeAt(0) - 97] = new TierNode()
    this.count++
  }
  return this.children[char.charCodeAt(0) - 97]
}
/**
 * 字符树
 * 构建一个从尾向前的字符树
 * 这样 当去构建这个字符数的时候
 * 有相同后缀的字符 就会在一条路径上
 * 这样去统计所有的叶子节点 的长度即可
 * @param {string[]} words
 * @return {number}
 */
var minimumLengthEncoding = function(words) {
  // map 每个word 中的 对应的 tier 节点
  let map = new Map()
  let tier = new TierNode()
  for (let i = 0; i < words.length; i++) {
    let word = words[i]
    let cur = tier
    for (let i = word.length - 1; i >= 0; i--) {
      cur = cur.get(word.charAt(i))
    }
    map.set(cur, i)
  }
  let res = 0
  for (let key of map.keys()) {
    // 表示这是个叶子节点
    if (key.count === 0) {
      // 长度是叶子节点的对应的word的长度+1
      res += words[map.get(key)].length + 1
    }
  }
  return res
};
// @lc code=end

console.log(minimumLengthEncoding(["time", "me", "bell"]))