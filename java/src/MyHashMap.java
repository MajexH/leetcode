import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;

public class MyHashMap {

    // 拉链法
    private static class Node {
        int key, val;
        int hashcode;
        Node next;

        public Node(int key, int val, int hashcode) {
            this.key = key;
            this.val = val;
            this.hashcode = hashcode;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", hashcode=" + hashcode +
                    ", next=" + next +
                    '}';
        }
    }

    private int DEFAULT_CAPACITY = 16;

    private Node[] nodes;
    private int size;
    // 负载因子
    private double factor = 0.75;
    private int threshold = (int) (DEFAULT_CAPACITY * factor);


    public MyHashMap() {
        this.nodes = new Node[16];

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hashcode = Integer.hashCode(key);
        int index = hashcode & (this.nodes.length - 1);
        if (!headPut(index, hashcode, key, value, nodes)) return;
        if (++size >= threshold) grow();
    }

    // 返回加入成功或者失败
    private boolean headPut(int index, int hashcode, int key, int value, Node[] nodes) {
        // 头插法插入
        Node tmp = nodes[index];
        while (tmp != null) {
            // 找到重复 key 跳出
            if (tmp.key == key) {
                tmp.val = value;
                return false;
            }
            tmp = tmp.next;
        }
        Node newHead = new Node(key, value, hashcode);
        newHead.next = nodes[index];
        nodes[index] = newHead;
        return true;
    }

    // 重新定位
    private void grow() {
        int newCapacity = this.nodes.length << 1;
        int newThreshold = (int) (newCapacity * this.factor);
        int oldCapacity = this.nodes.length;

        Node[] newNodes = new Node[newCapacity];
        this.threshold = newThreshold;
        // 头插法比较简单 但是会有问题
        // 实际上用一个 NodeHolder 抓住整个 node 保存 头尾 更方便
        for (int i = 0; i < oldCapacity; i++) {
            Node old = this.nodes[i];
            while (old != null) {
                // 根据原来的 hashcode 进去在新数组的位置 下面这个是由数学特性得到的
                int newIndex = (old.hashcode & oldCapacity) == 0 ? i : i + oldCapacity;
                headPut(newIndex, old.hashcode, old.key, old.val, newNodes);
                old = old.next;
            }
            this.nodes[i] = null;
        }
        this.nodes = newNodes;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hashcode = Integer.hashCode(key);
        int index = hashcode & (this.nodes.length - 1);

        Node tmp = this.nodes[index];

        while (tmp != null) {
            if (tmp.key == key) return tmp.val;
            tmp = tmp.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hashcode = Integer.hashCode(key);
        int index = hashcode & (this.nodes.length - 1);

        Node tmp = this.nodes[index];

        if (tmp == null) return;
        // 头是 key
        if (tmp.key == key) {
            this.nodes[index] = tmp.next;
            --size;
            return;
        }

        // 开始删除
        Node mv = tmp.next;
        while (mv != null) {
            if (mv.key == key) {
                tmp.next = mv.next;
                --size;
                return;
            }
            mv = mv.next;
            tmp = tmp.next;
        }
        // 没有找到
    }


    public static void main(String[] args) throws IOException {
        MyHashMap map = new MyHashMap();
        Writer out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write("[null,");
        map.put(504, 155);
        map.remove(89);
        out.write("," + String.valueOf(map.get(334)));
        out.flush();
    }
}
