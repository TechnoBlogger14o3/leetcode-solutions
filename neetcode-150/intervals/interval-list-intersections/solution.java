/**
 * Time Complexity: O(m + n) - Two pointers
 * Space Complexity: O(1) - In-place modification
 */
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            // Find intersection of current intervals
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            // If intersection exists, add to result
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            // Move pointer of interval that ends first
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using brute force
class SolutionBruteForce {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        for (int[] first : firstList) {
            for (int[] second : secondList) {
                int start = Math.max(first[0], second[0]);
                int end = Math.min(first[1], second[1]);
                
                if (start <= end) {
                    result.add(new int[]{start, end});
                }
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using iterative
class SolutionIterative {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using while loop
class SolutionWhileLoop {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using enhanced for loop
class SolutionEnhancedForLoop {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}

// Alternative approach using recursive
class SolutionRecursive {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        intervalIntersectionHelper(firstList, secondList, 0, 0, result);
        
        return result.toArray(new int[result.size()][]);
    }
    
    private void intervalIntersectionHelper(int[][] firstList, int[][] secondList, 
                                          int i, int j, List<int[]> result) {
        if (i >= firstList.length || j >= secondList.length) {
            return;
        }
        
        int start = Math.max(firstList[i][0], secondList[j][0]);
        int end = Math.min(firstList[i][1], secondList[j][1]);
        
        if (start <= end) {
            result.add(new int[]{start, end});
        }
        
        if (firstList[i][1] < secondList[j][1]) {
            intervalIntersectionHelper(firstList, secondList, i + 1, j, result);
        } else {
            intervalIntersectionHelper(firstList, secondList, i, j + 1, result);
        }
    }
}

// More concise version
class SolutionConcise {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            if (start <= end) result.add(new int[]{start, end});
            
            if (firstList[i][1] < secondList[j][1]) i++;
            else j++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
