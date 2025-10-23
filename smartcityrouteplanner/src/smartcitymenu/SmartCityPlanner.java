package smartcitymenu;
import java.util.*;

public class SmartCityPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        LocationList list = new LocationList();
        Traversal traversal = new Traversal(graph);

        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations");
            System.out.println("7. Show route traversal (BFS)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter location name: ");
                    String loc = sc.nextLine();
                    list.insertLocation(loc);
                    graph.addLocation(loc);
                    break;

                case "2":
                    System.out.print("Enter location to remove: ");
                    String rem = sc.nextLine();
                    list.removeLocation(rem);
                    graph.removeLocation(rem);
                    break;

                case "3":
                    System.out.print("Enter first location: ");
                    String l1 = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String l2 = sc.nextLine();
                    graph.addRoad(l1, l2);
                    break;

                case "4":
                    System.out.print("Enter first location: ");
                    String r1 = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String r2 = sc.nextLine();
                    graph.removeRoad(r1, r2);
                    break;

                case "5":
                    graph.displayConnections();
                    break;

                case "6":
                    list.displayAllLocations();
                    break;

                case "7":
                    System.out.print("Enter starting location: ");
                    String start = sc.nextLine();
                    traversal.bfsTraversal(start);
                    break;

                case "8":
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
