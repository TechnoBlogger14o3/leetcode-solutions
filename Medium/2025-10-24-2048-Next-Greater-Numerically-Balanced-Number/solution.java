class Solution {
    public int nextGreaterNumericallyBalanced(int n) {
        n++;
        while (!isNumericallyBalanced(n)) {
            n++;
        }
        return n;
    }

    private boolean isNumericallyBalanced(int num) {
        int[] count = new int[10];
        String strNum = String.valueOf(num);
        
        for (char c : strNum.toCharArray()) {
            count[c - '0']++;
        }
        
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}