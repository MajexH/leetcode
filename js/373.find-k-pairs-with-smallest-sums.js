/*
 * @lc app=leetcode id=373 lang=javascript
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
function _swap(array, i, j) {
  let temp = array[i]
  array[i] = array[j]
  array[j] = temp
}

function Heap(capacity, compareFn) {
  this.capacity = capacity
  this.data = []
  this.compareFn = compareFn
}

Heap.prototype.push = function(val) {
  if (this.data.length < this.capacity) {
    this.data.push(val)
    this._adjustFromBottom()
  } else {
    if (this.compareFn(val, this.data[0])) {
      this.data[0] = val
      this._adjustFromTop()
    }
  }
}

Heap.prototype._adjustFromTop = function() {
  let i = 0, child = 2 * i + 1
  while (child < this.data.length) {
    if (child + 1 < this.data.length && this.compareFn(this.data[child], this.data[child + 1])) child++
    if (this.compareFn(this.data[child], this.data[i])) break
    _swap(this.data, child, i)
    i = child
    child = 2 * i + 1
  }
}

Heap.prototype._adjustFromBottom = function() {
  let i = this.data.length - 1, father = Math.ceil((i - 2) / 2)
  while (father >= 0 && this.compareFn(this.data[father], this.data[i])) {
    _swap(this.data, father, i)
    i = father
    father = Math.ceil((i - 2) / 2)
  }
}
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number[][]}
 */
var kSmallestPairs = function(nums1, nums2, k) {
  // 维护一个大顶堆
  let compareFn = (pre, last) => {
    if (pre[0] + pre[1] - last[0] - last[1] > 0) return false
    else return true
  }
  let heap = new Heap(k, compareFn)
  for (let i = 0; i < nums1.length; i++) {
    for (let j = 0; j < nums2.length; j++) {
      heap.push([nums1[i], nums2[j]])
    }
  }
  return heap.data
};
// @lc code=end

console.log(kSmallestPairs([-10,-4,0,0,6], [3,5,6,7,8,100],10))