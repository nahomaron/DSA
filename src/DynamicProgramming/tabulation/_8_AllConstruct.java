package DynamicProgramming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_AllConstruct {
    public static void main(String[] args){
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ul", "le", "purpl", "e"}));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "e", "t", "ska", "sk", "boar", "d"}));
        System.out.println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"}));
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank){
        List<List<String>>[] table = new ArrayList[target.length() + 1];

        for (int i = 0; i <= target.length(); i++) {
            table[i] = new ArrayList<>();
        }
        table[0].add(new ArrayList<>());

        for (int i = 0; i <= target.length(); i++) {
            if(!table[i].isEmpty()){
                for(String word : wordBank){
                    if(target.startsWith(word, i) && i + word.length() <= target.length()){
                        List<List<String>> result = new ArrayList<>();
                        for(List<String> subList : table[i]){
                            List<String> newList = new ArrayList<>(subList);
                            newList.add(word);
                            result.add(newList);
                        }

                        table[i + word.length()].addAll(result);

                    }
                }
            }
        }

        return table[target.length()];
    }
}
