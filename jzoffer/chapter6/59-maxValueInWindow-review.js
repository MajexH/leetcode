/**
 * 给定一个数组 nums 和一个滑动窗口的大小 k
 * 求在滑动窗口中时 每个滑动窗口中的最大值
 * 实际上就是求一个队列在出一个数 如一个数值之后的 最大值
 * 由于可以使用 两个栈 来模拟队列 同时 栈可以在 o(1) 的时间内拿到最大值
 * 因此 可以基于以上四项来做
 * @param {Number[]} nums 
 * @param {Number} k 
 */
function getMaxValueInWindow(nums, k) {
  let queue = new MaxQueue(), res = []
  for (let i = 0; i < k; i++) {
    queue.push(nums[i])
  }
  res.push(queue.max())
  for (let i = k; i < nums.length; i++) {
    queue.shift()
    queue.push(nums[i])
    res.push(queue.max())
  }
  return res
}



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

function MaxStack() {
  this.data = []
  this.maxData = []
}

MaxStack.prototype.push = function (val) {
  this.data.push(val)
  if (this.maxData.length > 0) {
    if (this.maxData[this.maxData.length - 1] < val) {
      this.maxData.push(val)
    } else {
      this.maxData.push(this.maxData[this.maxData.length - 1])
    }
  } else {
    this.maxData.push(val)
  }
}

MaxStack.prototype.pop = function () {
  if (this.data.length > 0) {
    this.maxData.pop()
    return this.data.pop()
  } else {
    return null
  }
}

MaxStack.prototype.max = function () {
  if (this.maxData.length > 0) return this.maxData[this.maxData.length - 1]
  else return null
}

MaxStack.prototype.length = function () {
  return this.data.length
}

console.log(getMaxValueInWindow([2,3,4,2,6,2,5,1],3))