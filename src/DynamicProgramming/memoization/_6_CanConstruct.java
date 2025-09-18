package DynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class _6_CanConstruct {
    private static final Map<String, Boolean> memo = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // false
    }

    public static boolean canConstruct(String target, String[] wordBank) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return true;

        for(String word : wordBank){
           if(target.startsWith(word)){
               String suffix = target.substring(word.length());
               if(canConstruct(suffix, wordBank)) {
                   memo.put(suffix, true);
                   return true;
               }
           }
        }
        memo.put(target, false);
        return false;
    }
}
