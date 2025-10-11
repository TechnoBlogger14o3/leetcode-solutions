/**
 * Time Complexity: O(n) - Single pass through the string
 * Space Complexity: O(1) - Only using two pointers
 */
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}

// Alternative approach using reverse and compare
class SolutionReverse {
    public boolean isPalindrome(String s) {
        // Clean the string
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        String cleanedStr = cleaned.toString();
        String reversed = cleaned.reverse().toString();
        
        return cleanedStr.equals(reversed);
    }
}

// Using streams for functional approach
class SolutionStreams {
    public boolean isPalindrome(String s) {
        String cleaned = s.chars()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
}
