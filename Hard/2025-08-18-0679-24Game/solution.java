import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean judgePoint24(int[] cards) {
        // Convert to list of doubles for calculations
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return backtrack(nums);
    }
    
    private boolean backtrack(List<Double> nums) {
        // Base case: if only one number left, check if it's 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < 1e-6; // Use epsilon for floating point comparison
        }
        
        // Try all pairs of numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                double a = nums.get(i);
                double b = nums.get(j);
                
                // Create new list without these two numbers
                List<Double> remaining = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        remaining.add(nums.get(k));
                    }
                }
                
                // Try all possible operations
                // Addition
                remaining.add(a + b);
                if (backtrack(remaining)) return true;
                remaining.remove(remaining.size() - 1);
                
                // Subtraction (a - b)
                remaining.add(a - b);
                if (backtrack(remaining)) return true;
                remaining.remove(remaining.size() - 1);
                
                // Subtraction (b - a)
                remaining.add(b - a);
                if (backtrack(remaining)) return true;
                remaining.remove(remaining.size() - 1);
                
                // Multiplication
                remaining.add(a * b);
                if (backtrack(remaining)) return true;
                remaining.remove(remaining.size() - 1);
                
                // Division (a / b), check for division by zero
                if (Math.abs(b) > 1e-6) {
                    remaining.add(a / b);
                    if (backtrack(remaining)) return true;
                    remaining.remove(remaining.size() - 1);
                }
                
                // Division (b / a), check for division by zero
                if (Math.abs(a) > 1e-6) {
                    remaining.add(b / a);
                    if (backtrack(remaining)) return true;
                    remaining.remove(remaining.size() - 1);
                }
            }
        }
        
        return false;
    }
}
