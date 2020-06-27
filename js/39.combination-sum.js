/*
 * @lc app=leetcode id=39 lang=javascript
 *
 * [39] Combination Sum
 */

// @lc code=start
/**
 * 
 * @param {number[]} candidates 
 * @param {number} target 
 * @param {Array} temp 
 * @param {Array} res 
 * @param {number} start
 */
function recursion(candidates, target, temp, res, start) {
  if (target < 0) {
    return;
  }
  if (target === 0) {
    res.push([...temp])
    return;
  }

  for (let i = start; i < candidates.length; i++) {
    temp.push(candidates[i])
    recursion(candidates, target - candidates[i], temp, res, i)
    temp.pop()
  }
}

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
  let res = []
  recursion(candidates, target, [], res, 0)
  return res
};
// @lc code=end

