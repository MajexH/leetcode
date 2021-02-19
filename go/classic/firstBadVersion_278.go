package classic

// api
func isBadVersion(version int) bool {
	if version >= 4 {
		return true
	}
	return false
}

func firstBadVersion(n int) int {
	i, j := 1, n

	for i < j {
		mid := (i + j) / 2

		if isBadVersion(mid) {
			j = mid
		} else {
			i = mid + 1
		}
	}
	return i
}
