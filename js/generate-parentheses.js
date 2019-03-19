function back(n, temp, res, counter1, counter2) {
  if (temp.length === 2 * n) {
    res.push(temp);
    return;
  }
  if (counter1 < n) {
    back(n, temp + '(', res, counter1 + 1, counter2);
  }
  if (counter2 < counter1) {
    back(n, temp + ')', res, counter1, counter2 + 1);
  }
}
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let res = [];
  back(n, '', res, 0, 0);
  return res;
};

console.log(generateParenthesis(3));