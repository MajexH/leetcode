import java.util.Scanner;

public class Direction {

    public static void main(String[] args) {
        // 方向 左转 +1 右转 -1
        char[] directions = new char[]{ 'N', 'W', 'S', 'E' };
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String direction = scanner.next();
        int currentDirection = 0;
        for (int i = 0; i < n; i++) {
            switch (direction.charAt(i)) {
                case 'L':
                    currentDirection = (currentDirection + 1) % 4;
                    break;
                case 'R':
                    currentDirection = currentDirection == 0 ? 3 : currentDirection - 1;
                    break;
            }
        }
        System.out.println(directions[currentDirection]);
    }
}
