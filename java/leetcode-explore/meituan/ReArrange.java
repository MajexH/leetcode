package meituan;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReArrange {

    //在小团的公司中，有n位员工。除了最高领导——小团外，每位员工有且仅有一位直接领导。所以，公司内从属关系可以看成一棵树。
    //
    //现在，公司接到一个项目，需要重新划分这n位员工的从属关系。新的划分描述如下：
    //
    //1.每个人要么没有下属，要么有至少两个直接下属（即至少有两人的直接领导为这个人）
    //
    //2.第i个人的下属（包括自己）有恰好a_i个。
    //
    //请注意，直接下属和下属（包括自己）可分别看做树上点的"儿子"和"子树"。
    //
    //请问是否存在这么一种关系？注意，输入不会给出最高领导的编号。


    // 完全二叉树
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        while (sc.hasNext()) {
            // 总人数
            int n = sc.nextInt();

            // 只有到叶子节点 或者叶子节点上一层 才会有叶子节点
            // 所以要先排列数量最多的 然后依次往下
            List<Integer> nums = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                nums.add(num);
                if (num == 2) flag = false;
            }
            if (!flag) {
                writer.write("NO");
                writer.newLine();
                continue;
            }
            nums.sort((a, b) -> b - a);
            // 递归的判断能否形成完全多叉树
            writer.write(recursion(nums, 0, 0) ? "YES" : "NO");
            writer.newLine();
        }
        writer.flush();
    }

    // 要找到的是多叉树
    // 不一定是完全的 但是不能只用排序 要直接用方法去减去才醒
    // 也就是说 这个地方要用不停的选取剩下的进行排序 一层一层的构建
    // 所以其实可以用一个 queue 来保存所有的数字然后从大的数字开始构建 构建的时候回选取小的数字 如果有一个无法满足就 返回 false 即可
    public static boolean recursion(List<Integer> nums, int start, int end) {
        if (start >= nums.size()) return true;
        int newEnd = end;
        // 必须把这一层遍历完 再遍历下一层 不然会出错
        // 遍历作为根节点的节点
        for (int i = start; i <= end; i++) {
            // 找到之后的节点数 跟 当前 -1 相等的结束点
            int index = newEnd, total = nums.get(i) - 1;
            while (total > 0 && index < nums.size() - 1) {
                index++;
                total -= nums.get(index);
            }
            // 因为下面的节点的数量超过了想要的数量
            if (total != 0 || index >= nums.size()) return false;
            newEnd = index;
        }
        if (!recursion(nums, end + 1, newEnd)) return false;
        return true;
    }
}
