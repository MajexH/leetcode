import java.util.*;

public class HalfQuestions_LCS_02 {

    // 选择至少包含几道题
    public int halfQuestions(int[] questions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int question : questions) {
            map.put(question, map.getOrDefault(question, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int n = questions.length / 2;
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int counter = entry.getValue();
            if (n >= counter) {
                res += 1;
                n -= counter;
            } else {
                if (n != 0) res++;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HalfQuestions_LCS_02().halfQuestions(new int[]{13,8,3,7,5,6,11,12,3,6,6,11}));
    }
}
