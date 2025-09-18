package LinkedList;

public class LinkedList {
   static class Node{
       int data;
       Node next;

       public Node(int data){
           this.data = data;
           this.next = null;
       }
   }
   private Node head;

   // inserting data at the tail
    public void insert(int data){
       Node newNode = new Node(data);

       if (head == null){
           head = newNode;
           return;
       }

       Node temp = head;
       // traverse to the last node
       while(temp.next != null){
           temp = temp.next;
       }

       temp.next = newNode;

    }

    // inserting data ate the head
    public void insertFirst(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // insert data a given position
    public void insertAt(int data, int position){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        if(position == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        int count = 0;
        while(temp != null && count < position - 1){
            temp = temp.next;
            count++;
        }

        if(temp == null){
            System.out.println("Out of bound");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;



    }

    // printing the linked list
    public void traverse(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.printf("null%n");
    }

    public static void traverse(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.printf("null%n");
    }

    // delete a data from list
    public void delete(int data){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        if (head.data == data){
            head = head.next;
            return;
        }

        Node temp = head;
        while(temp.next != null && temp.data != data){
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("Value not found in list");
            return;
        }

        temp.next = temp.next.next;
    }

    //remove the head
    public void deleteFirst(){
        head = head.next;
    }

    //remove the last
    public void deleteLast(){
        Node temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

    }

    // searching item and return position
    public int search(int data){

        if(head.data == data){
            return 0;
        }

        Node temp = head;
        int count = 0;

        while(temp !=null && temp.data != data){
            temp = temp.next;
            count++;
        }

        if(temp == null){
            return -1;
        }

        return count;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ADVANCED OPERATIONS

    // reversing the link iteratively
    public void reverseIteratively(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // reversing the link recursively
    public Node reverseRecursively(Node node){
        if(node == null || node.next == null){
            head = node;
            return node;
        }

        Node newHead = reverseRecursively(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
   }

   // Detect cycle Floyd's algorithm
    public boolean hasCycle(){
        Node slow = head, fast = head;

        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    // Find middle of list
    public void findMiddle(){
        Node fast = head, slow = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle value is " + slow.data);
    }

    // merge two sorted list
    public static Node mergeTwoSortedList(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;

        return dummy.next;
    }

    // find Nth node from the end 
    public void findTheNthNodeFromEnd(int n){
        Node fast = head, slow = head;

        for (int i = 1; i < n; i++) {
            if(fast == null){
                System.out.println("Out of bound");
                return;
            }
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println("The Nth value is: " + slow.data);
    }

    // remove duplicates in sorted list
    public void removeDuplicatesInSorted(){
        Node temp = head;

        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
    }

    // Merge Sort a linked list
    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }
    public Node getMiddle(Node head){
        Node slow = head, fast = head;

        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node l1, Node l2){
        Node dummy = new Node( -1);
        Node tail = dummy;

        while(l1 != null && l2 != null){
            if (l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;

        return dummy.next;
    }


    public static void main(String[] args){
        LinkedList mylist1 = new LinkedList();
        mylist1.insert(3);
        mylist1.insert(7);
        mylist1.insert(10);
        mylist1.insert(1);
        mylist1.insert(0);
        mylist1.insert(9);
        mylist1.insert(2);
        mylist1.insert(-1);

        LinkedList myList2 = new LinkedList();
        myList2.insert(2);
        myList2.insert(4);
        myList2.insert(8);
        myList2.insert(10);


//        mylist.deleteLast();
//        mylist1.traverse();
//        mylist1.reverseRecursively(mylist1.head);
//        mylist1.traverse();
//        mylist1.findMiddle();
//        int target = 2;
//        System.out.println(mylist1.search(target) == -1 ? "Not found": target + " is found at " + mylist1.search(target));

//
//        Node l1 = mylist1.head;
//        Node l2 = myList2.head;
//        Node mergeHead = mergeTwoSortedList(l1, l2);
//        traverse(mergeHead);

        mylist1.traverse();
//        mylist1.findTheNthNodeFromEnd(1);

//        mylist1.removeDuplicatesInSorted();
        Node sortedHead = mylist1.mergeSort(mylist1.head);
        traverse(sortedHead);

    }
}