public class LargestMagicSquare_1895 {

    private static class Triple {
        int row;
        int column;
        int obliqueLeft;
        int obliqueRight;
    }

    // 找到 grid 里面的最大的幻方
    // 幻方说的是 每一列 每一行 每一个斜着的行 的和均相等
    public int largestMagicSquare(int[][] grid) {
        Triple[][] sums = new Triple[grid.length][];
        int maxSquare = 1;
        for (int i = 0; i < grid.length; i++) {
            sums[i] = new Triple[grid[i].length];
            for (int j = 0; j < grid[i].length; j++) {
                sums[i][j] = new Triple();
                // 传递数据
                sums[i][j].column = (i - 1 >= 0 ? sums[i - 1][j].column : 0) + grid[i][j];
                sums[i][j].row = (j - 1 >= 0 ? sums[i][j - 1].row : 0) + grid[i][j];
                sums[i][j].obliqueLeft = ((i - 1 >= 0 && j - 1 >= 0) ? sums[i - 1][j - 1].obliqueLeft : 0) + grid[i][j];
                sums[i][j].obliqueRight = ((i - 1 >= 0 && j + 1 < grid[i - 1].length) ? sums[i - 1][j + 1].obliqueRight : 0) + grid[i][j];

                // 分隔
                for (int k = 0; k <= Math.min(i, j); k++) {
                    int left = j - k, height = i - k;
                    // 计算几个方向
                    int base = sums[i][j].row - (left - 1 >= 0 ? sums[i][left - 1].row : 0);
                    // 斜边
                    int obliqueLeft = sums[i][j].obliqueLeft - ((left - 1 >= 0 && height - 1 >= 0) ? sums[height - 1][left - 1].obliqueLeft : 0);
                    if (obliqueLeft != base) continue;
                    int obliqueRight = sums[i][left].obliqueRight - sums[height][j].obliqueRight + grid[height][j];
                    if (obliqueRight != base) continue;

                    boolean flag = true;
                    // 检查每一个横行
                    for (int z = height; z <= i; z++) {
                        int tmp = sums[z][j].row - sums[z][left].row + grid[z][left];
                        if (tmp != base) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) continue;
                    // 检查每一个竖行
                    for (int z = left; z <= j; z++) {
                        int tmp = sums[i][z].column - sums[height][z].column + grid[height][z];
                        if (tmp != base) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) continue;
                    maxSquare = Math.max(maxSquare, k + 1);
                }
            }
        }
        return maxSquare;
    }

    public static void main(String[] args) {
        System.out.println(new LargestMagicSquare_1895().largestMagicSquare(new int[][]{
                {7, 1, 4, 5, 6},
                {2, 5, 1, 6, 4},
                {1, 5, 4, 3, 2},
                {1, 2, 7, 3, 4}
        }));
        System.out.println(new LargestMagicSquare_1895().largestMagicSquare(new int[][]{
                {5, 1, 3, 1},
                {9, 3, 3, 1},
                {1, 3, 3, 8}
        }));
    }
}
