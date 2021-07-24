public class MaximumTime_1736 {

    public String maximumTime(String time) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c != '?') {
                builder.append(c);
                continue;
            }

            builder.append(max(i, builder, time));
        }

        return builder.toString();
    }

    private int max(int index, StringBuilder builder, String time) {
        switch (index) {
            case 0:
                if (time.charAt(index + 1) == '?' || time.charAt(index + 1) <= '3') {
                    return 2;
                } else {
                    return 1;
                }
            case 1:
                if (builder.charAt(0) == '2') {
                    return 3;
                } else {
                    return 9;
                }
            case 3:
                return 5;
            case 4:
                return 9;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumTime_1736().maximumTime("??:3?"));
        System.out.println(new MaximumTime_1736().maximumTime("0?:3?"));
        System.out.println(new MaximumTime_1736().maximumTime("1?:22"));
    }
}
