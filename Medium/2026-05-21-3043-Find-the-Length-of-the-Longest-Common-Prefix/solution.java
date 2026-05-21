class Solution {
    public int longestCommonPrefixLength(int[] arr1, int[] arr2) {
        int maxLength = 0;

        for (int num1 : arr1) {
            for (int num2 : arr2) {
                maxLength = Math.max(maxLength, commonPrefixLength(num1, num2));
            }
        }

        return maxLength;
    }

    private int commonPrefixLength(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        int minLength = Math.min(strA.length(), strB.length());
        int length = 0;

        while (length < minLength && strA.charAt(length) == strB.charAt(length)) {
            length++;
        }

        return length;
    }
}