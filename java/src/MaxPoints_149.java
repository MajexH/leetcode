import java.util.*;

public class MaxPoints_149 {

    private static class Line {

        private double k, b = 0;
        public boolean isVertical;

        public Line(int a, int b, int c, int d) {
            this.k = calculateK(a, b, c, d);
            this.b = calculateB(a, b);
            this.isVertical = false;
        }

        public Line(int k) {
            this.k = k;
            this.isVertical = true;
        }

        private double calculateK(int x1, int y1, int x2, int y2) {
            return (double)(y1 - y2) / (x1 - x2);
        }

        private double calculateB(int x, int y) {
            return y - this.k * x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.k, k) == 0 && Double.compare(line.b, b) == 0 && isVertical == line.isVertical;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k, b, isVertical);
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // 问有多少个点在一个直线上
    public int maxPoints(int[][] points) {
        if (points.length <= 1) return points.length;
        Map<Line, Set<Point>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line l = null;
                // 垂直的特殊处理 垂直的会报错
                if (points[i][0] == points[j][0]) {
                    // 垂直的
                    l = new Line(points[i][0]);
                } else {
                    l = new Line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
                if (!map.containsKey(l))  map.put(l, new HashSet<>());
                Set<Point> set = map.get(l);
                set.add(new Point(points[i][0], points[i][1]));
                set.add(new Point(points[j][0], points[j][1]));

                res = Math.max(res, set.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPoints_149().maxPoints(new int[][]{{1,1}}));
    }
}
