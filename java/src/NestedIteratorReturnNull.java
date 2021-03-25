import java.util.*;

// 空数组 return null
public class NestedIteratorReturnNull implements Iterator<Integer> {
    // 给定一个 nexted 的数组
    // 问如何去遍历它
    // 这儿使用组合的方式去生成 nextedList 然后再用 stack 存储遍历的 iterator
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

    // 提供的默认实现类
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

    // stack 来保存每次转换的出来的 iterator 相当于 next 调用的时候去找到的是 stack top 里的 iterator
    Deque<Iterator<NestedInteger>> stack;

    public NestedIteratorReturnNull(List<NestedInteger> nestedList) {
        this.stack = new LinkedList<>();
        // 初始化加入的节点
        this.stack.addLast(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            Iterator<NestedInteger> iterator = this.stack.peekLast();
            NestedInteger i = iterator.next();
            if (!i.isInteger()) {
                stack.addLast(i.getList().iterator());
                return next();
            }
            return i.getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (this.stack.size() > 0) {
            Iterator<NestedInteger> top = this.stack.peekLast();
            if (top.hasNext()) return true;
            // 这个时候 top 的 iterator 访问完毕了 去访问下面的 iterator
            this.stack.removeLast();
            // 只需要递归的调用 访问 栈即可
            return hasNext();
        }
        return false;
    }

    public static void main(String[] args) {
        List<NestedInteger> test = new ArrayList<>();
//        List<NestedInteger> one = new ArrayList<>();
//        one.add(new NestedIntegerImpl(1));
//        one.add(new NestedIntegerImpl(1));
//        test.add(new NestedIntegerImpl(one));
//        test.add(new NestedIntegerImpl(2));
//        List<NestedInteger> three = new ArrayList<>();

        test.add(new NestedIntegerImpl(new ArrayList<>()));
//
//        three.add(new NestedIntegerImpl(1));
//        three.add(new NestedIntegerImpl(1));
//        test.add(new NestedIntegerImpl(three));
//        test.add(new NestedIteratorNew.NestedIntegerImpl(new ArrayList<>()));
//        test.add(new NestedIteratorNew.NestedIntegerImpl(2));
//        test.add(new NestedIteratorNew.NestedIntegerImpl(new ArrayList<>() {{
//            List<NestedInteger> two = new ArrayList<>();
//            two.add(new NestedIteratorNew.NestedIntegerImpl(new ArrayList<>()));
//            add(new NestedIteratorNew.NestedIntegerImpl(two));
//            add(new NestedIteratorNew.NestedIntegerImpl(3));
//        }}));

        NestedIteratorReturnNull it = new NestedIteratorReturnNull(test);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
