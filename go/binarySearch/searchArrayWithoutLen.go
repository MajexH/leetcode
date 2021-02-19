package binarySearch

// This is the ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
// 访问的时候 如果 越界 会范围 math.maxInt32
// 数组元素的值域是 [-9999, 9999]
type ArrayReader struct{}

func (this *ArrayReader) get(index int) int {
	return 0
}

// reader 是升序整数数组
func search(reader ArrayReader, target int) int {
	// 确定范围
	left, right := 0, 1

	for reader.get(right) != 2147483647 && reader.get(right) < target {
		left = right
		right *= 2
	}

	for left < right {
		mid := left + (right-left)/2

		if reader.get(mid) == 2147483647 {
			right = mid - 1
			continue
		}
		if reader.get(mid) > target {
			right = mid - 1
		} else if reader.get(mid) < target {
			left = mid + 1
		} else {
			return mid
		}
	}

	if reader.get(left) == target {
		return left
	}
	return -1
}
