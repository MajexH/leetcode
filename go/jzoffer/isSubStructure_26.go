package jzoffer

// 子结构不一定是完全一样的
func isSubStructure(A *TreeNode, B *TreeNode) bool {
	if A == nil || B == nil {
		return false
	}
	if A.Val == B.Val {
		if recursionIsSubStructure(A, B) {
			return true
		}
	}
	return isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
}

func recursionIsSubStructure(A *TreeNode, B *TreeNode) bool {
	if A == nil && B != nil {
		return false
	}
	if A == nil || B == nil {
		return true
	}
	return A.Val == B.Val &&
		recursionIsSubStructure(A.Left, B.Left) &&
		recursionIsSubStructure(A.Right, B.Right)
}
