/**
 * @author zhangminjie
 * @since 2022/12/11
 */
public class Allocator_6259 {

    public static void main(String[] args) {
        Allocator_6259 allocator_6259 = new Allocator_6259(10);

        System.out.println(allocator_6259.allocate(1, 1));
    }

    private int maxSize;

    // 当前分配的 mid 的列表
    private int[] array;

    public Allocator_6259(int n) {
        // 当前能够分配的最大块儿
        this.maxSize = n;
        this.array = new int[n];
    }

    public int allocate(int size, int mID) {

        int length = 0;
        for (int i = 0; i < this.maxSize; i++) {
            if (this.array[i] == 0) {
                length++;
            } else {
                // 不想当 就是 0
                length = 0;
            }

            // 长度够了
            if (length == size) {
                // 前面 n 个都置位 mId
                for (int j = i; j >= i - length + 1; j--) {
                    this.array[j] = mID;
                }
                return i - length + 1;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int res = 0;

        for (int i = 0; i < this.maxSize; i++) {
            if (this.array[i] == mID) {
                res++;
                this.array[i] = 0;
            }
        }

        return res;
    }
}
