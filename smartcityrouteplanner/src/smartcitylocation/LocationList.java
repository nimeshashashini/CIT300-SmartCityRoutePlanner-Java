package smartcitylocation;

public class LocationList {
    private class Node {
        String name;
        Node next;
        Node(String name) { this.name = name; }
    }

    private Node head;

    // Insert location in alphabetical order
    public void insertLocation(String name) {
        Node newNode = new Node(name);
        if (head == null || name.compareToIgnoreCase(head.name) < 0) {
            newNode.next = head;
            head = newNode;
            System.out.println("Location '" + name + "' added to list.");
            return;
        }

        Node current = head;
        while (current.next != null && name.compareToIgnoreCase(current.next.name) > 0)
            current = current.next;

        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Location '" + name + "' added to list.");
    }

    // Remove a location
    public void removeLocation(String name) {
        if (head == null) {
            System.out.println("No locations to remove.");
            return;
        }

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println("Location '" + name + "' removed from list.");
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.name.equalsIgnoreCase(name))
            current = current.next;

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Location '" + name + "' removed from list.");
        } else {
            System.out.println("Location '" + name + "' not found in list!");
        }
    }

    // Display all locations
    public void displayAllLocations() {
        if (head == null) {
            System.out.println("No locations available.");
            return;
        }

        System.out.println("\n--- All Locations (Linked List) ---");
        Node current = head;
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
        System.out.println("----------------------------------\n");
    }
}
