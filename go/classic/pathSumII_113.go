package classic

func pathSum(root *TreeNode, targetSum int) [][]int {
	res := make([][]int, 0)
	if root == nil {
		return res
	}
	recursionPathSumII(&res, root, targetSum, []int{})
	return res
}

func recursionPathSumII(res *[][]int, node *TreeNode, target int, tmp []int) {
	tmp = append(tmp, node.Val)
	if node.Left == nil && node.Right == nil && target == node.Val {
		cp := make([]int, len(tmp))
		copy(cp, tmp)
		*res = append(*res, cp)
		tmp = tmp[:len(tmp)-1]
		return
	}
	if node.Left == nil && node.Right == nil {
		return
	}

	if node.Left != nil {
		recursionPathSumII(res, node.Left, target-node.Val, tmp)
	}

	if node.Right != nil {
		recursionPathSumII(res, node.Right, target-node.Val, tmp)
	}
	tmp = tmp[:len(tmp)-1]
}
