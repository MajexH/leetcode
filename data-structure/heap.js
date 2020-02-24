function _checkNone(val) {
  return val === null || val === undefined
}

/**
 * 
 * @param {Array} array 
 * @param {number} i 
 * @param {number} j 
 */
function _swap(array, i, j) {
  let temp = array[i]
  array[i] = array[j]
  array[j] = temp
}

/**
 * number是这个heap能够装下的最大大小
 * @param {number} capacity 默认大小为 Number.MAX_SAFE_INTEGER
 * @param {Function} comparFn 
 */
function heap(capacity, comparFn) {
  if (_checkNone(capacity)) capacity = Number.MAX_SAFE_INTEGER
  this.array = []
  if (_checkNone(comparFn)) comparFn = (a, b) => a - b
  this.comparFn = comparFn

  this.capacity = capacity
  this.size = 0
}

heap.prototype.length = function() {
  return this.size
}

heap.prototype.add = function(val) {
  if (this.size < this.capacity) {
    // 直接加入堆
    this.array[this.size] = val
    this.size++
    this._adjustHeapFromBottom()
  } else {
    // 超过了堆的大小 弹出顶部的一个
    // 直接赋值弹出顶部的值
    this.array[0] = val
    this._adjustHeapFromTop()
  }

}

// 弹出heap的顶部的值
heap.prototype.pop = function() {
  // 数量不够
  if (this.size === 0) return
  // 让顶部的值 跟尾部的值交换
  _swap(this.array, 0, this.size - 1)
  let res = this.array[this.size - 1]
  this.size--
  this._adjustHeapFromTop()
  return res
}

// 从顶部开始调整
heap.prototype._adjustHeapFromTop = function() {
  let i = 0, child = 2 * i + 1
  while (child < this.size) {
    // 根据compareFn来更新
    if (child < this.size - 1 && this.comparFn(this.array[child + 1], this.array[child]) > 0) child++
    // 终止
    if (this.comparFn(this.array[i], this.array[child]) > 0) break
    _swap(this.array, i, child)
    i = child
    child = 2 * i + 1
  }
}

// 从底部开始调整
heap.prototype._adjustHeapFromBottom = function() {
  let j = this.size - 1, father = Math.floor(j / 2) - (j % 2 === 0 ?  1 : 0)
  // 最后一位 跟其父节点比较 
  while (j > 0 && this.comparFn(this.array[j], this.array[father]) > 0) {
    _swap(this.array, j, father)
    j = father
    father = Math.floor(j / 2) - (j % 2 === 0 ?  1 : 0)
  }
}

heap.prototype.toString = function() {
  return this.array.slice(0, this.size)
}

heap.prototype.top = function() {
  return this.array[0]
}

module.exports = heap
