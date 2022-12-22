<p>给你&nbsp;<code>nums</code>&nbsp;，它是一个大小为&nbsp;<code>2 * n</code>&nbsp;的正整数数组。你必须对这个数组执行 <code>n</code>&nbsp;次操作。</p>

<p>在第&nbsp;<code>i</code>&nbsp;次操作时（操作编号从 <strong>1</strong>&nbsp;开始），你需要：</p>

<ul> 
 <li>选择两个元素&nbsp;<code>x</code> 和&nbsp;<code>y</code>&nbsp;。</li> 
 <li>获得分数&nbsp;<code>i * gcd(x, y)</code>&nbsp;。</li> 
 <li>将&nbsp;<code>x</code>&nbsp;和&nbsp;<code>y</code> 从&nbsp;<code>nums</code>&nbsp;中删除。</li> 
</ul>

<p>请你返回 <code>n</code>&nbsp;次操作后你能获得的分数和最大为多少。</p>

<p>函数&nbsp;<code>gcd(x, y)</code>&nbsp;是&nbsp;<code>x</code> 和&nbsp;<code>y</code>&nbsp;的最大公约数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [1,2]
<b>输出：</b>1
<b>解释：</b>最优操作是：
(1 * gcd(1, 2)) = 1
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [3,4,6,8]
<b>输出：</b>11
<b>解释：</b>最优操作是：
(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums = [1,2,3,4,5,6]
<b>输出：</b>14
<b>解释：</b>最优操作是：
(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 7</code></li> 
 <li><code>nums.length == 2 * n</code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>数学</li><li>动态规划</li><li>回溯</li><li>状态压缩</li><li>数论</li></div></div><br><div><li>👍 58</li><li>👎 0</li></div>