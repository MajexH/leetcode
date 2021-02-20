package binarySearch

func findDuplicate(nums []int) int {
	i, j := 1, len(nums)-1

	for i < j {
		mid := i + (j-i)/2

		count := findNumberCount(nums, i, mid)

		if count <= mid-i+1 {
			i = mid + 1
		} else {
			j = mid
		}
	}
	return i
}

func findNumberCount(nums []int, start, end int) int {
	res := 0
	for _, num := range nums {
		if num >= start && num <= end {
			res++
		}
	}
	return res
}
