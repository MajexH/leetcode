// o(1) 获取stack的最大值的数据结构
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