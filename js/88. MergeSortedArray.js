/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge1 = function(nums1, m, nums2, n) {
  // i, j 是分别是两个数组的指针
  let i = 0, j = 0;
  while (j < n) {
    // i必须要小于原始的长度 才能说nums!==0有效
    while (nums1[i] < nums2[j] && !(i >= m && nums1[i] === 0)) { // 后面那个表示其不是补位的0
      i++;
    }
    for (let count = m - 1; count >= i; count--) {
      nums1[count + 1] = nums1[count]
    }
    nums1[i] = nums2[j];
    i++;
    j++;
    m++;
  }
};

var merge = function(nums1, m, nums2, n) {
  let i = m - 1, j = n - 1, k = m + n - 1;
  while (i > -1 && j > -1) {
    nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]
  }
  while (j > -1) {
    nums1[k--] = nums2[j--];
  }
}

let a = [-1,0,0,0,3,0,0,0,0,0,0]
let b = [-1,-1,0,0,1,2]
merge(a, 5, b, 6)
console.log(a)