package classic

type lruNode struct {
	pre  *lruNode
	next *lruNode
	key  int
	val  int
}

func (node *lruNode) delete() {
	if node.pre != nil {
		node.pre.next = node.next
		if node.next != nil {
			node.next.pre = node.pre
		}
	}
}

type LRUCache struct {
	head     *lruNode
	last     *lruNode
	memo     map[int]*lruNode
	capacity int
	number   int
}

func Constructor(capacity int) LRUCache {
	res := LRUCache{
		head:     new(lruNode),
		last:     new(lruNode),
		capacity: capacity,
		memo:     make(map[int]*lruNode),
	}
	res.head.next = res.last
	res.last.pre = res.head
	return res
}

func (this *LRUCache) insert(node *lruNode) {
	node.pre = this.head
	node.next = this.head.next
	this.head.next.pre = node
	this.head.next = node
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.memo[key]; ok {
		node.delete()
		this.insert(node)
		return node.val
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	// 更新操作 更新也要移动到最前面
	if node, ok := this.memo[key]; ok {
		node.val = value
		node.delete()
		this.insert(node)
		return
	}
	node := &lruNode{
		pre:  nil,
		next: nil,
		key:  key,
		val:  value,
	}
	if this.number == this.capacity {
		if this.last.pre != this.head {
			delete(this.memo, this.last.pre.key)
			// 删除最远的
			this.last.pre.delete()
		} else {
			return
		}
	} else {
		this.number++
	}
	this.insert(node)
	this.memo[key] = node
}
