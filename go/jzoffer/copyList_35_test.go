package jzoffer

import (
	"testing"
)

func Test_copyRandomList(t *testing.T) {
	node := &Node{
		Val: 1,
		Next: &Node{
			Val:    2,
			Next:   nil,
			Random: nil,
		},
		Random: nil,
	}
	node.Random = node.Next
	node.Next.Random = node.Next

	res := copyRandomList(node)
	t.Log(res)
}
