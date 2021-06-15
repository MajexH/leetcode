public class PeakIndexInMountainArray_852 {

    public int peakIndexInMountainArrayWithBinarySearch(int[] arr) {
        if (arr.length < 3) return -1;
        int i = 0, j = arr.length - 2;
        int res = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // res 是上一个区间的最大值
                res = mid;
                // 现在要判断下一个区间
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return res;
    }

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length < 3) return -1;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }

        for (int j = arr.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], arr[j + 1]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > leftMax[i] && arr[i] > rightMax[i]) return i;
        }
        return -1;
    }
}
