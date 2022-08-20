package classic

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func constructMaximumBinaryTree(nums []int) *TreeNode {
	// 构造结果
	return recursionConstruct(0, len(nums)-1, nums)
}

func recursionConstruct(start, end int, nums []int) *TreeNode {
	if start > end {
		return nil
	}

	// 找到 max 的下标
	maxIndex := start
	for i := start + 1; i <= end; i++ {
		if nums[maxIndex] < nums[i] {
			maxIndex = i
		}
	}

	node := &TreeNode{
		Val:   nums[maxIndex],
		Left:  recursionConstruct(start, maxIndex-1, nums),
		Right: recursionConstruct(maxIndex+1, end, nums),
	}

	return node
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
