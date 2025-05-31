package May;

import java.util.*;

public class WordladderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, wordSet, graph, distance);
        dfs(beginWord, endWord, graph, distance, new ArrayList<>(), result);

        return result;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordSet,
                     Map<String, List<String>> graph, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int currDist = distance.get(word);
                for (String neighbor : getNeighbors(word, wordSet)) {
                    graph.computeIfAbsent(word, k -> new ArrayList<>()).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDist + 1);
                        if (neighbor.equals(endWord)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            if (foundEnd) break;
        }
    }

    private void dfs(String current, String endWord, Map<String, List<String>> graph,
                     Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(current);
        if (current.equals(endWord)) {
            result.add(new ArrayList<>(path));
        } else {
            List<String> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (String neighbor : neighbors) {
                if (distance.get(neighbor) == distance.get(current) + 1) {
                    dfs(neighbor, endWord, graph, distance, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }

    // Driver code
    public static void main(String[] args) {
        WordladderII solver = new WordladderII();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");

        System.out.println("Example 1:");
        System.out.println(solver.findLadders(beginWord, endWord, wordList1));

        System.out.println("Example 2:");
        System.out.println(solver.findLadders(beginWord, endWord, wordList2));
    }
}
