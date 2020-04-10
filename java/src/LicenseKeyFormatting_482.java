import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LicenseKeyFormatting_482 {

    public String licenseKeyFormatting(String S, int K) {

        String str = String.join("", S.split("-"));

        List<String> strs = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i -= K) {
            if (i - K >= 0)
                strs.add(str.substring(i - K + 1, i + 1).toUpperCase());
            else
                strs.add(str.substring(0, i + 1).toUpperCase());
        }

        Collections.reverse(strs);
        return String.join("-", strs);
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting_482().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
