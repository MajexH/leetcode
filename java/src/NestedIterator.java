import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private static interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    // 保证在stack 中的都是 num 的 NestedInteger
    // 这样 直接返回这个 num 即可
    private Deque<NestedInteger> stack;

    // 那我只能使用一个 nestedIterator 去递归的调用
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new LinkedList<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.stack.addLast(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        // 直到 stack 的 top 保存的是 integer
        while (!this.stack.isEmpty()) {
            NestedInteger top = this.stack.peekLast();
            if (top.isInteger()) return true;
            // 是 list 类型的
            this.stack.removeLast();
            for (int i = top.getList().size() - 1; i >= 0; i--) {
                this.stack.addLast(top.getList().get(i));
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        // 保障一定是 integer
        return stack.removeLast().getInteger();
    }
    // 尝试失败 因为需要保存所有的 iterator 而如果用递归去做 找不到之前的 iterator
//    @Override
//    public Integer next() {
//        if (this.nestedIterator != null) {
//            if (this.nestedIterator.hasNext()) {
//                return this.nestedIterator.next();
//            }
//            // 遍历完成了
//            this.nestedIterator = null;
//        }
//        NestedInteger cur = this.nestedIntegers.get(index);
//        if (cur.isInteger()) {
//            index++;
//            return cur.getInteger();
//        }
//        // 其他的话 就要创建 新的 Iterator 来遍历了
//        this.nestedIterator = new NestedIterator(cur.getList());
//        index++;
//        return this.nestedIterator.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (index < this.nestedIntegers.size()) {
//            NestedInteger cur = this.nestedIntegers.get(index);
//            while (!cur.isInteger()) {
//                NestedIterator it = new NestedIterator(cur.getList());
//                if (!it.hasNext()) {
//                    index++;
//                } else {
//                    break;
//                }
//                if (index >= this.nestedIntegers.size()) break;
//                cur = this.nestedIntegers.get(index);
//            }
//        }
//        return (this.nestedIterator != null && this.nestedIterator.hasNext()) || index < this.nestedIntegers.size();
//    }

    private static class NestedIntegerImpl implements NestedInteger {

        private int num;
        private List<NestedInteger> list;
        private boolean isNum;

        public NestedIntegerImpl(int num) {
            this.num = num;
            this.isNum = true;
        }

        public NestedIntegerImpl(List<NestedInteger> list) {
            this.list = list;
            this.isNum = false;
        }

        @Override
        public boolean isInteger() {
            return this.isNum;
        }

        @Override
        public Integer getInteger() {
            return this.num;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.list;
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> test = new ArrayList<>();
//        List<NestedInteger> one = new ArrayList<>();
//        one.add(new NestedIntegerImpl(1));
//        one.add(new NestedIntegerImpl(1));
//        test.add(new NestedIntegerImpl(one));
//        test.add(new NestedIntegerImpl(2));
//        List<NestedInteger> three = new ArrayList<>();
//        test.add(new NestedIntegerImpl(new ArrayList<>()));
//        three.add(new NestedIntegerImpl(1));
//        three.add(new NestedIntegerImpl(1));
//        test.add(new NestedIntegerImpl(three));
        test.add(new NestedIntegerImpl(new ArrayList<>()));
        test.add(new NestedIntegerImpl(2));
        test.add(new NestedIntegerImpl(new ArrayList<>() {{
            List<NestedInteger> two = new ArrayList<>();
            two.add(new NestedIntegerImpl(new ArrayList<>()));
            add(new NestedIntegerImpl(two));
            add(new NestedIntegerImpl(3));
        }}));

        NestedIterator it = new NestedIterator(test);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
