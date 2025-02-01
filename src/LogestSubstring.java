package February;

import java.util.HashSet;

public class LogestSubstring {
    public int logestSubstring(String s) {
        if(s.length() == 0 || s == null){
            return 0;
         }
        else{
            int left=0;
            int maxLen = 0;
            HashSet<Character> set = new HashSet<>();
            for(int right = 0; right < s.length(); right++){
                if(!set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                }
                else{
                    while(s.charAt(left) != s.charAt(right)){
                        set.remove(s.charAt(left));
                        left++;
                    }
                    left++;
                    set.add(s.charAt(right));
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
            return maxLen;
        }

    }
    public static void main(String[] args) {
        System.out.println(new LogestSubstring().logestSubstring("abcabcbb"));

    }
}
