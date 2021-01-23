package jzoffer

// myPow 由于 次方的特点 可以减少一半的计算量
func myPow(x float64, n int) float64 {
	minus := false
	if n < 0 {
		minus = true
		n = -n
	}
	var res float64 = powWithRecursion(x, n)
	if minus {
		return 1 / res
	}
	return res
}

func powWithRecursion(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}

	tmp := powWithRecursion(x, n>>1)
	res := tmp * tmp

	if n&1 == 1 {
		res *= x
	}
	return res
}

// myPow1 直接遍历超出了时间限制
func myPow1(x float64, n int) float64 {
	minus := false
	if n < 0 {
		minus = true
		n = -n
	}
	var res float64 = 1
	for i := 1; i <= n; i++ {
		res *= x
	}
	if minus {
		return 1 / res
	}
	return res
}
