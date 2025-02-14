package February;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagramCode(String[] strs){
       if(strs==null || strs.length==0){
           return new ArrayList<>();
       }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagramCode(strs));
    }
}
