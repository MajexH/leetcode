/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  // 为了防止数字全部相同的情况下无法处理的问题
  // 因为下面的循环 处理的逻辑 主要是在得到了下一个不同数字的位置后移动
  nums.push(Number.MAX_SAFE_INTEGER)
  // pre end分别表示相同数字的首和尾
  let pre = 0, end = 1
  while (end < nums.length) {
    if (nums[pre] === nums[end]) {
      end++;
      continue;
    }
    // 说明之间的数字小于等于两个
    if (end - pre + 1 <= 2) {
      pre = end
      end++;
      continue;
    }
    // 说明中间出现了重复数字大于等于2的情况的
    let i = pre + 2, j = end;
    for (; j < nums.length; i++, j++) {
      nums[i] = nums[j]
    }
    for (; i < j; i++) {
      nums.pop()
    }
    // 处理完了重复数字 需要重新定位pre end
    pre = pre + 2
    end = pre + 1
  }
  // 弹出最开始的数字
  nums.pop()
  return nums.length
};

console.log(removeDuplicates([1,1,1,1]))