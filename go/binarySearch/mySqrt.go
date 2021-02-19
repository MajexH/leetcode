package binarySearch

func mySqrt(x int) int {
	i, j := 1, x

	for i <= j {
		mid := (i + j) / 2
		if mid*mid > x {
			j = mid - 1
		} else if mid*mid < x {
			i = mid + 1
		} else {
			return mid
		}
	}
	return j
}
