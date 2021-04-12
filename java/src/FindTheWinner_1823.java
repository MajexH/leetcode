import java.util.LinkedList;

public class FindTheWinner_1823 {

    public int findTheWinner(int n, int k) {
        if (k == 1) return n;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int counter = 1;
        int index = 0;
        while (list.size() > 1) {
            if (counter == k) {
                list.remove(index);
                counter = 1;
            }
            if (index >= list.size()) index = 0;
            index++;
            counter++;
            if (index >= list.size()) index = 0;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new FindTheWinner_1823().findTheWinner(3, 1));
        System.out.println(new FindTheWinner_1823().findTheWinner(6, 5));
    }
}
