package July;

import java.util.HashMap;
import java.util.Map;

public class MaxPointinOnLine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int overlap = 0;
            int currMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Handle overlapping points
                if (dx == 0 && dy == 0) {
                    overlap++;
                    continue;
                }

                // Normalize the slope using gcd
                int gcd = gcd(dy, dx);
                dy /= gcd;
                dx /= gcd;

                // Keep slope representation consistent for vertical lines
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dy + "/" + dx;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                currMax = Math.max(currMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, currMax + overlap + 1); // +1 for the original point
        }

        return maxPoints;
    }

    // Helper function to compute GCD
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
