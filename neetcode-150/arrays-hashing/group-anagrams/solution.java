import java.util.*;

/**
 * Time Complexity: O(n * m log m) - Where n is number of strings, m is average length
 * Space Complexity: O(n * m) - For storing all strings
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Sort characters to create key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // Add to appropriate group
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
}

// Alternative approach using character frequency count
class SolutionFrequency {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Create frequency count key
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Convert count array to string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                keyBuilder.append('#').append(count[i]);
            }
            String key = keyBuilder.toString();
            
            // Add to appropriate group
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
}

// Using streams for more concise code
class SolutionStreams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values()
                .stream()
                .collect(Collectors.toList());
    }
}
