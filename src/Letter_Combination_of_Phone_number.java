package January;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combination_of_Phone_number {
    public List<String> letterCombinations(String digits) {

    if (digits==null|| digits.length() ==0) {
        return new ArrayList<>();
    }
    String[] mappings={
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    List<String> result=new ArrayList<>();
        backtrack(result, digits, mappings, 0, new StringBuilder());
        return result;

    }

    private void backtrack(List<String> result, String digits, String[] mappings, int index, StringBuilder current) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = mappings[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Add the letter
            backtrack(result, digits, mappings, index + 1, current);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
    public static void main(String[] args) {
        Letter_Combination_of_Phone_number obj = new Letter_Combination_of_Phone_number();

        // Example 1
        System.out.println(obj.letterCombinations("23")); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]

        // Example 2
        System.out.println(obj.letterCombinations("")); // Output: []

        // Example 3
        System.out.println(obj.letterCombinations("2")); // Output: [a, b, c]

    }
}
