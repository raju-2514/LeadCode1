package December;

public class Zigzag_Conversation {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1, just return the string as is.
        if (numRows == 1) {
            return s;
        }

        // Initialize a list of strings for each row.
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0; // Start at the first row
        boolean goingDown = false; // Direction of traversal (down or up)

        // Iterate through the string and distribute characters to the rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If we reach the top or bottom, reverse the direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Zigzag_Conversation zigzag_conversation = new Zigzag_Conversation();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(zigzag_conversation.convert(s, numRows));
    }
}