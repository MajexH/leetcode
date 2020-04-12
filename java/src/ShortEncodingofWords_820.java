import java.util.HashMap;

public class ShortEncodingofWords_820 {

    class Tier {
        HashMap<Character, Tier> children = new HashMap<>();

        public Tier add(Character character) {
            if (!children.containsKey(character)) {
                children.put(character, new Tier());
            }
            return children.get(character);
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Tier tier = new Tier();
        HashMap<Tier, Integer> map = new HashMap<>();
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            Tier cur = tier;
            for (int i = word.length() - 1; i >= 0; i--) {
                cur = cur.add(word.charAt(i));
            }
            map.put(cur, j);
        }
        int res = 0;
        for (Tier temp : map.keySet()) {
            if (temp.children.size() == 0) {
                res += words[map.get(temp)].length() + 1;
            }
        }
        return res;
    }
}
