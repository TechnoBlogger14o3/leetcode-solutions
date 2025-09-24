import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        // Handle sign
        if (numerator < 0 ^ denominator < 0) {
            result.append("-");
        }
        
        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Append the integral part
        result.append(num / den);
        
        // If there's no fractional part
        long remainder = num % den;
        if (remainder == 0) return result.toString();
        
        result.append(".");
        
        // Map to store the position of each remainder
        HashMap<Long, Integer> map = new HashMap<>();
        
        // Process the fractional part
        while (remainder != 0) {
            // If we have seen this remainder before, we have a repeating fraction
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            }
            
            // Store the position of this remainder
            map.put(remainder, result.length());
            
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }
}