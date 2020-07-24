package chapter2.array;

public class FindDuplicateInArray3 {

    /**
     * 从一个长度为 n 的数组中找到其重复的数字
     * 数组里面的数字的范围在 0 - n - 1 之间
     * (也就是说每个数字都应该在下标等于自己的值得位置 否则就是重复的)
     * @param array 输入的数组
     * @return -1 代表没有重复 否则返回这个数字的下标
     */
    public int findDuplicateInArray(int[] array) {
        if (array == null || array.length == 0) return -1;
        for (int i = 0; i < array.length - 1; i++) {
            while (i != array[i]) {
                if (array[array[i]] == i) return array[i];
                swap(array, i, array[i]);
            }
        }
        return -1;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateInArray3().findDuplicateInArray(new int[]{2,3,1,0,2,5,3}));
    }
}
