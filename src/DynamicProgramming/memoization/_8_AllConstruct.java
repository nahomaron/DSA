package DynamicProgramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _8_AllConstruct {
    private static final Map<String, List<List<String>>> memo = new HashMap<>();
    public static void main(String[] args){
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ul", "le", "purpl", "e"}));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "e", "t", "ska", "sk", "boar", "d"}));
        System.out.println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "z"}));
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank){
        if(memo.containsKey(target)) return memo.get(target);
       if(target.isEmpty()){
           List<List<String>> base = new ArrayList<>();
           base.add(new ArrayList<>());
           return base;
       }
       List<List<String>> result = new ArrayList<>();
       for(String word : wordBank){
           if(target.startsWith(word)){
               String suffix = target.substring(word.length());
               List<List<String>> suffixWay = allConstruct(suffix, wordBank);

               for(List<String> way : suffixWay){
                   List<String> newComb = new ArrayList<>(way);
                   newComb.addFirst(word);
                   result.add(newComb);
               }
           }
       }
       memo.put(target, result);
       return result;
    }
}
