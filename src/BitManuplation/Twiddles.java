package BitManuplation;

public class Twiddles {
    public static void main(String[] args){
        int a = 12; // 0101
        System.out.println("Test 0: " + isSet(a, 0));

        System.out.println("Set 1: " + setBit(a, 1));

        System.out.println("Clear 0: " + clearBit(a, 0));

        System.out.println("Toggle 2: " + toggleBit(a, 2));

        System.out.println("Update 3: " + updateBit(a, 3, 1));

        System.out.println(Integer.toBinaryString(-a));
        System.out.println(Integer.toBinaryString(a));
        System.out.println("x & -x : " + Integer.toBinaryString(a & -a));

        System.out.println("Isolate: " + isolateLowestBit(a));

        System.out.println("Remove lowest: " + removeLowestSet(a));

        System.out.println("Is power of two: " + isPowerOfTwo(8));

        System.out.println("Count bits set: " + countBits(8));

        System.out.println("Generate subset:");
        generateSubset(4);
    }

    // 1) Test (check if i-th bit is set)
    public static boolean isSet(int num, int i){
        return (num & (1 << i)) != 0;
    }

    // 2) Set (Turn on the i-th bit)
    public static int setBit(int num, int i){
         return (num | (1 << i));
    }

    // 3) Clear (Turn off the i-th bit)
    public static int clearBit(int num, int i){
        return num & ~(1 << i);
    }

    // 4) Toggle (Flip the i-th bit)
    public static int toggleBit(int num, int i){
        return num ^ (1 << i);
    }

    // 5) Update (Force i-th bit to 0 or 1)

    public static int updateBit(int num, int i, int v){
        num = clearBit(num, i);
        return num | (v << i);
    }

    // Trick 1

    // 6) Isolate the lowest set bit
    // (x & -x)
    public static int isolateLowestBit(int x){
        return x & -x;
    }

    // Trick 2

    // 7) Remove the lowest set bit
    public static int removeLowestSet(int x){
        return x & (x - 1);
    }


    // 8) Check if number is power of two
    public static boolean isPowerOfTwo(int x){
        return x > 0 && (x & (x - 1)) == 0;
    }

    // 9) count number of set bit
    public static int countBits(int x){
        int count = 0;

        while(x != 0){
            x = x & (x - 1);
            count++;
        }
        return count;
    }

    // 10) Subset with bitmask
    // Simple subset generation
    public static void generateSubset(int n){
        for(int mask = 0; mask < (1 << n); mask++){
            System.out.print("{");
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0){
                    System.out.print((char)('a' + i));
                }
            }

            System.out.println("}");
        }
    }

    // Advanced: Enumerating only subsets of a given mask
    public static void advancedSubset(int mask){
        for(int subset = mask; subset > 0; subset = (subset - 1) & mask){
            
        }
    }

}
