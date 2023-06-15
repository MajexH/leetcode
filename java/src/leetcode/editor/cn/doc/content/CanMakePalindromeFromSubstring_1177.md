<p>给你一个字符串&nbsp;<code>s</code>，请你对&nbsp;<code>s</code>&nbsp;的子串进行检测。</p>

<p>每次检测，待检子串都可以表示为&nbsp;<code>queries[i] = [left, right, k]</code>。我们可以 <strong>重新排列</strong> 子串&nbsp;<code>s[left], ..., s[right]</code>，并从中选择 <strong>最多</strong> <code>k</code>&nbsp;项替换成任何小写英文字母。&nbsp;</p>

<p>如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为&nbsp;<code>true</code>，否则结果为&nbsp;<code>false</code>。</p>

<p>返回答案数组&nbsp;<code>answer[]</code>，其中&nbsp;<code>answer[i]</code>&nbsp;是第&nbsp;<code>i</code>&nbsp;个待检子串&nbsp;<code>queries[i]</code>&nbsp;的检测结果。</p>

<p>注意：在替换时，子串中的每个字母都必须作为 <strong>独立的</strong> 项进行计数，也就是说，如果&nbsp;<code>s[left..right] = "aaa"</code>&nbsp;且&nbsp;<code>k = 2</code>，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 <code>s</code>，可以认为每次检测都是独立的）</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
<strong>输出：</strong>[true,false,false,true,true]
<strong>解释：</strong>
queries[0] : 子串 = "d"，回文。
queries[1] :&nbsp;子串 = "bc"，不是回文。
queries[2] :&nbsp;子串 = "abcd"，只替换 1 个字符是变不成回文串的。
queries[3] :&nbsp;子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
queries[4] :&nbsp;子串 = "abcda"，可以变成回文的 "abcba"。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length,&nbsp;queries.length&nbsp;&lt;= 10^5</code></li> 
 <li><code>0 &lt;= queries[i][0] &lt;= queries[i][1] &lt;&nbsp;s.length</code></li> 
 <li><code>0 &lt;= queries[i][2] &lt;= s.length</code></li> 
 <li><code>s</code> 中只有小写英文字母</li> 
</ul>

<div><div>Related Topics</div><div><li>位运算</li><li>数组</li><li>哈希表</li><li>字符串</li><li>前缀和</li></div></div><br><div><li>👍 101</li><li>👎 0</li></div>