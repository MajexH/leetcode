/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
  let m = nums1.length, n = nums2.length, mid = (m + n - 1) / 2
  let i = 0, j = 0, counter = 0, divide = 0, sum = 0
  while (i < m || j < n) {
    if (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        number = nums1[i++]
      } else {
        number = nums2[j++]
      }
    } else if (i >= m && j < n) {
      number = nums2[j++]
    } else {
      number = nums1[i++]
    }
    if (counter === Math.floor(mid) || counter === Math.ceil(mid)) {
      sum += number
      divide++;
    }
    if (counter > Math.floor(mid)) {
      break;
    }
    counter++;
  }
  return sum / divide
};

let nums1 = [1, 2, 3], nums2 = [4, 5]
console.log(findMedianSortedArrays(nums1, nums2))