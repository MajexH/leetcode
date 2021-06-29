public class ConvertToTitle_168 {

    // 26 进制
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();

        while (columnNumber > 0) {
            int tmp = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            builder.insert(0, transfer(tmp));
            columnNumber = columnNumber % 26 == 0 ? columnNumber / 26 - 1 : columnNumber / 26;
        }

        return builder.toString();
    }

    public char transfer(int num) {
        return (char) (num - 1 + 'A');
    }

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle_168().convertToTitle(52));
        System.out.println(new ConvertToTitle_168().convertToTitle(1));
        System.out.println(new ConvertToTitle_168().convertToTitle(28));
        System.out.println(new ConvertToTitle_168().convertToTitle(701));
        System.out.println(new ConvertToTitle_168().convertToTitle(2147483647));
    }
}
