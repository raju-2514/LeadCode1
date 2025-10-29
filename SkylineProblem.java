package October;

import java.util.*;

public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> edges = new ArrayList<>();

        // Break each building into two edges: start and end
        for (int[] b : buildings) {
            edges.add(new int[]{b[0], b[2]});  // start of building
            edges.add(new int[]{b[1], -b[2]}); // end of building
        }

        // Sort edges
        Collections.sort(edges, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // sort by x
            return b[1] - a[1]; // higher height first
        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0); // ground level initially
        int prevMax = 0;

        for (int[] edge : edges) {
            int x = edge[0];
            int h = edge[1];

            if (h > 0) {
                pq.add(h); // building enters
            } else {
                pq.remove(-h); // building leaves
            }

            int currMax = pq.peek();
            if (currMax != prevMax) {
                result.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SkylineProblem sp = new SkylineProblem();
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(sp.getSkyline(buildings));
    }
}
