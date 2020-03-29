function MaxQueue() {
  this.data = []
  this.maxs = []
}
// max必须是o(1)的
MaxQueue.prototype.max = function () {
  if (this.maxs.length > 0)
    return this.maxs[0].number
  else
    return null
}

MaxQueue.prototype.shift = function () {
  if (this.data.length === 0) return null
  let remember = this.data.shift()
  // 如果最大的数字判处了
  if (remember.index === this.maxs[0].index)
    this.maxs.shift()
  this.data.shift()
}

MaxQueue.prototype.push = function (number) {
  // 当一个数字进入的时候 需要找到其在max数组中的位置
  // 并把之后的次小都弹出掉 因为有它 之前的次小都不可能 因为它后入队列
  while (this.maxs.length > 0 && this.maxs[this.maxs.length - 1].number <= number) {
    this.maxs.pop()
  }
  this.maxs.push({index: this.data.length - 1, number: number})
  this.data.push({index: this.data.length - 1, number: number})
}

let test = new MaxQueue()
console.log(test.max())
console.log(test.push(1))
console.log(test.max())
console.log(test.push(2))
console.log(test.max())
test.shift()
console.log(test.max())
test.push(3)
console.log(test.max())