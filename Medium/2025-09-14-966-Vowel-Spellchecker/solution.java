import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerCaseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            if (!lowerCaseMap.containsKey(lower)) {
                lowerCaseMap.put(lower, word);
            }
            String vowelKey = getVowelKey(word);
            if (!vowelMap.containsKey(vowelKey)) {
                vowelMap.put(vowelKey, word);
            }
        }
        
        String[] result = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (wordSet.contains(query)) {
                result[i] = query;
            } else {
                String lowerQuery = query.toLowerCase();
                if (lowerCaseMap.containsKey(lowerQuery)) {
                    result[i] = lowerCaseMap.get(lowerQuery);
                } else {
                    String vowelKeyQuery = getVowelKey(query);
                    if (vowelMap.containsKey(vowelKeyQuery)) {
                        result[i] = vowelMap.get(vowelKeyQuery);
                    } else {
                        result[i] = "";
                    }
                }
            }
        }
        
        return result;
    }
    
    private String getVowelKey(String word) {
        return word.replaceAll("[aeiouAEIOU]", "*");
    }
}