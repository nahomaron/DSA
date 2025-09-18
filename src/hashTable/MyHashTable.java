package hashTable;

class Node{
    String key;
    int value;
    Node next;

    public Node(String key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class MyHashTable {
    private Node[] table;
    private int size;

    public MyHashTable(int size){
        this.size = size;
        this.table = new Node[size];
    }

    private int hash(String key){
        return Math.abs(key.hashCode()) % size;
    }

    public void insert(String key, int value){
        int index = hash(key);
        Node head = table[index];

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public Integer get(String key){
        int index = hash(key);
        Node head = table[index];

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

  public void delete(String key){
      int index = hash(key);
      Node head = table[index];
      Node prev = null;

      while(head != null){
          if(head.key.equals(key)){
             if (prev == null){
                 table[index] = head.next;
             }else{
                 prev.next = head.next;
             }
             return;
          }

          prev = head;
          head = head.next;
      }
  }

  public void printTable(){
      System.out.println("\n======= HashTable =====");

      for (int i = 0; i < table.length; i++) {
          System.out.print("Bucket " + i + ": ");
          Node current = table[i];
          while(current != null){
              System.out.print("[" + current.key +":" + current.value + "]");
              System.out.print(" -> ");
              current = current.next;
          }

          System.out.println("null");
      }

  }


}
