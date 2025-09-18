package Misc;

class Disjoint_Set_Union {
    private int[] parent;

    public Disjoint_Set_Union(int size){
        this.parent = new int[size];

        for(int i = 0; i < size; i++) parent[i] = i;
    }

    public int find(int x){
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY){
            parent[rootY] = rootX;
        }

    }

    public static void main(String[] args){
        Disjoint_Set_Union ds = new Disjoint_Set_Union(5);
        ds.union(3, 1);
        ds.union(1, 2);
        System.out.println(ds.find(1)); // prints root
        System.out.println(ds.find(2)); // should be same as find(0)


    }
}
