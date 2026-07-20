class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n <= 2) return true;

        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;

        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            // cross product check: (y - y0) * dx == (x - x0) * dy
            if ((long)(y - y0) * dx != (long)(x - x0) * dy) {
                return false;
            }
        }
        return true;
    }
}
