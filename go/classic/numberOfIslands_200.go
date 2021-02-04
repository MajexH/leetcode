package classic

func numIslands(grid [][]byte) int {
	memo := make([][]bool, len(grid))

	for i := 0; i < len(grid); i++ {
		memo[i] = make([]bool, len(grid[i]))
	}
	res := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if !memo[i][j] && grid[i][j] == '1' {
				dfsNumIslands(grid, &memo, i, j)
				res++
			}
		}
	}
	return res
}

func dfsNumIslands(grid [][]byte, memo *[][]bool, i, j int) {
	(*memo)[i][j] = true
	if i+1 < len(grid) && grid[i+1][j] == '1' && !(*memo)[i+1][j] {
		dfsNumIslands(grid, memo, i+1, j)
	}
	if i-1 >= 0 && grid[i-1][j] == '1' && !(*memo)[i-1][j] {
		dfsNumIslands(grid, memo, i-1, j)
	}
	if j+1 < len(grid[i]) && grid[i][j+1] == '1' && !(*memo)[i][j+1] {
		dfsNumIslands(grid, memo, i, j+1)
	}
	if j-1 >= 0 && grid[i][j-1] == '1' && !(*memo)[i][j-1] {
		dfsNumIslands(grid, memo, i, j-1)
	}
}
