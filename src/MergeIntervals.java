package February;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged=new LinkedList<>();

        for(int[] interval:intervals){
            if(merged.isEmpty() || merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1]=Math.max(merged.getLast()[1],interval[1]);
            }

        }

        return merged.toArray(new int[merged.size()][]);
}

    public static void main(String[] args) {
        MergeIntervals obj=new MergeIntervals();
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(obj.merge(intervals1)));

    }
}
