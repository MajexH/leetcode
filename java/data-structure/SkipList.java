import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangminjie
 * @since 2022/3/16
 */
public class SkipList<K, V> extends AbstractMap<K, V> implements Serializable {

    private static final long serialVersionUID = -1L;

    @Override
    public String toString() {
        return "SkipList{" +
                "curLevel=" + level +
                ", size=" + size +
                ", entrySet=" + entrySet +
                ", head=" + head +
                ", tail=" + tail +
                ", comparator=" + comparator +
                '}';
    }

    /**
     * 最大层次
     */
    private static final int MAX_LEVEL = 32;

    /**
     * 每个节点插入的时候的 random 因子数大小
     * 用于生成其随机 level
     */
    private static final double LEVEL_FACTOR = 0.5D;

    /**
     * 当前的 level
     */
    private int level = 0;

    /**
     * 当前的大小
     */
    private int size = 0;

    /**
     * 遍历
     */
    private transient Set<Entry<K, V>> entrySet;

    /**
     * 当前 skip list 的头
     */
    private Node<K, V> head = new Node<>(null, null, MAX_LEVEL);

    /**
     * 当前 skip_list 的尾部
     * 主要用来判断
     */
    private Node<K, V> tail = new Node<>(null, null, MAX_LEVEL);

    /**
     * 比较器
     */
    private Comparator<K> comparator;

    public SkipList() {
        this(null);
    }

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        // 初始化 head tail
        for (int i = 0; i < MAX_LEVEL; i++) {
            this.linkNode(head, tail, i);
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            return (this.entrySet = new EntrySet());
        }
        return this.entrySet;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        Node<K, V> node = this.findKey((K) key, null);
        return node == null ? null : node.value;
    }

    @Override
    public V put(K key, V val) {
        // update[i] 在查找 key 的过程中每一层级上的转折点
        // 即在插入 key val 后 update[i].last[i] -> 指向新插入的节点
        Node<K, V>[] update = new Node[MAX_LEVEL];

        // 找到数据
        Node<K, V> nearNode = this.findKey(key, update);

        // 如果 nearNode 不为 null 而且 key 相当 那么说明要更新
        if (nearNode != null && this.compare(nearNode, key) == 0) {
            V oldVal = nearNode.value;
            nearNode.value = val;
            return oldVal;
        }

        int randomLevel = this.randomLevel();
        // 要插入新的 node
        Node<K, V> newNode = new Node<>(key, val, randomLevel);

        // 如果随机的 level 比 curLevel 大 说明这个时候要在 curLevel -> randomLevel 的 head 上加入到 node Node 的链接
        if (randomLevel > this.level) {
            for (int i = this.level; i < randomLevel; i++) {
                // 用 update 来接 不直接关联 在下面的方法内再关联
                // pre: head.last[i] = newNode;
                // 这个时候直接前缀一定是 head
                update[i] = head;
            }
            this.level = randomLevel;
        }

        // 0 -> this.curLevel 则要换一种方式
        // 表达的含义是 update[i] 现在要关联到 newNode 上 而 newNode.last 要关联到 update[i].last 上
        for (int i = 0; i < randomLevel; i++) {
//            Node<K, V> last = update[i].last[i];
//            newNode.last[i] = last;
//            update[i].last[i] = newNode;
            // 向前关联 node
            this.linkNode(newNode, update[i].last[i], i);
            // 向后关联 Node
            this.linkNode(update[i], newNode, i);
        }

        this.size++;

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V remove(Object key) {

        Node<K, V> findNode = this.findKey((K) key, null);
        // 没有找到数据
        if (findNode == null) {
            return null;
        }

        // 更改 update 的指向 以 删除引用
        for (int i = 0; i < findNode.level; i++) {
            // 关联前一个和后一个节点
            this.linkNode(findNode.pre[i], findNode.last[i], i);

            // 清除引用 防止无法回收
            findNode.pre[i] = null;
            findNode.last[i] = null;
        }
        // 判断是否要减少层次
        // 如果当前 head.last[level] == this.tail 说明要减少层次了 说明当前层次没有一个数据节点了
        while (this.level > 0 && this.head.last[this.level] == this.tail) {
            this.level--;
        }
        // 更改当前的大小
        this.size--;
        return findNode.getValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        return this.findKey((K) key, null) != null;
    }

    /**
     * 找到距离 key 最近的数据
     *
     * @param key    需要找到的 key
     * @param update 需要
     *
     * @return 返回找到的最近的数据
     */
    private Node<K, V> findKey(K key, Node<K, V>[] update) {
        Node<K, V> cur = head;
        for (int i = this.level - 1; i >= 0; i--) {
            while (i < cur.last.length && cur.last[i] != null && this.compare(cur.last[i], key) < 0) {
                cur = cur.last[i];
            }
            if (update != null) {
                update[i] = cur;
            }
        }

        if (cur == null) {
            return null;
        }

        // 有可能找到 tail 这个时候 cur.last[0] == null
        return cur.last[0] == null ? null : this.compare(cur.last[0], key) == 0 ? cur.last[0] : null;
    }

    /**
     * 在插入节点的时候 随机初始化其所在的层次
     *
     * @return 层次 id
     */
    private int randomLevel() {
        int level = 1;
        while (level < MAX_LEVEL && ThreadLocalRandom.current().nextDouble() < LEVEL_FACTOR) {
            level++;
        }
        return level;
    }


    /**
     * 关联 pre 和 last 两个及诶单
     *
     * @param pre   前一个节点
     * @param last  后一个节点
     * @param level 当前层次关联
     */
    private void linkNode(Node<K, V> pre, Node<K, V> last, int level) {
        if (pre != null) {
            pre.last[level] = last;
        }
        if (last != null) {
            last.pre[level] = pre;
        }
    }

    @SuppressWarnings("unchecked")
    private int compare(Node<K, V> node, K key) {
        // head 需要移动到下一个节点
        if (node == this.head) {
            return -1;
        }
        // tail 需要停止在 tail 节点 所有它是永远大于所有的 key 的
        if (node == this.tail) {
            return 1;
        }

        if (Objects.nonNull(this.comparator)) {
            return this.comparator.compare(node.key, key);
        }

        return ((Comparable<K>) node.key).compareTo(key);
    }

    /**
     * 每个 Node 抽象一个存储的节点
     * 其持有每个 k v 类似于 HashMap，但是 hashMap 持有 hashCode 避免重复计算
     */
    private static class Node<K, V> implements Map.Entry<K, V> {

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + this.key +
                    ", val=" + this.value +
                    ", level=" + this.level +
                    '}';
        }

        private final K key;
        private V value;
        /**
         * debug 使用
         * 指示当前生成的层次是什么
         */
        private int level;
        /**
         * 当前这个节点在 i 层的前一个节点
         */
        private Node<K, V>[] pre;
        /**
         * 当前这个节点在这一层的后面的一个节点
         */
        private Node<K, V>[] last;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.pre = new Node[level];
            this.last = new Node[level];
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

    }

    private final class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator(SkipList.this.head);
        }

        @Override
        public int size() {
            return SkipList.this.size;
        }
    }

    /**
     * 由于跳表的特性
     * 所以在 level = 0 这一层一定是包含所有的数据
     * 实际上只需要遍历这一层即可
     */
    private final class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /**
         * 当前节点的数据
         */
        private Node<K, V> cur;
        /**
         * 上一轮访问的节点数据
         */
        private Node<K, V> pre;

        public EntryIterator(Node<K, V> head) {
            this.cur = head.last[0];
            this.pre = head;
        }

        @Override
        public boolean hasNext() {
            return cur != null && cur != SkipList.this.tail;
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.pre = cur;
            this.cur = cur.last[0];
            return this.pre;
        }
    }

    public static void main(String[] args) {
        SkipList<Integer, Integer> skipList = new SkipList<>();

        skipList.put(1, 2);
        skipList.put(2, 3);
        skipList.put(1, 3);
        skipList.put(5, 6);
        skipList.put(4, 12);
        skipList.remove(4);
        skipList.put(10, 11);
        skipList.put(-1, 12);

        for (Map.Entry<Integer, Integer> entry : skipList.entrySet()) {
            System.out.printf("%d %d \t", entry.getKey(), entry.getValue());
        }
    }
}
