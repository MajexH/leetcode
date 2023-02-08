//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。 
//
// 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。 
//
// 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。 
//
// 
// 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//输出：["/a","/c/d","/c/f"]
//解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
// 
//
// 示例 2： 
//
// 
//输入：folder = ["/a","/a/b/c","/a/b/d"]
//输出：["/a"]
//解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
// 
//
// 示例 3： 
//
// 
//输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//输出: ["/a/b/c","/a/b/ca","/a/b/d"] 
//
// 
//
// 提示： 
//
// 
// 1 <= folder.length <= 4 * 10⁴ 
// 2 <= folder[i].length <= 100 
// folder[i] 只包含小写字母和 '/' 
// folder[i] 总是以字符 '/' 起始 
// 每个文件夹名都是 唯一 的 
// 
//
// Related Topics 字典树 数组 字符串 👍 120 👎 0


package leetcode.editor.cn;

import java.util.*;

public class RemoveSubFoldersFromTheFilesystem1233 {
    public static void main(String[] args) {
        Solution solution = new RemoveSubFoldersFromTheFilesystem1233().new Solution();

        System.out.println(solution.removeSubfolders(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        System.out.println(solution.removeSubfolders(new String[]{"/a", "/a/b/c", "/a/b/d"}));
        System.out.println(solution.removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static class Tier {

            private String str;
            private boolean leaf;
            private boolean end;
            private Map<String, Tier> next;

            public Tier() {
                this.next = new HashMap<>();
                this.leaf = true;
            }

            public Tier(String str) {
                this.str = str;
                this.next = new HashMap<>();
                this.leaf = true;
            }

            public void link(String n) {

                if (this.next.containsKey(n)) {
                    return;
                }

                Tier next = new Tier();
                next.str = n;
                this.next.put(n, next);
                this.leaf = false;
            }

            public Tier get(String n) {
                return this.next.get(n);
            }
        }

        private void recursion(List<String> res, Tier tier, String cur) {

            for (Map.Entry<String, Tier> entry : tier.next.entrySet()) {
                // 结束
                if (entry.getValue().end) {
                    res.add(cur + "/" + entry.getKey());
                    continue;
                }
                this.recursion(res, entry.getValue(), cur + "/" + entry.getKey());
            }
        }

        public List<String> removeSubfolders(String[] folder) {
            // 保存的是前缀
            Tier root = new Tier();

            for (String f : folder) {

                Tier cur = root;
                for (String next : f.split("/")) {
                    if (next.length() < 1) {
                        continue;
                    }
                    cur.link(next);
                    cur = cur.get(next);
                }
                cur.end = true;
            }

            List<String> res = new ArrayList<>();

            this.recursion(res, root, "");

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}