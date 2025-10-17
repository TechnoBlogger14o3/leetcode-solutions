import java.util.HashMap;

public class Solution {
    public int maximizePartitions(String s, int k) {
        int n = s.length();
        int maxPartitions = 0;

        // Function to calculate partitions with at most k distinct characters
        int calculatePartitions(String str, int k) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            int left = 0, partitions = 0;

            for (int right = 0; right < str.length(); right++) {
                charCount.put(str.charAt(right), charCount.getOrDefault(str.charAt(right), 0) + 1);

                while (charCount.size() > k) {
                    charCount.put(str.charAt(left), charCount.get(str.charAt(left)) - 1);
                    if (charCount.get(str.charAt(left)) == 0) {
                        charCount.remove(str.charAt(left));
                    }
                    left++;
                }
                partitions++;
            }
            return partitions;
        }

        // Calculate partitions without any changes
        maxPartitions = calculatePartitions(s, k);

        // Try changing each character to any other character
        for (int i = 0; i < n; i++) {
            char originalChar = s.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    String newString = s.substring(0, i) + c + s.substring(i + 1);
                    maxPartitions = Math.max(maxPartitions, calculatePartitions(newString, k));
                }
            }
        }

        return maxPartitions;
    }
}