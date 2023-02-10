//你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime 时刻之后 timeToLive 秒过期。如
//果验证码被更新了，那么它会在 currentTime （可能与之前的 currentTime 不同）时刻延长 timeToLive 秒。 
//
// 请你实现 AuthenticationManager 类： 
//
// 
// AuthenticationManager(int timeToLive) 构造 AuthenticationManager 并设置 
//timeToLive 参数。 
// generate(string tokenId, int currentTime) 给定 tokenId ，在当前时间 currentTime 生成一个新
//的验证码。 
// renew(string tokenId, int currentTime) 将给定 tokenId 且 未过期 的验证码在 currentTime 时刻
//更新。如果给定 tokenId 对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。 
// countUnexpiredTokens(int currentTime) 请返回在给定 currentTime 时刻，未过期 的验证码数目。 
// 
//
// 如果一个验证码在时刻 t 过期，且另一个操作恰好在时刻 t 发生（renew 或者 countUnexpiredTokens 操作），过期事件 优先于 其
//他操作。 
//
// 
//
// 示例 1： 
// 
// 
//输入：
//["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", 
//"generate", "renew", "renew", "countUnexpiredTokens"]
//[[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
//输出：
//[null, null, null, 1, null, null, null, 0]
// 
//
//解释：
//AuthenticationManager authenticationManager = new AuthenticationManager(5); //
// 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
//authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码
//被更新。
//authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码
//。
//authenticationManager.countUnexpiredTokens(6); // 时刻 6 时，只有 tokenId 为 "aaa" 的验
//证码未过期，所以返回 1 。
//authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码
//。
//authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 
//7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
//authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 
//renew 操作会执行，该 token 将在时刻 15 过期。
//authenticationManager.countUnexpiredTokens(15); // tokenId 为 "bbb" 的验证码在时刻 15 
//过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
//
//
// 
//
// 提示： 
//
// 
// 1 <= timeToLive <= 10⁸ 
// 1 <= currentTime <= 10⁸ 
// 1 <= tokenId.length <= 5 
// tokenId 只包含小写英文字母。 
// 所有 generate 函数的调用都会包含独一无二的 tokenId 值。 
// 所有函数调用中，currentTime 的值 严格递增 。 
// 所有函数的调用次数总共不超过 2000 次。 
// 
//
// Related Topics 设计 哈希表 👍 66 👎 0


package leetcode.editor.cn;

import java.util.*;

public class DesignAuthenticationManager1797 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class AuthenticationManager {

        private final int timeToLive;
        private final TreeMap<Integer, Set<String>> map;
        private final Map<String, Integer> reverseMap;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.map = new TreeMap<>();
            this.reverseMap = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            int expireTime = currentTime + this.timeToLive;
            this.map.computeIfAbsent(expireTime, k -> new HashSet<>()).add(tokenId);
            this.reverseMap.put(tokenId, expireTime);
        }

        public void renew(String tokenId, int currentTime) {

            // 没有或者时间超过了过期时间
            if (!this.reverseMap.containsKey(tokenId) || currentTime >= this.reverseMap.get(tokenId)) {
                return;
            }

            this.map.get(this.reverseMap.get(tokenId)).remove(tokenId);
            this.reverseMap.remove(tokenId);
            this.generate(tokenId, currentTime);
        }

        public int countUnexpiredTokens(int currentTime) {
            // 找到大于等于 currentTime 的数据
            return this.map.tailMap(currentTime, false)
                    .values()
                    .stream()
                    .mapToInt(Set::size)
                    .sum();
        }
    }

    /**
     * Your AuthenticationManager object will be instantiated and called as such:
     * AuthenticationManager obj = new AuthenticationManager(timeToLive);
     * obj.generate(tokenId,currentTime);
     * obj.renew(tokenId,currentTime);
     * int param_3 = obj.countUnexpiredTokens(currentTime);
     */
//leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        AuthenticationManager a = new DesignAuthenticationManager1797().new AuthenticationManager(5);
        a.renew("aaa", 1);
        a.generate("aaa", 2);
        System.out.println(a.countUnexpiredTokens(6));
        a.generate("bbb", 7);
        a.renew("aaa", 8);
        a.renew("bbb", 10);
        System.out.println(a.countUnexpiredTokens(15));
    }
}