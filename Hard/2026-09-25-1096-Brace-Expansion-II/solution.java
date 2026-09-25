import java.util.*;

public class Solution {
    public List<String> braceExpansionII(String expression) {
        return new ArrayList<>(expand(expression));
    }

    private Set<String> expand(String expression) {
        Set<String> result = new HashSet<>();
        List<String> parts = new ArrayList<>();
        int i = 0, n = expression.length();
        
        while (i < n) {
            if (expression.charAt(i) == '{') {
                int j = i, count = 0;
                while (j < n) {
                    if (expression.charAt(j) == '{') count++;
                    if (expression.charAt(j) == '}') count--;
                    if (count == 0) break;
                    j++;
                }
                parts.add(expand(expression.substring(i + 1, j)).toString());
                i = j + 1;
            } else if (expression.charAt(i) == ',') {
                i++;
            } else {
                parts.add(String.valueOf(expression.charAt(i)));
                i++;
            }
        }

        Set<String> currentSet = new HashSet<>();
        for (String part : parts) {
            if (part.startsWith("[") && part.endsWith("]")) {
                part = part.substring(1, part.length() - 1);
                String[] words = part.split(", ");
                currentSet.addAll(Arrays.asList(words));
            } else {
                currentSet.add(part);
            }
        }

        return currentSet;
    }

    private Set<String> expand(String expression) {
        Set<String> result = new HashSet<>();
        int i = 0, n = expression.length();
        List<Set<String>> sets = new ArrayList<>();
        
        while (i < n) {
            if (expression.charAt(i) == '{') {
                int j = i, count = 0;
                while (j < n) {
                    if (expression.charAt(j) == '{') count++;
                    if (expression.charAt(j) == '}') count--;
                    if (count == 0) break;
                    j++;
                }
                sets.add(expand(expression.substring(i + 1, j)));
                i = j + 1;
            } else if (expression.charAt(i) == ',') {
                i++;
            } else {
                sets.add(Collections.singleton(String.valueOf(expression.charAt(i))));
                i++;
            }
        }

        result.add("");
        for (Set<String> set : sets) {
            Set<String> newResult = new HashSet<>();
            for (String prefix : result) {
                for (String word : set) {
                    newResult.add(prefix + word);
                }
            }
            result = newResult;
        }

        return result;
    }
}