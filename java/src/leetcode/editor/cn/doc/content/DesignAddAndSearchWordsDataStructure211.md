<p>请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。</p>

<p>实现词典类 <code>WordDictionary</code> ：</p>

<ul> 
 <li><code>WordDictionary()</code> 初始化词典对象</li> 
 <li><code>void addWord(word)</code> 将 <code>word</code> 添加到数据结构中，之后可以对它进行匹配</li> 
 <li><code>bool search(word)</code> 如果数据结构中存在字符串与&nbsp;<code>word</code> 匹配，则返回 <code>true</code> ；否则，返回&nbsp; <code>false</code> 。<code>word</code> 中可能包含一些 <code>'.'</code> ，每个&nbsp;<code>.</code> 都可以表示任何一个字母。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
<strong>输出：</strong>
[null,null,null,null,false,true,true,true]

<strong>解释：</strong>
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // 返回 False
wordDictionary.search("bad"); // 返回 True
wordDictionary.search(".ad"); // 返回 True
wordDictionary.search("b.."); // 返回 True
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= word.length &lt;= 25</code></li> 
 <li><code>addWord</code> 中的 <code>word</code> 由小写英文字母组成</li> 
 <li><code>search</code> 中的 <code>word</code> 由 '.' 或小写英文字母组成</li> 
 <li>最多调用 <code>10<sup>4</sup></code> 次 <code>addWord</code> 和 <code>search</code></li> 
</ul>

<div><div>Related Topics</div><div><li>深度优先搜索</li><li>设计</li><li>字典树</li><li>字符串</li></div></div><br><div><li>👍 445</li><li>👎 0</li></div>