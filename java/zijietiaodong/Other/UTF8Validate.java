package Other;

public class UTF8Validate {

    public boolean validUtf8(int[] data) {
        int masks = 0x00ff;
        int first;
        int i = 0;
        do {
            // 拿到最低的8位
            first = data[i] & masks;
            int length = getLeadingOnes(first);
            if (length == 0) {
                i++;
            } else {
                // 题目规定合法的是1到4字节
                if (length == 1 || i + length > data.length || length > 4) return false;
                for (int j = i + 1; j < i + length; j++) {
                    if (!check(data[j])) return false;
                }
                i += length;
            }
        } while (i < data.length);
        return true;
    }

    public boolean check(int num) {
        num = num << 24;
        return (num & 0x80000000) == 0x80000000;
    }

    public int getLeadingOnes(int num) {
        int res = 0;
        num = num << 24;
        while ((num & 0x80000000) == 0x80000000) {
            res++;
            num = num << 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new UTF8Validate().validUtf8(new int[]{ 250,145,145,145,145 }));
    }
}
