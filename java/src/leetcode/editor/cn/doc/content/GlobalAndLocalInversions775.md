<p>给你一个长度为 <code>n</code> 的整数数组 <code>nums</code> ，表示由范围 <code>[0, n - 1]</code> 内所有整数组成的一个排列。</p>

<p><strong>全局倒置</strong> 的数目等于满足下述条件不同下标对 <code>(i, j)</code> 的数目：</p>

<ul> 
 <li><code>0 &lt;= i &lt; j &lt; n</code></li> 
 <li><code>nums[i] &gt; nums[j]</code></li> 
</ul>

<p><strong>局部倒置</strong> 的数目等于满足下述条件的下标 <code>i</code> 的数目：</p>

<ul> 
 <li><code>0 &lt;= i &lt; n - 1</code></li> 
 <li><code>nums[i] &gt; nums[i + 1]</code></li> 
</ul>

<p>当数组 <code>nums</code> 中 <strong>全局倒置</strong> 的数量等于 <strong>局部倒置</strong> 的数量时，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,2]
<strong>输出：</strong>true
<strong>解释：</strong>有 1 个全局倒置，和 1 个局部倒置。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,0]
<strong>输出：</strong>false
<strong>解释：</strong>有 2 个全局倒置，和 1 个局部倒置。
</pre>

&nbsp;

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt; n</code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
 <li><code>nums</code> 是范围 <code>[0, n - 1]</code> 内所有数字组成的一个排列</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li></div></div><br><div><li>👍 157</li><li>👎 0</li></div>