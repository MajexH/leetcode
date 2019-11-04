/*
 * @lc app=leetcode id=130 lang=javascript
 *
 * [130] Surrounded Regions
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
  if (board.length === 0) return
  let x = board.length, y = board[0].length
  let flag = Array(x)
  for (let i = 0; i < x; i++) {
    flag[i] = Array(y).fill(false)
  }
  for (let i = 0; i < x; i += x - 1 <= 0 ? 1 : x - 1) {
    for (let j = 0; j < y; j++) {
      if (board[i][j] === 'O' && !flag[i][j]) {
        bst(board, i, j, flag)
      }
    }
  }
  for (let i = 0; i < x; i++) {
    for (let j = 0; j < y; j += y - 1 <= 0 ? 1 : y - 1) {
      if (board[i][j] === 'O' && !flag[i][j]) {
        bst(board, i, j, flag)
      }
    }
  }
  for (let i = 1; i < x - 1; i++) {
    for (let j = 1; j < y - 1; j++) {
      if (board[i][j] === 'O' && !flag[i][j])
        board[i][j] = 'X'
    }
  }
};

/**
 * i j 表示开始的位置
 * @param {character[][]} board 
 * @param {number} i 
 * @param {number} j 
 * @param {boolean[][]} flag 
 */
function bst(board, i, j, flag) {
  let queue = []
  queue.push([i, j])
  flag[i][j] = true
  while (queue.length > 0) {
    // 拿到头
    let [x, y] = queue.shift()
    // 分别找到上下左右 且没有访问过
    if (x - 1 >= 0 && !flag[x - 1][y] && board[x - 1][y] === 'O') {
      flag[x - 1][y] = true
      queue.push([x - 1, y])
    }
    if (x + 1 < board.length && !flag[x + 1][y] && board[x + 1][y] === 'O') {
      flag[x + 1][y] = true
      queue.push([x + 1, y])
    }
    if (y - 1 >= 0 && !flag[x][y - 1] && board[x][y - 1] === 'O') {
      flag[x][y - 1] = true
      queue.push([x, y - 1])
    }
    if (y + 1 < board[0].length && !flag[x][y + 1] && board[x][y + 1] === 'O') {
      flag[x][y + 1] = true
      queue.push([x, y + 1])
    }
  }
}

// @lc code=end

// let array = [
//   ['X', 'X', 'X', 'X'],
//   ['X', 'O', 'O', 'X'],
//   ['X', 'X', 'O', 'X'],
//   ['X', 'O', 'X', 'X']
// ]
let array = [['X']]

solve(array)

console.log(array)