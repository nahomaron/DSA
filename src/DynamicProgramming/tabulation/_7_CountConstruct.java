package DynamicProgramming.tabulation;

import java.util.Arrays;

public class _7_CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ul", "le", "purpl", "e"}));
        System.out.println(countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(countConstruct("skateboard", new String[] {"bo", "rd", "e", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(countConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "f"})); // false
    }

    public static int countConstruct(String target, String[] wordBank){
        int[] table = new int[target.length() + 1];
        Arrays.fill(table, 0);
        table[0] = 1;

        for (int i = 0; i <= target.length(); i++) {
            if(table[i] != 0){
                for(String word : wordBank){
                    if(target.startsWith(word, i)){
                        table[i + word.length()] += table[i];
                    }
                }
            }
        }
        return table[target.length()];
    }
}
