import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseNodeInK {

    int val;

    class Test {

        public int test() {
            return ReverseNodeInK.this.val;
        }
    }

    public static void main(String[] args) {
//        ReverseNodeInK b = new ReverseNodeInK();
//        Test a = b.new Test();
//        System.out.println(a.test());
//
        List<Integer> test = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            test.add(i);
        }

        Iterator<Integer> integerIterator = test.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
            integerIterator.remove();
        }
        System.out.println(test);
    }
}
