/**
 * 这个地方的目的是为了保障当第i和j个数交换的时候，保证其[i,j-1]是没有与j相同的数的
 * 因为如[1, 2, 2]这组数 当第一个1和第三个2交换时 会发现之前第一个1和第二个2已经交换过了 而且出来的排列完全相同
 * 因此这组数不用再交换了 同理递归时对所有的子列也进行相同的判断
 * @param {Array} list 
 * @param {Number} i 
 * @param {Number} j 
 */
function canSwap(list, i, j) {
  for (let start = i; start < j; start++) {
    if (list[start] === list[j]) {
      return false
    }
  }
  return true
}

/**
 * 
 * @param {Array} list 
 * @param {Number} start indicate the start position of the array 
 * @param {Array} result
 */
function perm(list, start, result) {
  // stop
  if (start === list.length - 1) {
    let temp = JSON.parse(JSON.stringify(list));
    result.push(temp)
    return
  }
  for (let i = start; i < list.length; i++) {
    if (canSwap(list, start, i)) {
      // swap
      swap(list, start, i);
      perm(list, start + 1, result);
      // 交换回来
      swap(list, start, i)
    }
  }
}

/**
 * 
 * @param {Array} nums 
 * @param {Number} i 
 * @param {Number} j 
 */
function swap(nums, i, j) {
  let temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  let result = []
  perm(nums, 0, result);
  return result;
};

console.log(permuteUnique([1, 2 ,2]))