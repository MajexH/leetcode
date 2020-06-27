package dataStructure;

import java.util.HashMap;

public class LRUCache {

    private static class LRUList {
        public LRUNode start = new LRUNode();
        public LRUNode end = new LRUNode();

        public LRUList() {
            this.start.next = this.end;
            this.end.pre = this.start;
        }

        public void add(LRUNode node) {
            node.next = this.start.next;
            node.pre = this.start;

            this.start.next.pre = node;
            this.start.next = node;
        }

        public LRUNode removeLast() {
            // 不能删除头结点
            if (this.end.pre == this.start) return null;
            LRUNode res = this.end.pre;
            res.remove();
            return res;
        }
    }

    private static class LRUNode {
        public int key;
        public int val;
        public LRUNode pre = null;
        public LRUNode next = null;

        public LRUNode() {
        }

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        // 双向链表 删除自己
        // 双向链表 是为了更好的删除自己 不然没法做
        public LRUNode remove() {
            this.pre.next = this.next;
            this.next.pre = this.pre;
            return this;
        }
    }

    private LRUList list = new LRUList();
    private int capacity;
    private int size;
    private HashMap<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            LRUNode node = this.map.get(key);
            node.remove();
            this.list.add(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            LRUNode node = this.map.get(key);
            node.val = value;

            node.remove();
            this.list.add(node);
        } else {
            LRUNode add = new LRUNode(key, value);
            if (this.size >= capacity) {
                LRUNode removed = this.list.removeLast();
                this.map.remove(removed.key);
            } else {
                this.size++;
            }
            this.map.put(key, add);
            this.list.add(add);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println( cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));     // 返回 -1 (未找到)
        System.out.println(cache.get(3));;       // 返回  3
        System.out.println(cache.get(4));;       // 返回  4
    }
}
