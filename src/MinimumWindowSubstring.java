package March;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);

            if (tMap.containsKey(rChar) && sMap.get(rChar) <= tMap.get(rChar)) {
                count++;
            }

            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLeft = left;
                    minLen = right - left + 1;
                }

                char lChar = s.charAt(left);
                sMap.put(lChar, sMap.get(lChar) - 1);

                if (tMap.containsKey(lChar) && sMap.get(lChar) < tMap.get(lChar)) {
                    count--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(minWindow("a", "a")); // Output: "a"
        System.out.println(minWindow("a", "aa")); // Output: ""
    }
}
