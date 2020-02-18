/**
 * 实现一个栈
 * 其获取最小元素min 和 push pop操作均是 o(1) 的时间复杂度
 */
function MinStack() {
  // 保存每个状态中的最小值的位置
  this.minStack = []
  this.stack = []
}

MinStack.prototype.push = function (val) {
  // 保存val
  this.stack.push(val)
  if (this.minStack.length === 0 || val < this.stack[this.minStack[this.minStack.length - 1]]) {
    // 保存最小的位置
    this.minStack.push(this.stack.length - 1)
  } else {
    // 要不然保存上一个最小的状态
    this.minStack.push(this.minStack[this.minStack.length - 1])
  }
}

MinStack.prototype.pop = function () {
  this.minStack.pop()
  return this.stack.pop()
}

MinStack.prototype.min = function() {
  if (this.minStack.length > 0)
    return this.stack[this.minStack[this.minStack.length - 1]]
  return null
}

let stack = new MinStack()
stack.push(3)
console.log(stack.min())
stack.push(4)
console.log(stack.min())
stack.push(2)
console.log(stack.min())
stack.push(1)
console.log(stack.min())

stack.pop()
console.log(stack.min())
stack.pop()
console.log(stack.min())