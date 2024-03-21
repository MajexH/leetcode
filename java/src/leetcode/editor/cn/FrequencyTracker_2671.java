package leetcode.editor.cn;//请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
//
// 实现 FrequencyTracker 类： 
//
// 
// FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。 
// void add(int number)：添加一个 number 到数据结构中。 
// void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内
//容。 
// bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 
//false。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["FrequencyTracker", "add", "add", "hasFrequency"]
//[[], [3], [3], [2]]
//输出
//[null, null, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
//frequency System.out.println(tracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
// 
//
// 示例 2： 
//
// 
//输入
//["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
//[[], [1], [1], [1]]
//输出
//[null, null, null, false]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequencyTracker.add(1); // 数据结构现在包含 [1]
//frequencyTracker.deleteOne(1); // 数据结构现在为空 []
//frequency System.out.println(tracker.hasFrequency(1); // 返回 false ，因为数据结构为空
// 
//
// 示例 3： 
//
// 
//输入
//["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
//[[], [2], [3], [1]]
//输出
//[null, false, null, true]
//
//解释
//FrequencyTracker frequencyTracker = new FrequencyTracker();
//frequency System.out.println(tracker.hasFrequency(2); // 返回 false ，因为数据结构为空
//frequencyTracker.add(3); // 数据结构现在包含 [3]
//frequency System.out.println(tracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
// 
//
// 
//
// 提示： 
//
// 
// 1 <= number <= 10⁵ 
// 1 <= frequency <= 10⁵ 
// 最多调用 add、deleteOne 和 hasFrequency 共计 2 * 10⁵ 次 
// 
//
// Related Topics 设计 哈希表 👍 36 👎 0


import java.util.*;

public class FrequencyTracker_2671 {
    public static void main(String[] args) {

        FrequencyTracker_2671.FrequencyTracker tracker = new FrequencyTracker_2671().new FrequencyTracker();

        System.out.println(tracker.hasFrequency(1));
        tracker.add(3);
        tracker.add(1);
        System.out.println(tracker.hasFrequency(1));
        tracker.add(3);
        System.out.println(tracker.hasFrequency(2));
        tracker.add(1);
        System.out.println(tracker.hasFrequency(2));
        tracker.deleteOne(10);
        System.out.println(tracker.hasFrequency(2));
        tracker.deleteOne(6);
        tracker.add(7);
        tracker.deleteOne(10);
        System.out.println(tracker.hasFrequency(2));
        System.out.println(tracker.hasFrequency(1));
        tracker.add(1);
        tracker.add(2);
        tracker.add(3);
        System.out.println(tracker.hasFrequency(1));
        tracker.deleteOne(3);
        System.out.println(tracker.hasFrequency(2));
        System.out.println(tracker.hasFrequency(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class FrequencyTracker {

        private Map<Integer, Integer> numbers;
        private Map<Integer, Set<Integer>> frequencies;

        public FrequencyTracker() {
            this.numbers = new HashMap<>();
            this.frequencies = new HashMap<>();
        }

        public void add(int number) {

            if (this.numbers.containsKey(number)) {
                Integer oldFrequency = this.numbers.get(number);
                // 从老的里面清除
                this.frequencies.get(oldFrequency).remove(number);
            }

            int newFrequency = this.numbers.getOrDefault(number, 0) + 1;
            // 更新 number
            this.numbers.put(number, newFrequency);
            // 更新 frequency
            if (!this.frequencies.containsKey(newFrequency)) {
                this.frequencies.put(newFrequency, new HashSet<>());
            }
            this.frequencies.get(newFrequency).add(number);
        }

        // 减少一次
        public void deleteOne(int number) {

            if (!this.numbers.containsKey(number)) {
                return;
            }

            Integer frequency = this.numbers.get(number);
            this.frequencies.get(frequency).remove(number);

            int newFrequency = frequency - 1;

            if (newFrequency == 0) {
                this.numbers.remove(number);
            } else {
                this.numbers.put(number, newFrequency);
                if (!this.frequencies.containsKey(newFrequency)) {
                    this.frequencies.put(newFrequency, new HashSet<>());
                }
                this.frequencies.get(newFrequency).add(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return this.frequencies.containsKey(frequency) &&
                    Objects.nonNull(this.frequencies.get(frequency)) &&
                    !this.frequencies.get(frequency).isEmpty();
        }
    }

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
//leetcode submit region end(Prohibit modification and deletion)

}