package iterator;

public class ArrayIterator implements BaseIterator {

    // 保存遍历的下标
    private int index;
    // 遍历的数组
    private int[] nums;

    public ArrayIterator(int[] nums) {
        this.nums = nums;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < nums.length;
    }

    @Override
    public Object next() {
        return this.nums[this.index++];
    }
}
