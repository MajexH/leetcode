package classic

import "math"

func divide(dividend int, divisor int) int {
	if divisor == 0 {
		return 1<<31 - 1
	}
	minus := -1
	if (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) {
		minus = 1
	}

	absDividend, absDivisor := int64(math.Abs(float64(dividend))), int64(math.Abs(float64(divisor)))
	res := 0
	for absDividend >= absDivisor {
		tmp, multi := absDivisor, 1
		for (tmp << 1) < absDividend {
			tmp <<= 1
			multi <<= 1
		}
		absDividend -= tmp
		res += multi
		if minus > 0 && res >= math.MaxInt32 {
			return math.MaxInt32
		} else if minus < 0 && minus*res <= math.MinInt32 {
			return math.MinInt32
		}
	}
	return minus * res
}
