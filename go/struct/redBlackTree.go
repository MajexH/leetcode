package _struct

const (
	black = iota
	red
)

// 红黑树
type RBTreeNode struct {
	key, val    int
	color       int
	left, right *RBTreeNode
}

func Put(node *RBTreeNode, key, val int) *RBTreeNode {
	if node == nil {
		return &RBTreeNode{
			key:   key,
			val:   val,
			color: red,
			left:  nil,
			right: nil,
		}
	}
	if node.key == key {
		node.val = val
		return node
	}
	if val < node.val {
		node.left = Put(node.left, key, val)
	} else {
		node.right = Put(node.right, key, val)
	}
	// 这个地方会对应加上了之后的几种情况 从底向上更改节点的 红色状态
	if node.right.isRed() && !node.left.isRed() {
		node = node.rotateLeft()
	}
	if node.left.isRed() && node.left.left.isRed() {
		node = node.rotateRight()
	}
	if node.right.isRed() && node.left.isRed() {
		// 注意 color 的继承和变化
		node.changeColor(red)
		node.left.changeColor(black)
		node.right.changeColor(black)
	}
	return node
}

// 将右节点为红色时 旋转一下
func (node *RBTreeNode) rotateLeft() *RBTreeNode {
	right := node.right
	node.right = right.left
	right.left = node
	right.color = node.color
	// 注意 color 的继承和变化
	node.color = red
	return right
}

// 将左节点为黑色时旋转一下
func (node *RBTreeNode) rotateRight() *RBTreeNode {
	left := node.left
	node.left = left.right
	left.right = node
	left.color = node.color
	// 注意 color 的继承和变化
	node.color = red
	return left
}

func (node *RBTreeNode) isRed() bool {
	if node == nil {
		return false
	}
	return node.color == red
}

func (node *RBTreeNode) changeColor(color int) {
	node.color = color
}
