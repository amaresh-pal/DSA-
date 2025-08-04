public class Doublelinklist {
    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;

    void insertAtbegining(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Doublelinklist list = new Doublelinklist();
        list.insertAtbegining("Hello");
        list.insertAtbegining("World");
        list.insertAtbegining("Java");
        list.displayForward(); // Output: Java <-> World <-> Hello <-> null
    }
}
