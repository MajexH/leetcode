package classic

// solve 将被 X 围起来的 O 改为 X
// 所以只需要找到四条边上的 O 和其相连的地方 让后更改即可
func solve(board [][]byte) {
	if len(board) == 0 {
		return
	}
	memo := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		memo[i] = make([]bool, len(board[i]))
	}

	// 找到四条边上的 O
	for _, i := range []int{0, len(board) - 1} {
		for j := 0; j < len(board[i]); j++ {
			if board[i][j] == 'O' && !memo[i][j] {
				dfsWithSolve(board, &memo, i, j)
			}
		}
	}
	for i := 0; i < len(board); i++ {
		for _, j := range []int{0, len(board[i]) - 1} {
			if board[i][j] == 'O' && !memo[i][j] {
				dfsWithSolve(board, &memo, i, j)
			}
		}
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if board[i][j] == 'O' && !memo[i][j] {
				board[i][j] = 'X'
			}
		}
	}
}

func dfsWithSolve(board [][]byte, memo *[][]bool, i, j int) {
	(*memo)[i][j] = true
	if i+1 < len(board) && board[i+1][j] == 'O' && !(*memo)[i+1][j] {
		dfsWithSolve(board, memo, i+1, j)
	}
	if i-1 >= 0 && board[i-1][j] == 'O' && !(*memo)[i-1][j] {
		dfsWithSolve(board, memo, i-1, j)
	}
	if j+1 < len(board[i]) && board[i][j+1] == 'O' && !(*memo)[i][j+1] {
		dfsWithSolve(board, memo, i, j+1)
	}
	if j-1 >= 0 && board[i][j-1] == 'O' && !(*memo)[i][j-1] {
		dfsWithSolve(board, memo, i, j-1)
	}
}
