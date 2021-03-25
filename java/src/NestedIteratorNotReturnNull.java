import java.util.*;

public class NestedIteratorNotReturnNull implements Iterator<Integer> {

    // 为了不返回 null 所以要在 hasNext 中就将所有数据准备好
    private Deque<Iterator<NestedInteger>> stack;

    public NestedIteratorNotReturnNull(List<NestedInteger> nestedList) {
        this.stack = new LinkedList<>();
        this.stack.addLast(nestedList.iterator());
    }

    @Override
    public boolean hasNext() {
        // 拉平所有的 iterator
        while (!this.stack.isEmpty()) {
            // 已经拉平了一个状态了
            Iterator<NestedInteger> top = this.stack.peekLast();
            if (!top.hasNext()) {
                this.stack.removeLast();
                continue;
            }
            // 每次处理一个
            NestedInteger next = top.next();
            if (next.isInteger()) {
                // 已经找到了一个数字 直接返回
                this.stack.addLast(Collections.singletonList(next).iterator());
                return true;
            }
            this.stack.addLast(next.getList().iterator());
        }
        return false;
    }

    @Override
    public Integer next() {
        // hasNext 中已经将数据和结果准备好
        return stack.peekLast().next().getInteger();
    }

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

}
