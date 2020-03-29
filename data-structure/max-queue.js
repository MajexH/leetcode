// 使用两个 stack 来模拟 queue
// 能够在 o(1) 的时间内获取 queue 的值
function MaxQueue() {
  this.left = new MaxStack()
  this.right = new MaxStack()
}

MaxQueue.prototype.push = function (val) {
  this.left.push(val)
}

MaxQueue.prototype.shift = function () {
  if (this.right.length() === 0) {
    while (this.left.length() > 0) {
      this.right.push(this.left.pop())
    }
  }
  if (this.right.length() > 0)
    return this.right.pop()
  else
    return null
}

MaxQueue.prototype.max = function () {
  let leftMax = this.left.max(), rightMax = this.right.max()
  if (leftMax === null && rightMax === null) return null
  if (leftMax === null) return rightMax
  else if (rightMax === null) return leftMax
  else return Math.max(leftMax, rightMax)
}
