package jzoffer

func pathSum(root *TreeNode, sum int) [][]int {
	res := make([][]int, 0)
	if root == nil {
		return res
	}
	recursionPathSum(root, sum, &res, []int{})
	return res
}

func recursionPathSum(root *TreeNode, sum int, res *[][]int, tmp []int) {
	sum -= root.Val
	tmp = append(tmp, root.Val)
	if root.Left == nil && root.Right == nil && sum == 0 {
		cp := make([]int, len(tmp))
		copy(cp, tmp)
		*res = append(*res, cp)
		tmp = tmp[:len(tmp)-1]
		return
	}

	if root.Left != nil {
		recursionPathSum(root.Left, sum, res, tmp)
	}
	if root.Right != nil {
		recursionPathSum(root.Right, sum, res, tmp)
	}
	tmp = tmp[:len(tmp)-1]
}
