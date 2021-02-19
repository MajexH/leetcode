package binarySearch

// 可以重复乘
func myPow(x float64, n int) float64 {
	minus := false
	if n < 0 {
		n = -n
		minus = true
	}
	if minus {
		return 1 / recursionMyPow(x, n)
	}
	return recursionMyPow(x, n)
}

func recursionMyPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}
	res := recursionMyPow(x, n/2)
	res *= res
	// 奇数
	if n&1 == 1 {
		res *= x
	}
	return res
}
