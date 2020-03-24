/**
 * 找到当前的nums数组中的 出现次数超过一半的数儿
 * 第一个方式采用一个 抵消 的算法
 * 也就是说 出现一半的数字 如果抵消完其它数儿出现的数字 
 * 仍然是还有剩余
 * @param {Number[]} nums 
 */
function findMajorityNumber1(nums) {
  let num = null, counter = 0
  for (let temp of nums) {
    if (counter === 0) {
      // 初始化 再每次counter 为0的时候 都令当前的number等于当前的遍历对象
      num = temp
      counter++
    } else if (temp === num) {
      // 相同数字 +1
      counter++
    } else {
      // 抵消
      counter--
    }
  }
  counter = 0
  // 验证
  for (let temp of nums) {
    if (temp === num) counter++
  }

  return counter >= Math.floor(nums.length / 2) ? num : null
}

/**
 * 第二种做法 根据partition函数来做
 * partition函数是快速排序里面的函数
 * 选定一个基准值 从左找到第一个大于他的值 从右找到第一个小于它的值
 * 交换
 * 因此 其返回的是 这个数 最后排序的时候 所在的位置
 * 而为了找到出现一半以上的数 其实只要找到排序后的 中间 一半位置 的数即可
 * @param {Number[]} nums 
 */
function findMajorityNumber2(nums) {
  let start = 0, end = nums.length - 1
  let mid = Math.floor(nums.length / 2), index = partition(nums, start, end)
  while (index !== mid) {
    if (index > mid) {
      end = index - 1
      index = partition(nums, start, end)
    } else {
      start = index + 1
      index = partition(nums, start, end)
    }
  }
  let num = nums[mid], counter = 0
  // 验证
  for (let temp of nums) {
    if (temp === num) counter++
  }
  console.log(nums)
  return counter >= Math.floor(nums.length / 2) ? num : null
}

/**
 * 
 * @param {Number[]} nums 
 */
function partition(nums, start, end) {
  // 以start为base
  let base = nums[start]
  let i = start, j = end + 1
  while (i < j) {
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

console.log(findMajorityNumber1([1,2,3,2,5,4]))
console.log(findMajorityNumber2([1,2,3,2,5,4,2,2,2]))