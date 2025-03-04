package March;

import java.util.ArrayList;
import java.util.List;

public class TextJustificaiton {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - count + (numWords - 1);

            // If last line or only one word in line, left-justify
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spacesBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j < spacesBetween + (i - index < extraSpaces ? 1 : 0); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            index = last;
        }

        return result;
    }

    public static void main(String[] args) {
        TextJustificaiton tj = new TextJustificaiton();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = tj.fullJustify(words, maxWidth);

        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }
}
