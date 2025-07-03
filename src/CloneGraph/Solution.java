package July.CloneGraph;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Node, Node> map=new HashMap<>();
    public Node cloneGraph(Node node){
     if(node==null) return null;
     Node newNode=new Node(node.val);
     map.put(node,newNode);

     for(Node n:node.neighbors){
         if(map.containsKey(n)){
             newNode.neighbors.add(map.get(n));
         }
         else{
             newNode.neighbors.add(cloneGraph(n));
         }
     }
     return newNode;

    }




        public static void main(String[] args) {
            // Create test graph: 1 -- 2
            //                   |    |
            //                   4 -- 3

            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);

            node1.neighbors.add(node2);
            node1.neighbors.add(node4);

            node2.neighbors.add(node1);
            node2.neighbors.add(node3);

            node3.neighbors.add(node2);
            node3.neighbors.add(node4);

            node4.neighbors.add(node1);
            node4.neighbors.add(node3);

            // Clone the graph
            Solution solution = new Solution();
            Node clonedGraph = solution.cloneGraph(node1);

            // Print the result
            System.out.println("Original Node: " + node1.val);
            System.out.println("Cloned Node: " + clonedGraph.val);
            System.out.println("Cloned Neighbors: " +
                    clonedGraph.neighbors.stream().map(n -> n.val).toList());
        }
    }

