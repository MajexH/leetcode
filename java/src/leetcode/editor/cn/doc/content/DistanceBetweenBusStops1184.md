<p>环形公交路线上有&nbsp;<code>n</code>&nbsp;个站，按次序从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n - 1</code>&nbsp;进行编号。我们已知每一对相邻公交站之间的距离，<code>distance[i]</code>&nbsp;表示编号为&nbsp;<code>i</code>&nbsp;的车站和编号为&nbsp;<code>(i + 1) % n</code>&nbsp;的车站之间的距离。</p>

<p>环线上的公交车都可以按顺时针和逆时针的方向行驶。</p>

<p>返回乘客从出发点&nbsp;<code>start</code>&nbsp;到目的地&nbsp;<code>destination</code>&nbsp;之间的最短距离。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/08/untitled-diagram-1.jpg" style="height: 240px; width: 388px;" /></p>

<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 1
<strong>输出：</strong>1
<strong>解释：</strong>公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。</pre>

<p>&nbsp;</p>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/08/untitled-diagram-1-1.jpg" style="height: 240px; width: 388px;" /></p>

<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 2
<strong>输出：</strong>3
<strong>解释：</strong>公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
</pre>

<p>&nbsp;</p>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/09/08/untitled-diagram-1-2.jpg" style="height: 240px; width: 388px;" /></p>

<pre><strong>输入：</strong>distance = [1,2,3,4], start = 0, destination = 3
<strong>输出：</strong>4
<strong>解释：</strong>公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n&nbsp;&lt;= 10^4</code></li> 
 <li><code>distance.length == n</code></li> 
 <li><code>0 &lt;= start, destination &lt; n</code></li> 
 <li><code>0 &lt;= distance[i] &lt;= 10^4</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 85</li><li>👎 0</li></div>