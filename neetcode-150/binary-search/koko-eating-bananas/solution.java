/**
 * Time Complexity: O(n * log(max(piles))) - Binary search + validation
 * Space Complexity: O(1) - Only uses constant extra space
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canFinish(int[] piles, int speed, int h) {
        int totalHours = 0;
        
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed; // Ceiling division
        }
        
        return totalHours <= h;
    }
    
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}

// Alternative approach using Arrays.stream
class SolutionStream {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElse(0);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canFinish(int[] piles, int speed, int h) {
        return Arrays.stream(piles)
                .mapToLong(pile -> (pile + speed - 1) / speed)
                .sum() <= h;
    }
}

// More concise version
class SolutionConcise {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().orElse(0);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
    
    private boolean canFinish(int[] piles, int speed, int h) {
        return Arrays.stream(piles).mapToLong(pile -> (pile + speed - 1) / speed).sum() <= h;
    }
}

// Using Math.ceil for ceiling division
class SolutionCeil {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().orElse(0);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canFinish(int[] piles, int speed, int h) {
        int totalHours = 0;
        
        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / speed);
        }
        
        return totalHours <= h;
    }
}
