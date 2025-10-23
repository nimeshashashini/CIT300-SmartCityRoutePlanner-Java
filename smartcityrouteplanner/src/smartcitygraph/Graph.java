package smartcitygraph;
import java.util.*;

public class Graph {
    private Map<String, List<String>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    // Add a new location (node)
    public void addLocation(String location) {
        if (!graph.containsKey(location)) {
            graph.put(location, new ArrayList<>());
            System.out.println("Location '" + location + "' added successfully.");
        } else {
            System.out.println("Location '" + location + "' already exists!");
        }
    }

    // Remove a location (node)
    public void removeLocation(String location) {
        if (graph.containsKey(location)) {
            graph.remove(location);
            for (List<String> roads : graph.values()) {
                roads.remove(location);
            }
            System.out.println("Location '" + location + "' removed successfully.");
        } else {
            System.out.println("Location '" + location + "' not found!");
        }
    }

    // Add a road (edge)
    public void addRoad(String loc1, String loc2) {
        if (graph.containsKey(loc1) && graph.containsKey(loc2)) {
            if (!graph.get(loc1).contains(loc2)) {
                graph.get(loc1).add(loc2);
                graph.get(loc2).add(loc1);
                System.out.println("Road added between " + loc1 + " and " + loc2 + ".");
            } else {
                System.out.println("Road already exists between " + loc1 + " and " + loc2 + ".");
            }
        } else {
            System.out.println("Both locations must exist before adding a road.");
        }
    }

    // Remove a road (edge)
    public void removeRoad(String loc1, String loc2) {
        if (graph.containsKey(loc1) && graph.get(loc1).contains(loc2)) {
            graph.get(loc1).remove(loc2);
            graph.get(loc2).remove(loc1);
            System.out.println("Road removed between " + loc1 + " and " + loc2 + ".");
        } else {
            System.out.println("Road not found or locations invalid.");
        }
    }

    // Display all connections
    public void displayConnections() {
        System.out.println("\n--- All City Connections ---");
        for (String loc : graph.keySet()) {
            System.out.println(loc + " → " + graph.get(loc));
        }
        System.out.println("-----------------------------\n");
    }

    // Getter
    public Map<String, List<String>> getGraph() {
        return graph;
    }
}

