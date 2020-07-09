import java.util.*;

public class CourseScheduleII_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        Set<Integer> inDegreeEqualsZero = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) inDegreeEqualsZero.add(i);
        }

        while (inDegreeEqualsZero.size() > 0) {
            Iterator<Integer> iterator = inDegreeEqualsZero.iterator();
            // 入度为 0 的点
            int node = iterator.next();
            // 删除入度为 0 的点
            inDegreeEqualsZero.remove(node);
            res.add(node);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == node) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0)
                        inDegreeEqualsZero.add(prerequisite[0]);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            // 表示不存在 拓扑排序
            if (inDegree[i] != 0) return new int[0];
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII_210().findOrder(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        })));
    }
}
