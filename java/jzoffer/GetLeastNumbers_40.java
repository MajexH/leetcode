public class GetLeastNumbers_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        int i = 0, j = arr.length - 1;
        int index = partition(arr, i, j);
        while (index != k - 1) {
            if (index > k - 1) {
                j = index - 1;
            } else if (index < k - 1) {
                i = index + 1;
            }
            index = partition(arr, i, j);
        }
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private int partition(int[] arr, int start, int end) {
        int base = arr[start];
        int i = start, j = end + 1;

        while (true) {
            while (++i <= end && arr[i] < base) {
                if (i == end) break;
            }
            while (--j >= start && arr[j] > base) {
                if (j == start) break;
            }
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        if (arr[i] == arr[j]) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
