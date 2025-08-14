class Solution {
    public String largestGoodInteger(String num) {
        String result = "";
        
        // Check for 3 consecutive same digits starting from the left
        for (int i = 0; i <= num.length() - 3; i++) {
            // Check if current position and next two positions have the same digit
            if (num.charAt(i) == num.charAt(i + 1) && 
                num.charAt(i + 1) == num.charAt(i + 2)) {
                
                String current = num.substring(i, i + 3);
                
                // Update result if current is larger (lexicographically)
                if (current.compareTo(result) > 0) {
                    result = current;
                }
            }
        }
        
        return result;
    }
}

// Alternative approach using sliding window
class Solution2 {
    public String largestGoodInteger(String num) {
        String result = "";
        
        // Use sliding window of size 3
        for (int i = 0; i <= num.length() - 3; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i + 1);
            char c3 = num.charAt(i + 2);
            
            // Check if all three characters are the same
            if (c1 == c2 && c2 == c3) {
                String current = String.valueOf(c1) + c2 + c3;
                
                // Update result if current is larger
                if (result.isEmpty() || current.compareTo(result) > 0) {
                    result = current;
                }
            }
        }
        
        return result;
    }
}
