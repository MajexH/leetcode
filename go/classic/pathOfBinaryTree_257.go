package classic

import (
	"strconv"
	"strings"
)

func binaryTreePaths(root *TreeNode) []string {
	res := make([]string, 0)
	recursionBinaryTreePaths(root, &res, []string{})
	return res
}

// 一直到叶子节点
func recursionBinaryTreePaths(root *TreeNode, res *[]string, tmp []string) {
	if root == nil {
		return
	}
	tmp = append(tmp, strconv.Itoa(root.Val))
	if root.Left == nil && root.Right == nil {
		*res = append(*res, strings.Join(tmp, "->"))
		return
	}
	if root.Left != nil {
		recursionBinaryTreePaths(root.Left, res, tmp)
	}
	if root.Right != nil {
		recursionBinaryTreePaths(root.Right, res, tmp)
	}
	tmp = tmp[:len(tmp)-1]
}
