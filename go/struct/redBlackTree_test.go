package _struct

import (
	"testing"
)

func TestPut(t *testing.T) {
	var node *RBTreeNode

	for i := 0; i <= 10; i++ {
		node = Put(node, i, i)
	}
	t.Log(node)
}
