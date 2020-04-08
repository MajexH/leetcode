import java.util.*;

public class WordBreakII_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        return DFS(s, dict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        List<String> res = recursion(dict, s, 0, new HashMap<>());
        return res == null ? new ArrayList<>() : res;
    }

    public List<String> recursion(HashSet<String> dict, String s, int index, HashMap<Integer, List<String>> memo) {
        List<String> res = new ArrayList<>();
        if (index == s.length()) return res;
        if (memo.containsKey(index)) return memo.get(index);
        for (int i = index + 1; i <= s.length(); i++) {
            String tempStr = s.substring(index, i);
            if (dict.contains(tempStr)) {
                List<String> temp = recursion(dict, s, i, memo);
                if (temp == null) return null;
                if (temp.size() == 0) {
                    res.add(tempStr);
                    return res;
                } else {
                    for (String tempStrForTempArray : temp) {
                        res.add(tempStr + " " + tempStrForTempArray);
                    }
                }
            }
        }
        if (res.size() == 0) res = null;
        memo.put(index, res);
        return res;
    }


//    public List<String> wordBreak1(String s, List<String> wordDict) {
//        HashSet<String> dict = new HashSet<>(wordDict);
//        List<String> res = new ArrayList<>();
//        recursion(dict, s, 0, res, new ArrayList<>());
//        return res;
//    }
//
//    public void recursion(HashSet<String> dict, String s, int index, List<String> res, ArrayList<String> temp) {
//        if (index == s.length()) {
//            res.add(String.join(" ", temp));
//            return;
//        }
//        for (int i = index + 1; i <= s.length(); i++) {
//            String tempStr = s.substring(index, i);
//            if (dict.contains(tempStr)) {
//                temp.add(tempStr);
//                recursion(dict, s, i, res, temp);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        String[] strsTemp = new String[]{"cats","dog","sand","and","cat"};
        System.out.println(new WordBreakII_140().wordBreak("catsandog", new ArrayList<>(Arrays.asList(strsTemp))));
    }
}
