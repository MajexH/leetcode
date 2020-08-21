public class CompareVersion_165 {

    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        for (int i = 0, j = 0; i < v1s.length || j < v2s.length; i++, j++) {
            int v1 = i >= v1s.length ? 0 : Integer.parseInt(v1s[i]);
            int v2 = j >= v2s.length ? 0 : Integer.parseInt(v2s[j]);

            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion_165().compareVersion("0.1", "1.1"));
    }
}
