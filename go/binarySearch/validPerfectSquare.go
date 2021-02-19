package binarySearch

// num 是否是一个完全平方数
func isPerfectSquare(num int) bool {
	i, j := 1, num

	for i < j {
		mid := i + (j-i)/2
		tmp := mid * mid
		if tmp == num {
			return true
		} else if tmp > num {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}
	return i*i == num
}
