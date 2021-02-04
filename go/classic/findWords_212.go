package classic

func findWords(board [][]byte, words []string) []string {
	res := make([]string, 0)
	memo := make([][]bool, len(board))
	for i := 0; i < len(board); i++ {
		memo[i] = make([]bool, len(board[i]))
	}
	for _, word := range words {
		res = traverseBoard(board, word, memo, res)
	}
	return res
}

func traverseBoard(board [][]byte, word string, memo [][]bool, res []string) []string {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if len(word) > 0 && word[0] == board[i][j] {
				if dfsFindWords(board, memo, word, i, j, 0) {
					res = append(res, word)
					return res
				}
			}
		}
	}
	return res
}

func dfsFindWords(board [][]byte, memo [][]bool, word string, i, j int, index int) bool {
	if index == len(word) {
		return true
	}
	if i >= len(board) || i < 0 || j < 0 || j >= len(board[i]) || memo[i][j] {
		return false
	}
	memo[i][j] = true
	flag := word[index] == board[i][j] && (dfsFindWords(board, memo, word, i+1, j, index+1) ||
		dfsFindWords(board, memo, word, i-1, j, index+1) ||
		dfsFindWords(board, memo, word, i, j+1, index+1) ||
		dfsFindWords(board, memo, word, i, j-1, index+1))
	memo[i][j] = false
	return flag
}
