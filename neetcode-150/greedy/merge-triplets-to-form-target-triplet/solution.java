/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - Three variables
 */
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        
        for (int[] triplet : triplets) {
            // Skip triplets that have values greater than target
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            
            // Check if this triplet can contribute to target
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    found[i] = true;
                }
            }
        }
        
        return found[0] && found[1] && found[2];
    }
}

// Alternative approach using separate variables
class SolutionSeparateVariables {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean found0 = false;
        boolean found1 = false;
        boolean found2 = false;
        
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            
            if (triplet[0] == target[0]) found0 = true;
            if (triplet[1] == target[1]) found1 = true;
            if (triplet[2] == target[2]) found2 = true;
        }
        
        return found0 && found1 && found2;
    }
}

// Alternative approach using early termination
class SolutionEarlyTermination {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    found[i] = true;
                }
            }
            
            // Early termination if all positions found
            if (found[0] && found[1] && found[2]) {
                return true;
            }
        }
        
        return found[0] && found[1] && found[2];
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        
        for (int i = 0; i < triplets.length; i++) {
            int[] triplet = triplets[i];
            
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            
            for (int j = 0; j < 3; j++) {
                if (triplet[j] == target[j]) {
                    found[j] = true;
                }
            }
        }
        
        return found[0] && found[1] && found[2];
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        int i = 0;
        
        while (i < triplets.length) {
            int[] triplet = triplets[i];
            
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                i++;
                continue;
            }
            
            for (int j = 0; j < 3; j++) {
                if (triplet[j] == target[j]) {
                    found[j] = true;
                }
            }
            
            i++;
        }
        
        return found[0] && found[1] && found[2];
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) {
                    found[i] = true;
                }
            }
        }
        
        return found[0] && found[1] && found[2];
    }
}

// More concise version
class SolutionConcise {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            for (int i = 0; i < 3; i++) {
                if (triplet[i] == target[i]) found[i] = true;
            }
        }
        return found[0] && found[1] && found[2];
    }
}
