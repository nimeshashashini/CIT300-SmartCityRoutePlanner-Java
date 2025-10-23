package smartcityroutetraversal;
import java.util.*;

public class Traversal {
    private Graph graph;

    public Traversal(Graph graph) {
        this.graph = graph;
    }

    // Breadth-First Search (BFS)
    public void bfsTraversal(String start) {
        Map<String, List<String>> cityGraph = graph.getGraph();
        if (!cityGraph.containsKey(start)) {
            System.out.println("Starting location '" + start + "' not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        System.out.println("\nBFS traversal from '" + start + "':");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (!visited.contains(current)) {
                System.out.print(current + " → ");
                visited.add(current);
                for (String neighbor : cityGraph.get(current)) {
                    if (!visited.contains(neighbor))
                        queue.add(neighbor);
                }
            }
        }
        System.out.println("END\n");
    }
}
