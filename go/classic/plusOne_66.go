package classic

func plusOne(digits []int) []int {
	add := 1

	for i := len(digits) - 1; i >= 0; i-- {
		tmp := digits[i] + add
		digits[i] = tmp % 10
		add = tmp / 10
		if add == 0 {
			break
		}
	}
	if add != 0 {
		// 需要在头上加一个数
		res := []int{add}
		res = append(res, digits...)
		return res
	}
	return digits
}
