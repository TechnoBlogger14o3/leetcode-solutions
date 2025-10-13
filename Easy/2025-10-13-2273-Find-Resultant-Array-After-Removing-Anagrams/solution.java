import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";
        
        for (String word : words) {
            String sortedWord = sortString(word);
            if (!sortedWord.equals(sortString(prev))) {
                result.add(word);
            }
            prev = word;
        }
        
        return result;
    }
    
    private String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}