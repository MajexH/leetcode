package jzoffer

func fib(n int) int {
	memo := make([]int, n+1)
	for i := 0; i <= n; i++ {
		memo[i] = -1
	}
	return recursionFib(n, &memo)
}

func fibWithoutRecursion(n int) int {
	if n == 0 {
		return 0
	}
	dp := make([]int, n+1)
	dp[0], dp[1] = 0, 1

	for i := 2; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2]) % 1000000007
	}
	return dp[n]
}

func recursionFib(n int, memo *[]int) int {
	if n <= 0 {
		return 0
	}
	if n == 0 || n == 1 {
		(*memo)[n] = n
		return n
	}
	if (*memo)[n] != -1 {
		return (*memo)[n]
	}
	(*memo)[n] = ((recursionFib(n-1, memo))%1000000007 + (recursionFib(n-2, memo))%1000000007) % 1000000007
	return (*memo)[n]
}
