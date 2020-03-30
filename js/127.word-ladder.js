/*
 * @lc app=leetcode id=127 lang=javascript
 *
 * [127] Word Ladder
 */

// @lc code=start
/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function(beginWord, endWord, wordList) {
  let map = new Map()
  for (let word of wordList) {
    for (let i = 0; i < word.length; i++) {
      let tempStr = word.substring(0, i) + '*' + word.substring(i + 1)
      if (map.has(tempStr)) {
        map.get(tempStr).push(word)
      } else {
        map.set(tempStr, [word])
      }
    }
  }
  // bsf
  let level = 1
  let visited = new Set()
  let queue = []
  queue.push(beginWord)
  queue.push(null)
  visited.add(beginWord)
  while (queue.length !== 0) {
    let top = queue.shift()
    if (top === null) {
      if (queue.length === 0) break
      queue.push(null)
      level++
      continue
    }
    for (let i = 0; i < top.length; i++) {
      let tempStr = top.substring(0, i) + '*' + top.substring(i + 1)
      if (map.has(tempStr)) {
        for (let adjacent of map.get(tempStr)) {
          if (adjacent === endWord) return level + 1
          if (!visited.has(adjacent)) {
            visited.add(adjacent)
            queue.push(adjacent)
          }
        }
      }
    }
  }
  return 0
};
// @lc code=end

console.log(ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))