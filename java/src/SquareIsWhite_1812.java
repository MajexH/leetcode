public class SquareIsWhite_1812 {

    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '0';
        if ((y & 1) == 1) {
            return (x & 1) == 1;
        } else {
            return (x & 1) == 0;
        }
    }
}
