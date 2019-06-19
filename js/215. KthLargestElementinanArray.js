/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
  mergetSort(nums, 0, nums.length - 1)
  return nums[k - 1]
};

/**
 * 
 * @param {number[]} nums 
 * @param {number} start 
 * @param {number} end 
 */
function mergetSort(nums, start, end) {
  if (start >= end) return
  let mid = Math.floor((start + end) / 2)
  mergetSort(nums, start, mid)
  mergetSort(nums, mid + 1, end)
  merge(nums, start, mid, end)
}

function merge(nums, start, mid, end) {
  let temp = [], pre = start, last = mid + 1
  while (pre <= mid && last <= end) {
    if (nums[pre] > nums[last]) {
      temp.push(nums[pre++])
    } else {
      temp.push(nums[last++])
    }
  }
  while (pre <= mid) {
    temp.push(nums[pre++])
  }
  while (last <= end) {
    temp.push(nums[last++])
  }
  for (let i = start, j = 0; i <= end; i++, j++) {
    nums[i] = temp[j]
  }
}

console.log(findKthLargest([3,2,3,1,2,4,5,5,6], 9))