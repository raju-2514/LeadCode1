package February;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertIntervals {
    public int[][] insert(int[][] intervals,int[] newIntervals){
        LinkedList<int[]> result=new LinkedList<>();
        int i=0,n=intervals.length;

        while (i<n && intervals[i][1]<newIntervals[0]){
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newIntervals[1]) {
            newIntervals[0] = Math.min(newIntervals[0], intervals[i][0]);
            newIntervals[1] = Math.max(newIntervals[1], intervals[i][1]);
            i++;
        }
        result.add(newIntervals);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        InsertIntervals solution = new InsertIntervals();
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};
        System.out.println(Arrays.deepToString(solution.insert(intervals1, newInterval1)));
    }
}
