class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                answer[i] = depth % 2; // Assign to A or B based on depth
            } else {
                answer[i] = (depth - 1) % 2; // Assign to A or B based on depth
                depth--;
            }
        }

        return answer;
    }
}