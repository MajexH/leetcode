package binarySearch

// 找到距离 x 最近的 k 个元素
// 其中 如果 a b 距离 x 相同距离 但是 a < b 那么选择 a 即优先选择左边的
// 这个时候还要比较左右的大小才可
func findClosestElements(arr []int, k int, x int) []int {
	if len(arr) == 0 || len(arr) < k {
		return []int{}
	}
	if x < arr[0] {
		return arr[:k]
	}
	if x > arr[len(arr)-1] {
		return arr[len(arr)-k:]
	}
	xIndex := binarySearchIndex(arr, x)
	// 这个时候 结果肯定在 xIndex 左右的 k-1 个数之中(算上 xIndex 这个位置的数) 压缩
	left, right := max(0, xIndex-k-1), min(len(arr)-1, xIndex+k-1)

	// 中间还剩 k 个数
	for right-left+1 > k {
		if arr[right]-x >= x-arr[left] {
			// 舍弃右边
			right--
		} else {
			left++
		}
	}
	return arr[left : right+1]
}

// 找到 target 的位置 或者距离 target 最近的 index 位置
func binarySearchIndex(nums []int, target int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := i + (j-i)/2

		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}

	return i
}
