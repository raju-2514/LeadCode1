package Basic;

import java.util.ArrayList;
import java.util.List;

public class ListCode {

    public static List<Integer> printData(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {  // Use < instead of <=
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 5, 6};
        System.out.println(printData(arr));
    }
}
