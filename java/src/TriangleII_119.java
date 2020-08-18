import java.util.ArrayList;
import java.util.List;

public class TriangleII_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
            cur = new ArrayList<>();
        }

        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new TriangleII_119().getRow(4));
    }
}
