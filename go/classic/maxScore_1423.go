package classic

import "math"

func maxScore(cardPoints []int, k int) int {
	if len(cardPoints) == 0 {
		return 0
	}
	// 因为是从前后取一共 k 个 所以相当于中间有一个连续的 n - k 个可以形成最小值

	length := len(cardPoints) - k

	minSum := math.MaxInt32
	mov := 0
	sum := 0
	for i := 0; i < length; i++ {
		mov += cardPoints[i]
		sum += cardPoints[i]
	}
	minSum = min(minSum, mov)
	for i := length; i < len(cardPoints); i++ {
		sum += cardPoints[i]
		mov = mov + cardPoints[i] - cardPoints[i-length]
		minSum = min(minSum, mov)
	}
	return sum - minSum
}
