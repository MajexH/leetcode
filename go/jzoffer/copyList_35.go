package jzoffer

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

// 下面的一个方法太麻烦 需要一个 memo 来保存 这次不用 memo 来保存
func copyRandomList(head *Node) *Node {
	rem := head

	// copy 节点到原始的 链接上
	for head != nil {
		node := &Node{Val: head.Val}
		node.Next = head.Next
		head.Next = node
		head = node.Next
	}

	// copy random
	head = rem
	for head != nil {
		if head.Random != nil {
			head.Next.Random = head.Random.Next
		}
		head = head.Next.Next
	}
	// copy 到新节点上 同时删除中间新增的原始节点
	newNode := new(Node)
	res := newNode
	head = rem

	for head != nil {
		newNode.Next = head.Next
		head.Next = head.Next.Next
		head = head.Next
		newNode = newNode.Next
	}
	return res.Next
}

func copyRandomListWithMemo(head *Node) *Node {
	cp := new(Node)
	rm := cp
	memo := make(map[*Node]*Node)

	mv := head
	for mv != nil {
		cp.Next = &Node{
			Val:    mv.Val,
			Next:   nil,
			Random: nil,
		}
		memo[mv] = cp.Next
		mv = mv.Next
		cp = cp.Next
	}

	cp = rm.Next
	mv = head
	for mv != nil {
		cp.Random = memo[mv.Random]
		mv = mv.Next
		cp = cp.Next
	}

	return rm.Next
}
