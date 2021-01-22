package jzoffer

func exist(board [][]byte, word string) bool {
	if len(word) == 0 {
		return true
	}
	memo := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		memo[i] = make([]bool, len(board[i]))
	}
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if board[i][j] == word[0] {
				if recursionExistPath(board, word, i, j, 0, memo) {
					return true
				}
			}
		}
	}
	return false
}

func recursionExistPath(board [][]byte, word string, startI, startJ, index int, memo [][]bool) bool {
	if index == len(word) {
		return true
	}
	if startI < 0 || startI >= len(board) || startJ < 0 || startJ >= len(board[startI]) || memo[startI][startJ] {
		return false
	}
	memo[startI][startJ] = true
	exists := word[index] == board[startI][startJ] && (recursionExistPath(board, word, startI+1, startJ, index+1, memo) ||
		recursionExistPath(board, word, startI-1, startJ, index+1, memo) ||
		recursionExistPath(board, word, startI, startJ+1, index+1, memo) ||
		recursionExistPath(board, word, startI, startJ-1, index+1, memo))
	memo[startI][startJ] = false
	return exists
}
