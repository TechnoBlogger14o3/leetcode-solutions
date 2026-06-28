class Solution {
    public int maximumElementAfterDecreasingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1; // First element must be 1
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1); // Ensure the difference condition
        }
        return arr[arr.length - 1]; // Return the maximum element
    }
}