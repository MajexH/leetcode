/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
  let result = {}
  nums.sort((a, b) => { return a - b })
  for (let i = 0; i < nums.length; i++) {
    if (i !== 0 && nums[i - 1] === nums[i]) continue
    let sum = target - nums[i]
    if (i === 0) {
      result = {
        abs: Math.abs(target - Number.MAX_SAFE_INTEGER), 
        val: Number.MAX_SAFE_INTEGER
      }
    }
    let front = i + 1, rear = nums.length - 1
    while (front < rear) {
      let temp = nums[front] + nums[rear]
      // 计算到target的距离
      if (result.abs > Math.abs(sum - temp)) {
        result = {
          abs: Math.abs(sum - temp), 
          val: target - sum + temp
        }
      }
      if (temp < sum) {
        front++
      } else if (temp > sum){
        rear--;
      } else {
        // equal
        return target
      }
    }
  }
  return result.val
};

console.log(threeSumClosest([0,2,1,-3], 1))

