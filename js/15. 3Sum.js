/**
 * 采用递归的方式做的 被爆栈了
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum1 = function(nums) {
  let result = []
  backTrack(nums.sort(), [], 0, result, 0)
  return result
};

function backTrack(list, tempList, sum, result, start) {
  if (tempList.length > 3) {
    return 
  }
  if (sum === 0 && tempList.length === 3) {
    result.push(JSON.parse(JSON.stringify(tempList)))
    return
  }
  for (let i = start; i < list.length; i++) {
    if (i !== start && list[i] === list[i - 1]) continue; 
    tempList.push(list[i])
    backTrack(list, tempList, sum - list[i], result, i + 1)
    tempList.pop()
  }
}


/**
 * 采用非递归方式做
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  let result = []
  nums.sort((a, b) => { return a - b })
  for (let i = 0; i < nums.length; i++) {
    if (i !== 0 && nums[i - 1] === nums[i]) continue 
    let sum = -nums[i]
    let front = i + 1, end = nums.length - 1
    while (front < end) {
      let temp = nums[front] + nums[end]
      if (temp < sum) 
        front++;
      else if (temp > sum)
        end--;
      // 代表相等
      else {
        result.push([nums[i], nums[front], nums[end]])
        do {
          front++;
        } while (front < end && nums[front] === nums[front - 1]) 
        do {
          end--;
        } while (front < end && nums[end] === nums[end + 1]) 
      }
    }
  }
  return result
};

console.log(threeSum([-1,0,1,2,-1,-4]))