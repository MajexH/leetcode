import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangminjie
 * @since 2022/3/16
 */
public class SkipList<K, V> extends AbstractMap<K, V> implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 最大层次
     */
    private static final int MAX_LEVEL = 32;

    /**
     * 每个节点插入的时候的 random 因子数大小
     * 用于生成其随机 level
     */
    private static final double LEVEL_FACTOR = 0.5D;

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * 每个 Node 抽象一个存储的节点
     * 其持有 k v
     */
    public static class Node<K, V> {
        private final K key;
        private V v;
        /**
         * 当前这个节点前面的
         */
        private Node<K, V>[] pre;
        /**
         * 当前这个节点后面的
         */
        private Node<K, V>[] last;

        public Node(K key, V v, int level) {
            this.key = key;
            this.v = v;
            this.pre = new Node[level];
            this.last = new Node[level];
        }

        public K getKey() {
            return key;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }
    }

    /**
     * 当前的 curLevel
     */
    private int curLevel = 0;

    private int size = 0;

    private Node<K, V>[] head = new Node[32];

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public V get(Object key) {
        for (int i = curLevel; i >= 0; i--) {
            Node<K, V>[] last = head[curLevel].last;
            for (Node<K, V> mv : last) {
                if (mv) {

                }
            }
        }
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {

    }

    @Override
    public V put(K key, V val) {

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


    public static void main(String[] args) {

    }
}
