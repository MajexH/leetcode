package leetcodeExplore

import "math"

func merge(nums1 []int, m int, nums2 []int, n int) {
	index := m + n - 1
	m = m - 1
	n = n - 1
	for m >= 0 || n >= 0 {
		if index < 0 {
			break
		}
		var num1, num2 int
		if m < 0 {
			num1 = math.MinInt32
		} else {
			num1 = nums1[m]
		}

		if n < 0 {
			num2 = math.MinInt32
		} else {
			num2 = nums2[n]
		}

		if num1 > num2 {
			nums1[index] = num1
			m--
		} else {
			nums1[index] = num2
			n--
		}
		index--
	}
}
