import java.util.Scanner;
public class SingleLinkedlist {
    Node head; // Head of the list

    // Node class containing data and a reference to the next node
    static class Node {
        int data;
        Node next;// Reference to the next node

        Node(int d) // this constructor initializes the node with data and sets next to null which make faster 
         {
            data = d;// Initialize the node's data
            next = null;// Set the next reference to null initially
        }
    }
    void insertAtbeginning(int data)// Method to insert a new node at the beginning of the list 
    {
        Node newNode = new Node(data);// Create a new node class object with the given data
        newNode.next = head;// Set the new node's next to the current head
        head = newNode;// Update the head to point to the new node
    }
    void insertAtend(int data)// Method to insert a new node at the end of the list
     {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;// If the list is empty, set head to the new node
            return;// If the list is empty, set head to the new node
        }
        Node last = head;// Start from the head of the list
        while (last.next != null)// Traverse to the last node
         {
            last = last.next;
        }
        last.next = newNode;
    }
  void insertAtposition(int data, int position)// Method to insert a new node at a specific position in the list
   {
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtbeginning(data);
            return;// If position is 0, insert at the beginning and return 
        }
        Node current = head;// Start from the head of the list
        for (int i = 0; i < position - 1 && current != null; i++) // Traverse to the node just before the desired position condition is met
        {
            current = current.next;// Move to the next node
        }
        if (current == null) {
            // If current is null, it means the position is out of bounds
            System.out.println("Position out of bounds");
            return;
        }
        // Insert the new node at the desired position
        newNode.next = current.next;// Set the new node's next to the current node's next
        current.next = newNode;// Set the current node's next to the new node
    }
    void deleteAtbeginning()// Method to delete the first node of the list
     {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;// If the list is empty, nothing to delete
        }
        head = head.next;// Update head to the next node, effectively removing the first node
    }
    void deleteAtend()// Method to delete the last node of the list
     {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;// If the list is empty, nothing to delete
        }
        if (head.next == null) {
            head = null;// If there's only one node, set head to null
            return;
        }
        Node secondLast = head;// Start from the head of the list
        while (secondLast.next.next != null) // Traverse to the second last node
         {
            secondLast = secondLast.next;
        }
        secondLast.next = null;// Set the next of the second last node to null, effectively removing the last node
    }
    void deleteAtposition(int position)// Method to delete a node at a specific position in the list
     {
        if (head == null) {
            System.out.println("List is empty, nothing to delete");
            return;// If the list is empty, nothing to delete
        }
        if (position == 0) {
            deleteAtbeginning();// If position is 0, delete the first node
            return;
        }
        Node current = head;// Start from the head of the list
        for (int i = 0; i < position - 1 && current != null; i++) // Traverse to the node just before the desired position condition is met
         {
            current = current.next;// Move to the next node
        }
        if (current == null || current.next == null) {
            // If current is null or current.next is null, it means the position is out of bounds
            System.out.println("Position out of bounds");
            return;
        }
        // Delete the node at the desired position
        current.next = current.next.next;// Set the current node's next to skip the node to be deleted
    }
    // Display method inside main class
    void display()// it is also called traversal method, it is used to print the data of each node in the list 
    {
        Node n = head;// Start from the head of the list
        while (n != null) {
            System.out.print(n.data + " "); // Print the data of the current node
            n = n.next;// Move to the next node
        }
        System.out.println( "this is a single linked list");
    }
  void displayReverse(Node node) {
        if (node == null) {
            return; // Base case: if the node is null, return
        }
        displayReverse(node.next); // Recursive call to the next node
        System.out.print(node.data + " "); // Print the data after returning from recursion
    }
    void  sorting() {
        Node current = head, index = null;
        int temp;
        if (head == null) {
            return; // If the list is empty, nothing to sort
        } else {
            while (current != null) {
                index = current.next; // Set index to the next node
                while (index != null) {
                    if (current.data > index.data) { // Compare data of current and index nodes
                        temp = current.data; // Swap data if current is greater than index
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next; // Move to the next node in the list
                }
                current = current.next; // Move to the next node in the list
            }
        }
    }
    void searching(int key) {
        Node current = head; // Start from the head of the list
        while (current != null) {
            if (current.data == key) { // If the current node's data matches the key
                System.out.println("Element found: " + key);
                return; // Element found, exit the method
            }
            current = current.next; // Move to the next node
        }
        System.out.println("Element not found: " + key); // If we reach here, element is not found
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleLinkedlist list = new SingleLinkedlist();

        System.out.println("Enter the number of nodes you want to create:");
        // Creating first node
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for node " + (i + 1) + ":");//i+1 is used to print the node number
            int data = sc.nextInt();
            list.insertAtend(data);//data is inserted at the end of the list
        }
        System.out.println("Initial linked list after creation:");
        list.display(); // Display the linked list after creation
        list.insertAtbeginning(0);//calling the method to insert at the beginning
        list.insertAtend(100);// Insert at the end
        list.insertAtposition(50, 2); // Insert at position 2
        System.out.println("Linked list after insertions:");
        list.display(); // Display the linked list after insertions operations
        list.deleteAtbeginning(); // Delete the first node
        list.deleteAtend(); // Delete the last node
        list.deleteAtposition(3); // Delete the node at position 3
        System.out.println("Final linked list after deletion operation:");
        list.display();
        System.out.println("Linked list in reverse order:");
        list.displayReverse(list.head); // Display the linked list in reverse order
        list.display(); // Display the linked list after reverse operation
        list.sorting(); // Sort the linked list
        System.out.println("Sorted linked list:");
        list.display(); // Display the sorted linked list
        list.searching(50); // Search for an element in the linked list
        sc.close();
    }
}
                                                                                