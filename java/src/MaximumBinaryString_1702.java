public class MaximumBinaryString_1702 {

    public String maximumBinaryString(String binary) {
        StringBuilder builder = new StringBuilder();
        // 其实就是把 1 往左靠 那么遇到 011110 就可以变为 101111
        // 也就是说 遇到两个 00 就应该把结果 就要把左侧添加一个 1 右侧删除一个 0

        // index 指向上一个为 0 的地址
        int j = 0, index = -1;
        int zeroNum = 0;

        while (j < binary.length()) {
            if (binary.charAt(j) == '1') {
                builder.append('1');
            } else if (zeroNum == 0) {
                builder.append('0');
                zeroNum++;
                index = j;
            } else {
                // 第二次找到
                builder.insert(index, '1');
                index++;
            }
            j++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumBinaryString_1702().maximumBinaryString("000110"));
//        System.out.println(new MaximumBinaryString_1702().maximumBinaryString("01"));
    }
}
