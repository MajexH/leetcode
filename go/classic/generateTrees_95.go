package classic

func generateTrees(n int) []*TreeNode {
	return recursionGenerateTrees(1, n)
}

func recursionGenerateTrees(start, end int) []*TreeNode {
	if start > end {
		return make([]*TreeNode, 1)
	}
	res := make([]*TreeNode, 0)
	// 枚举 root 节点
	for i := start; i <= end; i++ {
		lefts, rights := recursionGenerateTrees(start, i-1), recursionGenerateTrees(i+1, end)
		for _, left := range lefts {
			for _, right := range rights {
				res = append(res, &TreeNode{
					Val:   i,
					Left:  left,
					Right: right,
				})
			}
		}
	}
	return res
}
