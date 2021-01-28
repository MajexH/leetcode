package classic

func searchMatrix(matrix [][]int, target int) bool {
	if matrix == nil {
		return false
	}
	i, j := 0, len(matrix)-1

	for i <= j {
		mid := (i + j) / 2
		if matrix[mid][0] > target {
			j = mid - 1
		} else if matrix[mid][len(matrix[i])-1] < target {
			i = mid + 1
		} else {
			return binarySearch(matrix[mid], target)
		}
	}
	return false
}

func binarySearch(nums []int, target int) bool {
	i, j := 0, len(nums)-1

	for i <= j {
		mid := (i + j) / 2
		if nums[mid] == target {
			return true
		}

		if nums[mid] > target {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}
	return false
}
