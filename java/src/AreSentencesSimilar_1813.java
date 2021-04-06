public class AreSentencesSimilar_1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s2.length > s1.length) return areSentencesSimilar(sentence2, sentence1);
        // 从左向右匹配
        int l = 0;
        while (l < s2.length && s1[l].equals(s2[l])) {
            l++;
        }
        if (l == s2.length) return true;
        int r = s2.length - 1;
        int r1 = s1.length - 1;
        // 从右向左匹配
        while (r >= 0 && s1[r1].equals(s2[r])) {
            r--;
            r1--;
        }
        return r + 1 == l;
    }

    public static void main(String[] args) {
        System.out.println(new AreSentencesSimilar_1813().areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(new AreSentencesSimilar_1813().areSentencesSimilar("Eating right now", "Eating"));
        System.out.println(new AreSentencesSimilar_1813().areSentencesSimilar("Luky", "Lucccky"));
    }
}
