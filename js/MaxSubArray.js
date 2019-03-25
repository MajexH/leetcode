var maxSubArray = function(nums) {
  let max = nums[0], pre = max;
  for (let i = 1; i < nums.length; i++) {
    pre = Math.max(pre + nums[i], nums[i]);
    max = Math.max(max, pre);
    console.log(pre, max);
  }
  return max;
};

maxSubArray([-2,1,-3,4,-1,2,1,-5,4])