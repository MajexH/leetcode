let largest;
/**
 * 使用这种方法会超时 因为 其实他相当于遍历了所有的可能结果 并把所有的可能结果进行了比较 然而这道题 一个sort就完了 只需要把越大的数 往前面排序即可
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber1 = function(nums) {
  largest = '0'
  recursion(nums, 0)
  return formatResult(largest)
};

/**
 * 
 * @param {number[]} nums 
 * @param {number} start
 */
function recursion(nums, start) {
  if (start === nums.length - 1) {
    let temp = nums.join('')
    if (compare(largest, temp) === 2) largest = temp
    return
  }
  for (let i = start; i < nums.length; i++) {
    swap(nums, i, start)
    // 从start+1开始时因为 每个下一个循环都是当前循环的开始的下一个数开始
    // 也就是start与i交换之后 然后要考察从start的下一位开始的所有结果
    recursion(nums, start + 1)
    swap(nums, i, start)
  }
}

function formatResult(res) {
  for (let i = 0; i < res.length; i++) {
    if (res[i] !== '0') {
      return res.slice(i, res.length)
    }
  }
  return '0'
}

/**
 * 
 * @param {number[]} nums 
 * @param {number} i 
 * @param {number} j 
 */
function swap(nums, i, j) {
  let temp = nums[i]
  nums[i] = nums[j]
  nums[j] = temp
}

/**
 * 
 * @param {String} str1 
 * @param {String} str2 
 */
function compare(str1, str2) {
  if (str1 === '0') return 2 
  for(let i = 0; i < str1.length; i++) {
    if (Number.parseInt(str1[i]) > Number.parseInt(str2[i])) {
      return 1
    } 
    if (Number.parseInt(str1[i]) < Number.parseInt(str2[i])) {
      return 2
    }
  }
  return 3
}

/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
  nums.sort((a, b) => { 
    return (b + '' + a) - (a + '' + b) 
  })
  let res = '';
  for (let item of nums) {
    res += item
  }
  return formatResult(res)
};


console.log(largestNumber([1,2,3,4,5]))