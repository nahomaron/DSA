package hashTable;

public class Main {
    public static void main(String[] args){
        HashMap myHashMap = new HashMap(6);
        myHashMap.put("123" , "Gebray");
        myHashMap.put("332" , "Andebrhan");
        myHashMap.put("973" , "Nemariam");
        myHashMap.put("572" , "Simon");
        myHashMap.put("872" , "Belay");

        myHashMap.printMap();
        System.out.println("\n" + myHashMap.get("872"));
        myHashMap.remove("572");
        myHashMap.printMap();
    }
}
