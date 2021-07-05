import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOfAtoms_726 {

    public String countOfAtoms(String formula) {
        Map<String, Integer> counter = new HashMap<>();

        recursion(formula, 0, counter);

        StringBuilder builder = new StringBuilder();
        List<String> keys = counter.keySet().stream().sorted().collect(Collectors.toList());
        for (String key : keys) {
            builder.append(key);
            if (counter.get(key) > 1) builder.append(counter.get(key));
        }
        return builder.toString();
    }

    private int recursion(String formula, int index, Map<String, Integer> tmp) {
        int i = index;
        for (; i < formula.length(); ) {
            char c = formula.charAt(i);
            if (isUpperLetter(c)) {
                int j = i + 1;
                // 大写字母 读到数字为止 为一个元素
                for (; j < formula.length() && isLowerLetter(formula.charAt(j)); j++) {
                }
                String atom = formula.substring(i, j);

                Pair number = formatDigital(formula, j);
                int count = 1;
                if (number.count == 0) {
                    i = j;
                } else {
                    i = number.index;
                    count = number.count;
                }
                tmp.put(atom, tmp.getOrDefault(atom, 0) + count);
                continue;
            }
            // 说明要递归
            if (c == '(') {
                Map<String, Integer> sub = new HashMap<>();
                i = recursion(formula, i + 1, sub);
                for (String key : sub.keySet()) {
                    tmp.put(key, tmp.getOrDefault(key, 0) + sub.get(key));
                }
                continue;
            }
            // 结束递归
            if (c == ')') {
                int count = 1;
                int j = i + 1;
                Pair number = formatDigital(formula, j);
                if (number.count == 0) {
                    i = j;
                } else {
                    i = number.index;
                    count = number.count;
                }

                for (String key : tmp.keySet()) {
                    tmp.put(key, tmp.get(key) * count);
                }
                return i;
            }
        }
        return i;
    }

    private static class Pair {
        int index;
        int count;

        public Pair(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public Pair formatDigital(String formula, int index) {
        int j = index;
        for (; j < formula.length() && Character.isDigit(formula.charAt(j)); j++) {
        }
        return new Pair(j, j == index ? 0 : Integer.parseInt(formula.substring(index, j)));
    }

    private boolean isUpperLetter(char a) {
        return a >= 'A' && a <= 'Z';
    }

    private boolean isLowerLetter(char a) {
        return a >= 'a' && a <= 'z';
    }

    public static void main(String[] args) {
        System.out.println(new CountOfAtoms_726().countOfAtoms("NO3N46"));
        System.out.println(new CountOfAtoms_726().countOfAtoms("Mg(OH)2"));
        System.out.println(new CountOfAtoms_726().countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println(new CountOfAtoms_726().countOfAtoms("Be32"));

    }
}
