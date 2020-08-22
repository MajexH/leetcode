import java.util.*;
import java.util.stream.Collectors;

public class FindRepeatedDnaSequences_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null) return new ArrayList<>();

        // 将原字符串转换成为 数字 方便计算hash值
        Map<Character, Integer> map = new HashMap<>(){{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};

        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = map.get(s.charAt(i));
        }
        // 字符串的最大长度, power 是每次要减去的最开始的 hash 值
        int length = 10, power = (int) Math.pow(4, length);
        Set<Integer> hashes = new HashSet<>();
        Set<String> res = new HashSet<>();

        int hash = 0;
        for (int i = 0; i < s.length() - length + 1; i++) {
            if (i == 0) {
                // 计算第一个hash值
                for (int j = 0; j < length; j++) {
                    hash = hash * 4 + nums[j];
                }
            } else {
                // 重新计算hash
                hash = hash * 4 - nums[i - 1] * power + nums[i + length - 1];
            }
            if (hashes.contains(hash)) res.add(s.substring(i, i + length));
            hashes.add(hash);
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences1(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) > 1) res.add(temp);
        }
        return new ArrayList<>(res);
    }
}
