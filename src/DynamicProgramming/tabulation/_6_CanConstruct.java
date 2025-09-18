package DynamicProgramming.tabulation;

import java.util.Arrays;

public class _6_CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[] {"bo", "rd", "e", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // false
    }

    public static boolean canConstruct(String target, String[] wordBank){
        boolean[] table = new boolean[target.length() + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i <= target.length(); i++) {
            if(table[i]){
                for(String word : wordBank){
                    if(i + word.length() <= target.length()){
                        if(target.startsWith(word, i)){
                            table[i + word.length()] = true;
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }
}
