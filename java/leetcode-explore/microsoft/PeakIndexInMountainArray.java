package microsoft;

public class PeakIndexInMountainArray {

    // 保障输入的一定是山脉数组
    // 即 0 -> i 满足递增 i -> len 满足递减
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return -1;

        for (int i = 0; i < arr.length - 1; ) {
            if (arr[i] < arr[i + 1]) i++;
            else {
                return i;
            }
        }
        return -1;
    }
}
