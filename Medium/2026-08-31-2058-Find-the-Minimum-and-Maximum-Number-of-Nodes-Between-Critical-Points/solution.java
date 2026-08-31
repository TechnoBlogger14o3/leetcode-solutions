class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList<>();
        ListNode prev = null, curr = head, next = head.next;
        int index = 0;

        while (next != null) {
            if ((prev != null && curr.val > prev.val && curr.val > next.val) || 
                (prev != null && curr.val < prev.val && curr.val < next.val)) {
                criticalPoints.add(index);
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }

        if (criticalPoints.size() < 2) {
            return new int[] {-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        for (int i = 1; i < criticalPoints.size(); i++) {
            minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }

        return new int[] {minDistance, maxDistance};
    }
}