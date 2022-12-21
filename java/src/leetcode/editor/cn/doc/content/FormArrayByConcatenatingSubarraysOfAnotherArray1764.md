<p>给你一个长度为 <code>n</code>&nbsp;的二维整数数组&nbsp;<code>groups</code>&nbsp;，同时给你一个整数数组&nbsp;<code>nums</code>&nbsp;。</p>

<p>你是否可以从 <code>nums</code>&nbsp;中选出 <code>n</code>&nbsp;个 <strong>不相交</strong> 的子数组，使得第 <code>i</code>&nbsp;个子数组与 <code>groups[i]</code>&nbsp;（下标从 <strong>0</strong>&nbsp;开始）完全相同，且如果&nbsp;<code>i &gt; 0</code>&nbsp;，那么第&nbsp;<code>(i-1)</code>&nbsp;个子数组在 <code>nums</code>&nbsp;中出现的位置在第 <code>i</code>&nbsp;个子数组前面。（也就是说，这些子数组在 <code>nums</code>&nbsp;中出现的顺序需要与 <code>groups</code> 顺序相同）</p>

<p>如果你可以找出这样的 <code>n</code> 个子数组，请你返回&nbsp;<code>true</code> ，否则返回&nbsp;<code>false</code>&nbsp;。</p>

<p>如果不存在下标为 <code>k</code>&nbsp;的元素 <code>nums[k]</code>&nbsp;属于不止一个子数组，就称这些子数组是 <strong>不相交</strong> 的。子数组指的是原数组中连续元素组成的一个序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
<b>输出：</b>true
<b>解释：</b>你可以分别在 nums 中选出第 0 个子数组 [1,-1,0,<strong>1,</strong><strong>-1,</strong><strong>-1</strong>,3,-2,0] 和第 1 个子数组 [1,-1,0,1,-1,-1,<strong>3,</strong><strong>-2,0</strong>] 。
这两个子数组是不相交的，因为它们没有任何共同的元素。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
<b>输出：</b>false
<strong>解释：</strong>选择子数组 [<strong>1,2,3,4</strong>,10,-2] 和 [1,2,3,4,<strong>10,-2</strong>] 是不正确的，因为它们出现的顺序与 groups 中顺序不同。
[10,-2] 必须出现在 [1,2,3,4] 之前。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
<b>输出：</b>false
<strong>解释：</strong>选择子数组 [7,7,<strong>1,2,3</strong>,4,7,7] 和 [7,7,1,2,<strong>3,4</strong>,7,7] 是不正确的，因为它们不是不相交子数组。
它们有一个共同的元素 nums[4] （下标从 0 开始）。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>groups.length == n</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>3</sup></code></li> 
 <li><code>1 &lt;= groups[i].length, sum(groups[i].length) &lt;= 10<sup><span style="">3</span></sup></code></li> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>3</sup></code></li> 
 <li><code>-10<sup>7</sup> &lt;= groups[i][j], nums[k] &lt;= 10<sup>7</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>字符串匹配</li></div></div><br><div><li>👍 52</li><li>👎 0</li></div>