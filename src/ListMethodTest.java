package Basic;

import May.PathSum.Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListMethodTest {

    public List<Integer>  listWork(int[] arr){
        List<Integer> result=new ArrayList<>();

        System.out.println();

            for(Integer ar:arr)
            {
                result.add(ar);
            }

        System.out.println(result.getLast());
        System.out.println(result.subList(0,3));
        System.out.println(Collection.sort(result));
        return result;
    }


    public static void main(String[] args) {
        ListMethodTest lt=new ListMethodTest();
        int[] arr={98,8,2,4,82,8,4};
        System.out.println(lt.listWork(arr));
    }
}
