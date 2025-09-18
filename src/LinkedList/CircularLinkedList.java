package LinkedList;

public class CircularLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args){

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(3);
        Node node5 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1; // this makes it circular

        Node currentNode = node1;
        System.out.print(currentNode.data + " -> ");
        currentNode = currentNode.next;

        while(currentNode != node1) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("...");


    }
}
