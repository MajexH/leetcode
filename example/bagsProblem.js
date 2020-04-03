/**
 * 这个是完全背包 每个物品 可以拿无限次
 * @param {Number[]} values 
 * @param {Number[]} weights 
 * @param {Number} capacity 
 */
function completeBag(values, weights, capacity) {
  let dp = Array(capacity + 1);
  dp[0] = 0
  for (let i = 1; i <= capacity; i++) {
    let max = 0
    // 因为这儿循环的时候 可以再去访问之前已经访问的weight[j]
    for (let j = 0; j < weights.length; j++) {
      if (i >= weights[j])
        max = Math.max(max, dp[i - weights[j]] + values[j])
    }
    dp[i] = max
  }
  console.log(dp)
  return dp[capacity]
}

/**
 * 这个是01背包 每个物品 可以拿一次
 * @param {Number[]} values 
 * @param {Number[]} weights 
 * @param {Number} capacity 
 */
function zeroOneBag(values, weights, capacity) {
  let dp = Array(capacity + 1).fill(0)
  dp[0] = 0
  for (let j = 0; j < weights.length; j++) {
    // dp其实保留了上一次 预算的结果 即 dp[i - 1][j] 的结果
    // 因此 找个地方可以用 dp[i - 1][j] 来直接转化到dp[i]
    for (let i = capacity; i >= weights[j]; i--) {
      dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j])
    }
  }
  console.log(dp)
  return dp[capacity]
}

console.log(zeroOneBag([6,10,12],[1,2,3],5))
console.log(completeBag([6,10,12],[1,2,3],5))