package LinkedList;

public class DoublyLinkedList {

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(7);
        Node node4 = new Node(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.prev= node3;
        node3.prev = node2;
        node2.prev = node1;

        Node currentNode = node1;

        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");

        currentNode = node4;

        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.prev;
        }
        System.out.println("null");

    }
}
