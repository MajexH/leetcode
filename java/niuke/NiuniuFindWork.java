import java.util.*;

public class NiuniuFindWork {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();

        //存放能力值
        int[] ability = new int[m];
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        //存入难度和薪酬
        for (int i = 0; i < n; i++) {
            int hard = input.nextInt();
            int money = input.nextInt();
            map.put(hard, money);
        }
        //存入小伙伴的能力
        for (int i = 0; i < m; i++) {//
            int t = input.nextInt();
            ability[i] = t;
            //不在工作难度边界处的，放入map，且对应薪酬为0
            //若能力和工作难度相等，则不存，因为已经有了这组数据，下次比较的时候可以直接用
            if (!map.containsKey(t)) {
                map.put(t, 0);
            }
        }
        //Map.Entry用户遍历map的key和value值
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //map的值如下：
            //  key  value
            //  1    100
            //  9    0
            //  10   1000
            //  10000000000 1001
            max = Math.max(max, entry.getValue());
            //更新之后：
            //  key  value
            //  1    100
            //  9    100
            //  10   1000
            //  10000000000 1001
            map.put(entry.getKey(), max);//更新不在工作难度边界处的薪酬
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(ability[i]));
        }
    }
}
