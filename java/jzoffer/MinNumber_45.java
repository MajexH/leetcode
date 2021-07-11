import java.util.Arrays;
import java.util.stream.Collectors;

public class MinNumber_45 {

    public String minNumber(int[] nums) {
        return Arrays.stream(nums).boxed()
                .map(String::valueOf)
                .collect(Collectors.toList())
                .stream()
                .sorted((a, b) -> (a + b).compareTo(b + a))
                .collect(Collectors.joining());
    }
}
