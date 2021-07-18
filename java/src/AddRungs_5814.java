public class AddRungs_5814 {

    public int addRungs(int[] rungs, int dist) {
        int res = 0;
        int pre = 0;
        for (int i = 0; i < rungs.length; i++) {
            int diff = rungs[i] - pre;
            if (diff <= dist) {
                pre = rungs[i];
                continue;
            }
            res += (diff - 1) / (double) dist;
            pre = rungs[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AddRungs_5814().addRungs(new int[]{1,3,5,10}, 2));
        System.out.println(new AddRungs_5814().addRungs(new int[]{3,6,8,10}, 3));
        System.out.println(new AddRungs_5814().addRungs(new int[]{3,4,6,7}, 2));
    }
}
