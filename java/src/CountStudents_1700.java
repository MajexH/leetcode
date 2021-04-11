public class CountStudents_1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        boolean[] memo = new boolean[students.length];
        // 用来标识是不是这一轮遍历中是不是已经找不到匹配了
        boolean flag = false;
        int i = 0, j = 0;
        while (j < sandwiches.length) {
            if (!memo[i] && students[i] == sandwiches[j]) {
                memo[i] = true;
                j++;
                flag = false;
            }
            i++;
            if (i >= students.length) {
                i = 0;
                if (flag) break;
                flag = true;
            }
        }
        return sandwiches.length - j;
    }

    public static void main(String[] args) {
        System.out.println(new CountStudents_1700().countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println(new CountStudents_1700().countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
}
