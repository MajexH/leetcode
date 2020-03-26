/**
 * 采用partition的方式来做
 * 这个方式是o(n)
 * @param {Number[]} nums 
 * @param {Number} k 
 */
function findTheKMinNumber(nums, k) {
  let start = 0, end = nums.length - 1
  let index = partition(nums, start, end)
  while (index !== k - 1) {
    if (index > k - 1) end = index - 1
    else if (index < k - 1) start = index + 1
    index = partition(nums, start, end)
  }
  return nums.slice(0, k)
}

/**
 * 这个方法是采用heap
 * @param {Number[]} nums 
 * @param {Number} k 
 */
function findTheKMinNumberWithHeap(nums, k) {
  let heap = new Heap(k, (a, b) => a - b)
  for (let num of nums) {
    if (heap.size() < k) {
      heap.push(num)
    } else if (heap.top() > num) {
      heap.data[0] = num
      heap.adjustFromTop()
    }
  }
  return heap.data
}

function Heap(capacity, fn) {
  this.data = []
  this.capacity = capacity
  this.fn = fn
}

Heap.prototype.top = function () {
  return this.data[0]
}

Heap.prototype.size = function () {
  return this.data.length
}

Heap.prototype.push = function (val) {
  this.data.push(val)
  this.adjustFromBottom()
}

Heap.prototype.adjustFromTop = function() {
  let father = 0, child = 2 * father + 1
  while (child < this.data.length) {
    if (child < this.data.length - 1 && this.fn(this.data[child], this.data[child + 1]) < 0) child++
    if (this.fn(this.data[father], this.data[child]) > 0) break
    swap(this.data, father, child)
    father = child
    child = 2 * father + 1
  }
}

Heap.prototype.adjustFromBottom = function() {
  let child = this.data.length - 1, father = Math.ceil((child - 2) / 2)
  while (child > 0 && this.fn(this.data[child], this.data[father]) > 0) {
    swap(this.data, child, father)
    child = father
    father = Math.ceil((child - 2) / 2)
  }
}

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
    while (nums[++i] < base) if (i === end) break
    while (nums[--j] > base) if (j === start) break
    if (i >= j) break
    swap(nums, i, j)
  }
  swap(nums, start, j)
  return j
}

function swap(nums, i, j) {
  let temp = nums[i]
  nums[i] = nums[j]
  nums[j] = temp
}

console.log(findTheKMinNumber([4,5,1,6,2,7,3,8], 5))
console.log(findTheKMinNumberWithHeap([4,5,1,6,2,7,3,8], 5))