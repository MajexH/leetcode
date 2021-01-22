package jzoffer

import "container/list"

type CQueue struct {
	queue1 *list.List
	queue2 *list.List
}

func Constructor() CQueue {
	return CQueue{
		queue1: list.New(),
		queue2: list.New(),
	}
}

func (cq *CQueue) AppendTail(value int) {
	cq.queue1.PushBack(value)
}

func (cq *CQueue) DeleteHead() int {
	if cq.queue2.Len() == 0 {
		for cq.queue1.Len() > 0 {
			cq.queue2.PushBack(cq.queue1.Remove(cq.queue1.Back()))
		}
	}
	if cq.queue2.Len() > 0 {
		return cq.queue2.Remove(cq.queue2.Back()).(int)
	}
	return -1
}

/**
 * Your CQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AppendTail(value);
 * param_2 := obj.DeleteHead();
 */
