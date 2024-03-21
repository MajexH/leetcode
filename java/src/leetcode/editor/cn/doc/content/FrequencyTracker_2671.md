<p>请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。</p>

<p>实现 <code>FrequencyTracker</code> 类：</p>

<ul> 
 <li><code>FrequencyTracker()</code>：使用一个空数组初始化 <code>FrequencyTracker</code> 对象。</li> 
 <li><code>void add(int number)</code>：添加一个 <code>number</code> 到数据结构中。</li> 
 <li><code>void deleteOne(int number)</code>：从数据结构中删除一个 <code>number</code> 。数据结构 <strong>可能不包含</strong> <code>number</code> ，在这种情况下不删除任何内容。</li> 
 <li><code>bool hasFrequency(int frequency)</code>: 如果数据结构中存在出现 <code>frequency</code> 次的数字，则返回 <code>true</code>，否则返回 <code>false</code>。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>
["FrequencyTracker", "add", "add", "hasFrequency"]
[[], [3], [3], [2]]
<strong>输出</strong>
[null, null, null, true]

<strong>解释</strong>
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.add(3); // 数据结构现在包含 [3]
frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入</strong>
["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
[[], [1], [1], [1]]
<strong>输出</strong>
[null, null, null, false]

<strong>解释</strong>
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.add(1); // 数据结构现在包含 [1]
frequencyTracker.deleteOne(1); // 数据结构现在为空 []
frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入</strong>
["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
[[], [2], [3], [1]]
<strong>输出</strong>
[null, false, null, true]

<strong>解释</strong>
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
frequencyTracker.add(3); // 数据结构现在包含 [3]
frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= number &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= frequency &lt;= 10<sup>5</sup></code></li> 
 <li>最多调用 <code>add</code>、<code>deleteOne</code> 和 <code>hasFrequency</code> <strong>共计</strong> <code>2 *&nbsp;10<sup>5</sup></code> 次</li> 
</ul>

<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li></div></div><br><div><li>👍 36</li><li>👎 0</li></div>