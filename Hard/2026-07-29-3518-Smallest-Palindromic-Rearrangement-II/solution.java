import java.util.*;

public class Solution {
    public String kthPalindrome(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        List<Character> halfChars = new ArrayList<>();
        StringBuilder half = new StringBuilder();
        for (char c : countMap.keySet()) {
            int count = countMap.get(c);
            if (count % 2 == 1) {
                half.append(c);
            }
            for (int i = 0; i < count / 2; i++) {
                halfChars.add(c);
            }
        }

        if (half.length() > 1) {
            return ""; // More than one odd character means no valid palindrome
        }

        Collections.sort(halfChars);
        Set<String> resultSet = new TreeSet<>();
        generatePalindromes(halfChars, new StringBuilder(), resultSet);

        if (resultSet.size() < k) {
            return "";
        }

        Iterator<String> iterator = resultSet.iterator();
        for (int i = 1; i < k; i++) {
            iterator.next();
        }
        String palindrome = iterator.next();
        return palindrome;
    }

    private void generatePalindromes(List<Character> halfChars, StringBuilder current, Set<String> resultSet) {
        if (current.length() == halfChars.size()) {
            StringBuilder reverse = new StringBuilder(current).reverse();
            String palindrome = current.toString() + reverse.toString();
            resultSet.add(palindrome);
            return;
        }

        for (int i = 0; i < halfChars.size(); i++) {
            if (i > 0 && halfChars.get(i) == halfChars.get(i - 1)) continue; // Skip duplicates
            char c = halfChars.remove(i);
            current.append(c);
            generatePalindromes(halfChars, current, resultSet);
            current.deleteCharAt(current.length() - 1);
            halfChars.add(i, c);
        }
    }
}