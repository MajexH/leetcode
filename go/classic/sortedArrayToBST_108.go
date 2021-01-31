package classic

func sortedArrayToBST(nums []int) *TreeNode {
	return recursionSortedArrayToBST(nums, 0, len(nums)-1)
}

func recursionSortedArrayToBST(nums []int, i, j int) *TreeNode {
	if i > j {
		return nil
	}
	mid := (i + j) / 2

	res := &TreeNode{
		Val:   nums[mid],
		Left:  nil,
		Right: nil,
	}
	res.Left = recursionSortedArrayToBST(nums, i, mid-1)
	res.Right = recursionSortedArrayToBST(nums, mid+1, j)
	return res
}
