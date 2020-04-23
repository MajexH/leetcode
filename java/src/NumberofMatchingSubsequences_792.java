import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberofMatchingSubsequences_792 {

    // Node 表示的就是桶里面的元素
    // 其中Node保存了 word 和当前的index
    public class Node {
        String word;
        int index;
        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }

    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<>();

        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));
        }

        for (char character : S.toCharArray()) {
            // 这个地方是根据S字符串的头是什么去取桶
            ArrayList<Node> bucket = heads[character - 'a'];
            // 因为原来桶里面的所有东西都被取走了 因此 桶置位空
            heads[character - 'a'] = new ArrayList<Node>();
            for (Node node : bucket) {
                node.index++;
                // 说明这个桶里面的走完了 表明这个桶代表的word是其一个子串
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    // 将桶里面的word指向下个元素 并且在整体的桶里面加上记录
                    // 这样下个记录过来的时候 就可以直接调用了
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            bucket.clear();
        }

        return ans;
    }

    public static void main(String[] args) {
        String temp = "abcde";
        String[] test = new String[]{ "a", "bb", "acd", "ace" };
        System.out.println(new NumberofMatchingSubsequences_792().numMatchingSubseq(temp, test));
    }
}
