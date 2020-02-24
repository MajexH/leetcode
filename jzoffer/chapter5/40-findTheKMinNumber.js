const Heap = require('../../data-structure/heap');

/**
 * 找到一个数组里面的K个最小的数
 * 第一个想法就是维护一个大顶堆
 * 去遍历一个数的时候 同时维护一个K个大小的大顶堆 
 * 如果大顶堆的数量超过了K 则直接替换掉头部的数儿即可 
 * 这样其时间效率就变成了O(nlogk)
 * 因为采用的是完全二叉树实现 不是红黑树 因此这儿的时间效率会大于 O(nlogk)
 * @param {Array} array 
 * @returns {Array}
 */
function findtheKSmalNumber(array, k) {
  let heap = new Heap(k, (a, b) => a - b)
  for (let item of array) {
    if (heap.length() < k || item < heap.top()) {
      heap.add(item)
    }
  }
  console.log(heap)
  return heap.toString()
}

console.log(findtheKSmalNumber([4,5,1,6,2,7,3,8], 4))