class Solution {
    public int minNumberOfOperations(int[] target) {
        int operations = 0;
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }
        operations += target[0]; // Increment to reach the first element
        return operations;
    }
}