package highFrequency.Immutate;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] versionsFor1 = version1.split("\\.");
        String[] versionsFor2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < versionsFor1.length || j < versionsFor2.length) {
            int vNumberFor1 = i < versionsFor1.length ? Integer.parseInt(versionsFor1[i]) : 0;
            int vNumberFor2 = j < versionsFor2.length ? Integer.parseInt(versionsFor2[j]) : 0;
            if (vNumberFor1 > vNumberFor2) return 1;
            else if (vNumberFor1 < vNumberFor2) return -1;
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("0.1", "1.1"));
        System.out.println(new CompareVersion().compareVersion("1.0.1", "1"));
        System.out.println(new CompareVersion().compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(new CompareVersion().compareVersion("1.01", "1.001"));
        System.out.println(new CompareVersion().compareVersion("1.0", "1.0.0"));
    }
}
