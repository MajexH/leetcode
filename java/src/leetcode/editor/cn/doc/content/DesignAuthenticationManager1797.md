<p>你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 <code>currentTime</code>&nbsp;时刻之后 <code>timeToLive</code>&nbsp;秒过期。如果验证码被更新了，那么它会在 <code>currentTime</code>&nbsp;（可能与之前的 <code>currentTime</code>&nbsp;不同）时刻延长&nbsp;<code>timeToLive</code>&nbsp;秒。</p>

<p>请你实现&nbsp;<code>AuthenticationManager</code>&nbsp;类：</p>

<ul> 
 <li><code>AuthenticationManager(int timeToLive)</code>&nbsp;构造&nbsp;<code>AuthenticationManager</code>&nbsp;并设置&nbsp;<code>timeToLive</code>&nbsp;参数。</li> 
 <li><code>generate(string tokenId, int currentTime)</code>&nbsp;给定 <code>tokenId</code>&nbsp;，在当前时间&nbsp;<code>currentTime</code> 生成一个新的验证码。</li> 
 <li><code>renew(string tokenId, int currentTime)</code>&nbsp;将给定 <code>tokenId</code>&nbsp;且 <strong>未过期</strong>&nbsp;的验证码在 <code>currentTime</code>&nbsp;时刻更新。如果给定&nbsp;<code>tokenId</code>&nbsp;对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。</li> 
 <li><code>countUnexpiredTokens(int currentTime)</code>&nbsp;请返回在给定&nbsp;<code>currentTime</code>&nbsp;时刻，<strong>未过期</strong>&nbsp;的验证码数目。</li> 
</ul>

<p>如果一个验证码在时刻&nbsp;<code>t</code>&nbsp;过期，且另一个操作恰好在时刻&nbsp;<code>t</code>&nbsp;发生（<code>renew</code>&nbsp;或者&nbsp;<code>countUnexpiredTokens</code>&nbsp;操作），过期事件&nbsp;<strong>优先于</strong>&nbsp;其他操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/25/copy-of-pc68_q2.png" style="width: 500px; height: 287px;" /> 
<pre>
<strong>输入：</strong>
["AuthenticationManager", "<span><code>renew</code></span>", "generate", "<span><code>countUnexpiredTokens</code></span>", "generate", "<span><code>renew</code></span>", "<span><code>renew</code></span>", "<span><code>countUnexpiredTokens</code></span>"]
[[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
<strong>输出：</strong>
[null, null, null, 1, null, null, null, 0]
</pre>

<strong>解释：</strong>
AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 <code>timeToLive</code> = 5 秒。
authenticationManager.<code>renew</code>("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
authenticationManager.<code>countUnexpiredTokens</code>(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
authenticationManager.<code>renew</code>("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
authenticationManager.<code>renew</code>("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
authenticationManager.<code>countUnexpiredTokens</code>(15); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= timeToLive &lt;= 10<sup>8</sup></code></li> 
 <li><code>1 &lt;= currentTime &lt;= 10<sup>8</sup></code></li> 
 <li><code>1 &lt;= tokenId.length &lt;= 5</code></li> 
 <li><code>tokenId</code>&nbsp;只包含小写英文字母。</li> 
 <li>所有&nbsp;<code>generate</code>&nbsp;函数的调用都会包含独一无二的&nbsp;<code>tokenId</code>&nbsp;值。</li> 
 <li>所有函数调用中，<code>currentTime</code>&nbsp;的值 <strong>严格递增</strong>&nbsp;。</li> 
 <li>所有函数的调用次数总共不超过&nbsp;<code>2000</code>&nbsp;次。</li> 
</ul>

<div><div>Related Topics</div><div><li>设计</li><li>哈希表</li></div></div><br><div><li>👍 66</li><li>👎 0</li></div>