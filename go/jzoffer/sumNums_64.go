package jzoffer

// 不用加减乘除 算 1 + 到 n
func sumNums(n int) int {
	// 不能使用 if switch 等
	ans := 0
	var sum func(int) bool
	sum = func(n int) bool {
		// 闭包递归可还行
		ans += n
		return n > 0 && sum(n-1)
	}
	sum(n)
	return ans
}
