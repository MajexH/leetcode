package binarySearch

// 旋转排序数组找到最小的元素
func findMin(nums []int) int {
	i, j := 0, len(nums)-1

	for i < j {
		mid := i + (j-i)/2
		// 因为是旋转排序数组 所以要判断拐点在哪儿
		if nums[mid] > nums[j] {
			// 拐点在右边
			i = mid + 1
		} else if nums[mid] < nums[i] {
			// 拐点要么在左边 要么在这个点
			j = mid
		} else {
			// 正常的升序数组
			return nums[i]
		}
	}
	return nums[i]
}
