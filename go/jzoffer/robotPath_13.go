package jzoffer

func movingCount(m int, n int, k int) int {
	memo := make([][]bool, m)
	for i := 0; i < m; i++ {
		memo[i] = make([]bool, n)
	}
	return recursionMovingCount(0, 0, m, n, k, memo)
}

func recursionMovingCount(x, y, m, n, k int, memo [][]bool) int {
	if x < 0 || y < 0 || x >= m || y >= n || memo[x][y] {
		return 0
	}
	if addNumber(x)+addNumber(y) > k {
		return 0
	}
	memo[x][y] = true
	return 1 +
		recursionMovingCount(x-1, y, m, n, k, memo) +
		recursionMovingCount(x+1, y, m, n, k, memo) +
		recursionMovingCount(x, y-1, m, n, k, memo) +
		recursionMovingCount(x, y+1, m, n, k, memo)
}

func addNumber(num int) int {
	res := 0
	for num > 0 {
		res += num % 10
		num /= 10
	}
	return res
}
