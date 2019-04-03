function binarySearch(start, end, target) {
  let i = start, j = end;
  while (i <= j) {
    let mid = Math.floor((i + j) / 2);
    if (target > mid * mid) {
      i = mid;
    } else if (target < mid * mid){
      j = mid;
    }
    else {
      return mid;
    }
    if (i + 1 === j) {
      return i;
    }
  }
}

/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  if (x === 0) return 0
  return binarySearch(1, x, x);
};

console.log(mySqrt(5))