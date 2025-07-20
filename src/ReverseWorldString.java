package July;

public class ReverseWorldString {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        // Step 2: Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String s1 = "  hello world  ";
        String s2 = "a good   example";

        System.out.println("\"" + reverseWords(s1) + "\""); // Output: "world hello"
        System.out.println("\"" + reverseWords(s2) + "\""); // Output: "example good a"
    }
}
