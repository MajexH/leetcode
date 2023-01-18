<p>给你一个数组&nbsp;<code>nums</code>&nbsp;，数组中只包含非负整数。定义&nbsp;<code>rev(x)</code>&nbsp;的值为将整数&nbsp;<code>x</code>&nbsp;各个数字位反转得到的结果。比方说&nbsp;<code>rev(123) = 321</code>&nbsp;，&nbsp;<code>rev(120) = 21</code>&nbsp;。我们称满足下面条件的下标对&nbsp;<code>(i, j)</code> 是&nbsp;<strong>好的</strong>&nbsp;：</p>

<ul> 
 <li><code>0 &lt;= i &lt; j &lt; nums.length</code></li> 
 <li><code>nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])</code></li> 
</ul>

<p>请你返回好下标对的数目。由于结果可能会很大，请将结果对&nbsp;<code>10<sup>9</sup> + 7</code>&nbsp;<b>取余</b>&nbsp;后返回。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums = [42,11,1,97]
<b>输出：</b>2
<b>解释：</b>两个坐标对为：
 - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums = [13,10,35,24,76]
<b>输出：</b>4
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>哈希表</li><li>数学</li><li>计数</li></div></div><br><div><li>👍 92</li><li>👎 0</li></div>