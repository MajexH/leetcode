import java.util.Arrays;

public class ChalkReplacer_5768 {

    public int chalkReplacer(int[] chalk, int k) {
        if (chalk.length == 0) return 0;
        long sum = 0L;
        for (int c : chalk) {
            sum += c;
        }
        // 一轮就要消耗 这么多 所以直接模一下 让他只用一轮就消耗完
        long remove = (long) k % sum;

        for (int i = 0; i < chalk.length; i++) {
            if (remove < chalk[i]) return i;
            remove -= chalk[i];
        }
        return chalk.length - 1;
    }
}
