package binarySearch

// 两个数组的交集
func intersection(nums1 []int, nums2 []int) []int {
	res := make([]int, 0)
	set := make(map[int]int)
	set2 := make(map[int]int)
	for _, num := range nums1 {
		set[num] = 1
	}
	for _, num := range nums2 {
		set2[num] = 1
	}

	for num := range set {
		if _, ok := set2[num]; ok {
			res = append(res, num)
		}
	}
	return res
}
