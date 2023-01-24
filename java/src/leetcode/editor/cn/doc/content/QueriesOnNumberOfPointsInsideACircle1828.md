<p>给你一个数组&nbsp;<code>points</code>&nbsp;，其中&nbsp;<code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>&nbsp;，表示第&nbsp;<code>i</code>&nbsp;个点在二维平面上的坐标。多个点可能会有 <strong>相同</strong>&nbsp;的坐标。</p>

<p>同时给你一个数组&nbsp;<code>queries</code>&nbsp;，其中&nbsp;<code>queries[j] = [x<sub>j</sub>, y<sub>j</sub>, r<sub>j</sub>]</code>&nbsp;，表示一个圆心在&nbsp;<code>(x<sub>j</sub>, y<sub>j</sub>)</code>&nbsp;且半径为&nbsp;<code>r<sub>j</sub></code><sub>&nbsp;</sub>的圆。</p>

<p>对于每一个查询&nbsp;<code>queries[j]</code>&nbsp;，计算在第 <code>j</code>&nbsp;个圆 <strong>内</strong>&nbsp;点的数目。如果一个点在圆的 <strong>边界上</strong>&nbsp;，我们同样认为它在圆&nbsp;<strong>内</strong>&nbsp;。</p>

<p>请你返回一个数组<em>&nbsp;</em><code>answer</code>&nbsp;，其中<em>&nbsp;</em><code>answer[j]</code>是第&nbsp;<code>j</code>&nbsp;个查询的答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/25/chrome_2021-03-25_22-34-16.png" style="width: 500px; height: 418px;"> <pre><b>输入：</b>points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
<b>输出：</b>[3,2,2]
<b>解释：</b>所有的点和圆如上图所示。
queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
</pre> </img>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/25/chrome_2021-03-25_22-42-07.png" style="width: 500px; height: 390px;"> <pre><b>输入：</b>points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
<b>输出：</b>[2,3,2,4]
<b>解释：</b>所有的点和圆如上图所示。
queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
</pre> </img>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= points.length &lt;= 500</code></li> 
 <li><code>points[i].length == 2</code></li> 
 <li><code>0 &lt;= x<sub>​​​​​​i</sub>, y<sub>​​​​​​i</sub> &lt;= 500</code></li> 
 <li><code>1 &lt;= queries.length &lt;= 500</code></li> 
 <li><code>queries[j].length == 3</code></li> 
 <li><code>0 &lt;= x<sub>j</sub>, y<sub>j</sub> &lt;= 500</code></li> 
 <li><code>1 &lt;= r<sub>j</sub> &lt;= 500</code></li> 
 <li>所有的坐标都是整数。</li> 
</ul>

<div><div>Related Topics</div><div><li>几何</li><li>数组</li><li>数学</li></div></div><br><div><li>👍 50</li><li>👎 0</li></div>