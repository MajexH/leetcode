package classic

import (
	"testing"
)

func TestConstructorForMinStack(t *testing.T) {
	a := ConstructorForMinStack()
	a.Push(-2)
	a.Push(0)
	a.Push(-3)
	t.Log(a.Min())
	a.Pop()
	t.Log(a.Top())
	t.Log(a.Min())
}
