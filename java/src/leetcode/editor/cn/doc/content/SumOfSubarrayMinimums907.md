<p>给定一个整数数组 <code>arr</code>，找到 <code>min(b)</code>&nbsp;的总和，其中 <code>b</code> 的范围为 <code>arr</code> 的每个（连续）子数组。</p>

<p>由于答案可能很大，因此<strong> 返回答案模 <code>10^9 + 7</code></strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,1,2,4]
<strong>输出：</strong>17
<strong>解释：
</strong>子数组为<strong> </strong>[3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [11,81,94,43,3]
<strong>输出：</strong>444
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= arr.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= arr[i] &lt;= 3 * 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p>

<div><div>Related Topics</div><div><li>栈</li><li>数组</li><li>动态规划</li><li>单调栈</li></div></div><br><div><li>👍 454</li><li>👎 0</li></div>