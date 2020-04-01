/*
 * @lc app=leetcode id=215 lang=javascript
 *
 * [215] Kth Largest Element in an Array
 */
/**
 * 用小顶堆来做
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
  let array = new heap(k, (a, b) => b - a)
  for (let item of nums) {
    if (array.length() < k || array.top() <= item) {
      array.add(item)
    }
  }
  return array.top()
};
// @lc code=start
/**
 * 用小顶堆来做
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
  let start = 0, end = nums.length - 1
  let index = partition(nums, start, end)
  while (index !== k - 1) {
    if (index > k - 1) {
      end = index - 1
    } else {
      start = index + 1
    }
    index = partition(nums, start, end)
  }
  return nums[k - 1]
};

/**
 * 
 * @param {Number[]} nums 
 * @param {Number} start 
 * @param {Number} end 
 */
function partition(nums, start, end) {
  let base = nums[start]
  let i = start, j = end + 1
  while (true) {
    while (nums[++i] > base) if (i === end) break
    while (nums[--j] < base) if (j === start) break
    if (i >= j) break
    _swap(nums, i, j)
  }
  _swap(nums, start, j)
  return j
}

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
    // 根据comparFn
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

// @lc code=end
// array.array[array.length() - 1] <= item || 
console.log(findKthLargest([3,2,3,1,2,4,5,5,6], 4))