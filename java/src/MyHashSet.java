class MyHashSet {

    // 不能使用任何 built-in 的 hash 库
    private static class Pair {
        Object val;
        boolean isDeleted;
        int hashcode;

        public Pair(Object val, boolean isDeleted, int hashcode) {
            this.val = val;
            this.isDeleted = isDeleted;
            this.hashcode = hashcode;
        }
    }

    private Pair[] objs;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.objs = new Pair[16];
    }

    public void add(int key) {
        if (++size >= this.objs.length) {
            // 先判断增长
            grow();
        }
        int addedIndex = getAddedIndex(key);
        if (addedIndex != this.objs.length) {
            this.objs[addedIndex] = new Pair(key, false, Integer.hashCode(key));
            return;
        }
        // 这个时候也应该 grow 因为没有地方放置了
        // 按道理说 这个时候应该去扫描前后 去除无用的引用
        grow();
        add(key);
    }

    private int getAddedIndex(int key) {
        int i = Integer.hashCode(key) & (this.objs.length - 1);
        for (; i < this.objs.length; i++) {
            if (this.objs[i] == null || (int) this.objs[i].val == key || this.objs[i].isDeleted) {
                return i;
            }
        }
        return i;
    }

    private void grow() {
        int newLen = this.objs.length << 1;
        Pair[] objs = new Pair[newLen];

        for (Pair old : this.objs) {
            if (old == null) continue;
            // 删除的就不管了
            if (old.isDeleted) continue;
            int j = old.hashcode & (newLen - 1);
            for (; j < newLen; j++) {
                if (objs[j] == null) {
                    objs[j] = old;
                    break;
                }
            }
        }
        this.objs = objs;
    }

    // 获取 remove contains 的 index
    // 其实可以用 lambda 表达式来传入不同的函数 将两个 index 整合
    private int getOtherIndex(int key) {
        int j = Integer.hashCode(key) & (this.objs.length - 1);
        // 开放寻址法 继续往后找
        for (; j < this.objs.length; j++) {
            if (this.objs[j] != null && (int) this.objs[j].val == key) {
                return j;
            }
        }
        return j;
    }

    public void remove(int key) {
        int j = getOtherIndex(key);
        // 这个地方应该提出来  作为统一的寻找 j 的方法
        if (j < this.objs.length) {
            this.objs[j].isDeleted = true;
            --size;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int j = getOtherIndex(key);
        if (j < this.objs.length) {
            return !this.objs[j].isDeleted;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        System.out.println(set.contains(624));
        set.remove(182);
        set.add(74);
        set.add(647);
        set.add(724);
        set.add(575);
    }
}