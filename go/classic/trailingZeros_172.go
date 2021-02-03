package classic

func trailingZeroes(n int) int {
	res := 0

	for n > 0 {
		n /= 5
		res += n
	}
	return res
}

// trailingZeroesCountingEveryNumber 因为 2 * 5 == 10
// 所以就是要找到里面有多少个 5 因为 2 的因数肯定很多
func trailingZeroesCountingEveryNumber(n int) int {
	res := 0

	for n > 0 {
		res += countFive(n)
		n--
	}
	return res
}

func countFive(num int) int {
	res := 0
	for num%5 == 0 {
		num /= 5
		res++
	}
	return res
}
