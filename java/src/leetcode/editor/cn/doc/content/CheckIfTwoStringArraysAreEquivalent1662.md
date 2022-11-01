<p>给你两个字符串数组 <code>word1</code> 和 <code>word2</code> 。如果两个数组表示的字符串相同，返回<em> </em><code>true</code><em> </em>；否则，返回 <code>false</code><em> 。</em></p>

<p><strong>数组表示的字符串</strong>&nbsp;是由数组中的所有元素 <strong>按顺序</strong> 连接形成的字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>word1 = ["ab", "c"], word2 = ["a", "bc"]
<strong>输出：</strong>true
<strong>解释：</strong>
word1 表示的字符串为 "ab" + "c" -&gt; "abc"
word2 表示的字符串为 "a" + "bc" -&gt; "abc"
两个字符串相同，返回 true</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>word1 = ["a", "cb"], word2 = ["ab", "c"]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= word1.length, word2.length &lt;= 10<sup>3</sup></code></li> 
 <li><code>1 &lt;= word1[i].length, word2[i].length &lt;= 10<sup>3</sup></code></li> 
 <li><code>1 &lt;= sum(word1[i].length), sum(word2[i].length) &lt;= 10<sup>3</sup></code></li> 
 <li><code>word1[i]</code> 和 <code>word2[i]</code> 由小写字母组成</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>字符串</li></div></div><br><div><li>👍 57</li><li>👎 0</li></div>