/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
  intervals.sort((a, b) => { return a[0] - b[0] })
  let result = []
  for (let i = 0; i < intervals.length; i++) {
    if (i === 0) {
      result.push(intervals[i])
      continue;
    }
    let pre = result.pop(), current = intervals[i]
    if (pre[1] >= current[0]) {
      result.push([pre[0], current[1] > pre[1] ? current[1] : pre[1]])
    } else {
      result.push(pre, current)
    }
  }
  return result
};

console.log(merge([[1,4],[2,3]]))