package jzoffer

// 输入一个递增排序的数组和一个数字s
// 因为递增 所以 可以双指针遍历
func twoSum(nums []int, target int) []int {
	i, j := 0, len(nums)-1

	for i < j {
		sum := nums[i] + nums[j]

		if sum > target {
			j--
		} else if sum < target {
			i++
		} else {
			return []int{i, j}
		}
	}
	return []int{-1, -1}
}

// twoSumWithMemo 使用 memo 的 map 来记录之前遍历的 nums
func twoSumWithMemo(nums []int, target int) []int {
	memo := make(map[int]int)

	for i, num := range nums {
		if j, ok := memo[target-num]; ok {
			return []int{num, nums[j]}
		}
		memo[num] = i
	}
	return []int{}
}
