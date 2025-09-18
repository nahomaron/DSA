package StackAndQueue;


public class QueueLinkedList <T> {

    private Node<T> head;
    private Node<T> rear;
    int size = 0;

    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);

        if (head == null){
            head = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue(){

        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        Node<T> item = head;
        head = head.next;
        if (head == null){
            rear = null;
        }
        size--;
        return item.data;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Queue : ");
        Node<T> temp = head;

        while(temp!=null){
            sb.append(temp.data);
            sb.append(" -> ");
            temp = temp.next;
        }
        sb.append("null");

        return sb.toString();
    }

    public void printQueue() {
        Node<T> temp = head;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
