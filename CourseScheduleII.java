package August;

import java.util.*;

public class CourseScheduleII {

       public int[] findOrder(int numCourses, int[][] prerequisites) {
       // Graph representation
       List<List<Integer>> graph = new ArrayList<>();
       for (int i = 0; i < numCourses; i++) {
           graph.add(new ArrayList<>());
       }

       // In-degree array
       int[] inDegree = new int[numCourses];
       for (int[] pre : prerequisites) {
           int course = pre[0];
           int prereq = pre[1];
           graph.get(prereq).add(course);
           inDegree[course]++;
       }

       // Queue for BFS
       Queue<Integer> queue = new LinkedList<>();
       for (int i = 0; i < numCourses; i++) {
           if (inDegree[i] == 0) queue.offer(i);
       }

       int[] order = new int[numCourses];
       int index = 0;

       while (!queue.isEmpty()) {
           int current = queue.poll();
           order[index++] = current;

           for (int next : graph.get(current)) {
               inDegree[next]--;
               if (inDegree[next] == 0) {
                   queue.offer(next);
               }
           }
       }

       // If not all courses were processed, return empty array
       if (index != numCourses) return new int[0];
       return order;
   }

       // Test
       public static void main(String[] args) {
       CourseScheduleII cs = new CourseScheduleII();

       int numCourses1 = 2;
       int[][] prerequisites1 = {{1,0}};
       System.out.println(Arrays.toString(cs.findOrder(numCourses1, prerequisites1))); // [0,1]

       int numCourses2 = 4;
       int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
       System.out.println(Arrays.toString(cs.findOrder(numCourses2, prerequisites2))); // [0,1,2,3] or [0,2,1,3]

       int numCourses3 = 1;
       int[][] prerequisites3 = {};
       System.out.println(Arrays.toString(cs.findOrder(numCourses3, prerequisites3))); // [0]
   }
}
