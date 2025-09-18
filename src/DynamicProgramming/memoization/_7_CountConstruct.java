package DynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

public class _7_CountConstruct {
    private static final Map<String, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(countConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(countConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "f"})); // false
    }

    public static int countConstruct(String target, String[] wordBank) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.isEmpty()) return 1;

        int sum = 0;
        for(String word : wordBank){
            if(target.startsWith(word)){
                String suffix = target.substring(word.length());
                sum += (countConstruct(suffix, wordBank));
            }
        }

        memo.put(target, sum);
        return sum;
    }
}
