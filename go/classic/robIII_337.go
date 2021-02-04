package classic

// robTree rob 的是一个树形结构 两个房间如果直接相连的话 就无法 rob
func robTree(root *TreeNode) int {
	var res int
	recursionRobTree(root, &res)
	return res
}

// recursionRobTree 返回值是 rob 当前这个 root 还不 不 rob 的值
func recursionRobTree(root *TreeNode, res *int) (int, int) {
	if root == nil {
		return 0, 0
	}

	leftRob, leftNotRob := recursionRobTree(root.Left, res)
	rightRob, rightNotRob := recursionRobTree(root.Right, res)

	// 如果 rob 当前这个root 节点的话 意味着 两个节点都不可以rob
	rob := leftNotRob + rightNotRob + root.Val
	// 如果 不 rob 这个节点的话 子节点可以 rob 也可以不 rob
	notRob := getArrayMax(leftRob+rightRob, rightRob+leftNotRob, rightNotRob+leftRob, rightNotRob+leftNotRob)
	*res = max(*res, rob)
	*res = max(*res, notRob)
	return rob, notRob
}

func getArrayMax(nums ...int) int {
	if len(nums) == 0 {
		return -1
	}
	res := nums[0]
	for _, num := range nums {
		res = max(res, num)
	}
	return res
}
