var singleNumber = function(nums) {
  return (3 * ([...new Set(nums)].reduce((pre, current) => {
    return pre + current
  })) - nums.reduce((pre, current) => {
    return pre + current
  })) / 2
};

console.log(singleNumber([0,1,0,1,0,1,99]))