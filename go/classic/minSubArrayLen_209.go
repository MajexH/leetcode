package classic

import "math"

func minSubArrayLenWithTwoPointer(target int, nums []int) int {
	sum := 0
	i, j := -1, -1
	minLen := math.MaxInt32
	for i <= j && (i < len(nums) || j < len(nums)) {
		for sum <= target {
			if sum >= target {
				minLen = min(minLen, j-i)
			}
			j++
			if j >= len(nums) {
				break
			}
			sum += nums[j]
		}

		if j >= len(nums) && sum < target {
			break
		}

		for sum >= target {
			if sum >= target {
				minLen = min(minLen, j-i)
			}
			i++
			if i >= len(nums) {
				break
			}
			sum -= nums[i]
		}
	}
	if minLen == math.MaxInt32 {
		return 0
	}
	return minLen
}

// 找到 nums 中的一个子数组其和大于等于 target
func minSubArrayLen(target int, nums []int) int {
	sum := 0
	left := 0
	minLen := math.MaxInt32

	for i, num := range nums {
		sum += num
		for sum >= target {
			minLen = min(minLen, i-left+1)
			sum -= nums[left]
			left++
		}
	}
	if minLen == math.MaxInt32 {
		return 0
	}
	return minLen
}
