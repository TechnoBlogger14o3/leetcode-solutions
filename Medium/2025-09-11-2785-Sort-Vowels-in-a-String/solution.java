import java.util.*;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}