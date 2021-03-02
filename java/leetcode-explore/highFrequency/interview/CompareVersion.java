package highFrequency.interview;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        for (int i = 0, j = 0; i < ver1.length || j < ver2.length; i++, j++) {
            int v1 = i < ver1.length ? Integer.parseInt(ver1[i]) : 0;
            int v2 = j < ver2.length ? Integer.parseInt(ver2[j]) : 0;

            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("1.0", "1.0.0"));
    }
}
