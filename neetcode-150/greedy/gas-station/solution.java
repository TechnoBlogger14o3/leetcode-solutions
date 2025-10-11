/**
 * Time Complexity: O(n) - Single pass
 * Space Complexity: O(1) - Two variables
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return totalGas >= totalCost ? start : -1;
    }
}

// Alternative approach using brute force
class SolutionBruteForce {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean canComplete = true;
            
            for (int i = 0; i < n; i++) {
                int current = (start + i) % n;
                tank += gas[current] - cost[current];
                
                if (tank < 0) {
                    canComplete = false;
                    break;
                }
            }
            
            if (canComplete) {
                return start;
            }
        }
        
        return -1;
    }
}

// Alternative approach using simulation
class SolutionSimulation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        
        for (int start = 0; start < n; start++) {
            if (gas[start] >= cost[start]) {
                int tank = gas[start] - cost[start];
                int current = (start + 1) % n;
                
                while (current != start && tank >= 0) {
                    tank += gas[current] - cost[current];
                    current = (current + 1) % n;
                }
                
                if (current == start && tank >= 0) {
                    return start;
                }
            }
        }
        
        return -1;
    }
}

// Alternative approach using two passes
class SolutionTwoPasses {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if (totalGas < totalCost) {
            return -1;
        }
        
        int tank = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return start;
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return totalGas >= totalCost ? start : -1;
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;
        
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        
        return totalGas >= totalCost ? start : -1;
    }
}

// More concise version
class SolutionConcise {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return totalGas >= totalCost ? start : -1;
    }
}
