class Solution {
    public boolean checkString(String s) {
        int indexOfB = s.indexOf('b');
        for (int i = 0; i < indexOfB; i++) {
            if (s.charAt(i) == 'b') {
                return false;
            }
        }
        return true;
    }
}