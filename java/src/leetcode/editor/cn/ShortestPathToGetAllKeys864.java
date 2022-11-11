//给定一个二维网格 grid ，其中：
//
// 
// '.' 代表一个空房间 
// '#' 代表一堵 
// '@' 是起点 
// 小写字母代表钥匙 
// 大写字母代表锁 
// 
//
// 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们
//手里有对应的钥匙，否则无法通过锁。 
//
// 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一
//对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。 
//
// 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = ["@.a.#","###.#","b.A.B"]
//输出：8
//解释：目标是获得所有钥匙，而不是打开所有锁。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = ["@..aA","..B#.","....b"]
//输出：6
// 
//
// 示例 3: 
// 
// 
//输入: grid = ["@Aa"]
//输出: -1 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 30 
// grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F' 
// 钥匙的数目范围是 [1, 6] 
// 每个钥匙都对应一个 不同 的字母 
// 每个钥匙正好打开一个对应的锁 
// 
//
// Related Topics 位运算 广度优先搜索 数组 矩阵 👍 230 👎 0


package leetcode.editor.cn;

import java.util.*;

public class ShortestPathToGetAllKeys864 {
    public static void main(String[] args) {
        Solution solution = new ShortestPathToGetAllKeys864().new Solution();
        System.out.println(solution.shortestPathAllKeys(new String[]{"@.a.#", "###.#", "b.A.B"}));
        System.out.println(solution.shortestPathAllKeys(new String[]{"@..aA", "..B#.", "....b"}));
        System.out.println(solution.shortestPathAllKeys(new String[]{"@Aa"}));
        System.out.println(solution.shortestPathAllKeys(new String[]{"#..#.#.#..#.#.#.....#......#..", ".#.......#....#A.....#.#......", "#....#.....#.........#........", "...#.#.........#..@....#....#.", ".#.#.##...#.........##....#..#", "..........#..#..###....##..#.#", ".......#......#...#...#.....c#", ".#...#.##......#...#.###...#..", "..........##...#.......#......", "#...#.........a#....#.#.##....", "..#..#...#...#..#....#.....##.", "..........#...#.##............", "...#....#..#.........#..D.....", "....#E.#....##................", "...........##.#.......#.#....#", "...#..#...#.#............#e...", "..#####....#.#...........##..#", "##......##......#.#...#..#.#..", ".#F.......#..##.......#....#..", "............#....#..#..#...#..", ".............#...#f...#..##...", "....#..#...##.........#..#..#.", ".....#.....##.###..##.#......#", ".#..#.#...#.....#........###..", ".....#.#...#...#.....#.....#..", "##.....#....B.....#..#b.......", ".####....##..#.##..d.#......#.", "..#.....#....##........##...##", "...#...#...C..#..#....#.......", "#.....##.....#.#......#......."}))
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int shortestPathAllKeys(String[] grid) {

            char[][] map = new char[grid.length][];

            Map<Character, Integer> key2Index = new HashMap<>();

            int startX = 0, startY = 0;
            for (int i = 0; i < grid.length; i++) {
                map[i] = new char[grid[i].length()];

                for (int j = 0; j < grid[i].length(); j++) {
                    map[i][j] = grid[i].charAt(j);

                    if (map[i][j] == '@') {
                        startX = i;
                        startY = j;
                    } else if (map[i][j] >= 'a' && map[i][j] <= 'z') {
                        // 钥匙
                        int idx = key2Index.size();
                        key2Index.put(map[i][j], idx);
                    }
                }
            }

            // 广搜
            Deque<Node> queue = new LinkedList<>();

            Set<Node> visited = new HashSet<>();
            queue.add(new Node(startX, startY, 0, 0));
            visited.add(new Node(startX, startY, 0, 0));

            // 因为当前节点如果有 钥匙 可以再次访问 所以钥匙应该作为一个是否已经访问过的条件加入其中
            while (!queue.isEmpty()) {

                Node first = queue.removeFirst();

                for (int[] direction : DIRECTIONS) {
                    int x = first.x + direction[0], y = first.y + direction[1];
                    int dis = first.dis + 1;

                    // 无法访问
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length()) {
                        continue;
                    }

                    char c = map[x][y];

                    // 当前是墙
                    if (c == '#') {
                        continue;
                    }

                    int mask = first.mask;

                    // 如果当前节点是钥匙 那么要更新 mask
                    if (c >= 'a' && c <= 'z') {
                        mask = mask | 1 << key2Index.get(c);
                        // 所有的钥匙已经拿到
                        if (mask == (1 << key2Index.size()) - 1) {
                            return dis;
                        }
                    }

                    Node node = new Node(x, y, dis, mask);

                    if (visited.contains(node)) {
                        continue;
                    }

                    // 当前是锁
                    if (c >= 'A' && c <= 'Z') {
                        // 如果有钥匙
                        int idx = key2Index.get(Character.toLowerCase(c));
                        if ((mask & (1 << idx)) != 0) {
                            visited.add(node);
                            queue.add(node);
                        }
                        continue;
                    }

                    // 当前可以直接走
                    queue.add(node);
                    visited.add(node);
                }
            }

            return -1;
        }

        private static final class Node {
            int x, y;
            int dis;
            int mask;

            public Node(int x, int y, int dis, int mask) {
                this.x = x;
                this.y = y;
                this.dis = dis;
                this.mask = mask;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Node node = (Node) o;

                if (x != node.x) return false;
                if (y != node.y) return false;
                return mask == node.mask;
            }

            @Override
            public int hashCode() {
                int result = x;
                result = 31 * result + y;
                result = 31 * result + mask;
                return result;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}