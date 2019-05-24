/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
  // 用来记录当前节点是否被访问过 因为一个节点只能使用一次
  // 0表示当前节点未访问过
  let memo = []
  for (let i  = 0; i < board.length; i++) {
    memo[i] = Array(board[0].length).fill(0);
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      // 如果第一个相等 就开始匹配
      if (board[i][j] === word[0]) {
        if (find(word, board, i, j, memo, 0)) {
          return true
        }
      }
    }
  }
  return false;
};

/**
 *
 * @param {string} word 
 * @param {character[][]} board 
 * @param {number} i 
 * @param {number} j 
 * @param {number[][]} memo
 * @param {number} index 
 */
function find(word, board, i, j, memo, index) {
  // 处理越界 因为越界 所有不能走这边 也就是走这边的都是false
  if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
    return false
  // 判断当前节点是不是跟word的相等 且没有访问过
  if (word[index] === board[i][j] && !memo[i][j]) {
    // 如果当前访问完了word且最后一位相等
    if (index === word.length - 1)
      return true
    // 将memo改为已访问
    memo[i][j] = 1
    // 分别去找上下左右 只要有一个找到是true就行 这是从这个地方到最后
    if (find(word, board, i - 1, j, memo, index + 1) ||
      find(word, board, i + 1, j, memo, index + 1) ||
      find(word, board, i, j - 1, memo, index + 1) ||
      find(word, board, i, j + 1, memo, index + 1)) {
        // 重置memo状态
        memo[i][j] = 0
        return true
      }
    // 重置memo状态
    memo[i][j] = 0
  }
  // 其他所有情况都是false
  return false
}


let board = [
  ["C","A","A"],
  ["A","A","A"],
  ["B","C","D"]
]

let word = 'AAB'

console.log(exist(board, word))