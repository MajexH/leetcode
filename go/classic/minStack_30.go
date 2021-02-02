package classic

import (
	"container/list"
)

type MinStack struct {
	data *list.List
	min  *list.List
}

/** initialize your data structure here. */
func ConstructorForMinStack() MinStack {
	return MinStack{
		data: list.New(),
		min:  list.New(),
	}
}

func (this *MinStack) Push(x int) {
	if this.min.Len() == 0 {
		this.min.PushBack(x)
		this.data.PushBack(x)
		return
	}
	if x < this.min.Back().Value.(int) {
		this.min.PushBack(x)
	} else {
		this.min.PushBack(this.min.Back().Value)
	}
	this.data.PushBack(x)
}

func (this *MinStack) Pop() {
	if this.data.Len() > 0 {
		this.data.Remove(this.data.Back())
		this.min.Remove(this.min.Back())
	}
}

func (this *MinStack) Top() int {
	if this.data.Len() > 0 {
		return this.data.Back().Value.(int)
	}
	return -1
}

func (this *MinStack) Min() int {
	if this.min.Len() > 0 {
		return this.min.Back().Value.(int)
	}
	return -1
}
