package highFrequency.design;

import java.util.*;

public class RandomizedSet {

    private List<Integer> indexes;
    // 保存对应数字的 对应 index
    private Map<Integer, Integer> map;
    private Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.indexes = new ArrayList<>();
        this.map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        }
        this.map.put(val, this.indexes.size());
        this.indexes.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        }
        int index = this.map.get(val);
        // 与最后一位交换
        int last = this.indexes.get(this.indexes.size() - 1);
        this.indexes.set(index, last);
        // 更新索引
        this.map.put(last, index);
        this.map.remove(val);
        this.indexes.remove(this.indexes.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return this.indexes.get(rand.nextInt(this.indexes.size()));
    }
}
