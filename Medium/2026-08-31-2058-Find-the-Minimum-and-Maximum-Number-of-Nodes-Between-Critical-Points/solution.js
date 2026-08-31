class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

var nodesBetweenCriticalPoints = function(head) {
    let criticalPoints = [];
    let index = 0;
    let prev = head;
    let curr = head.next;

    while (curr && curr.next) {
        if ((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
            criticalPoints.push(index + 1);
        }
        prev = curr;
        curr = curr.next;
        index++;
    }

    if (criticalPoints.length < 2) {
        return [-1, -1];
    }

    let minDistance = Infinity;
    let maxDistance = criticalPoints[criticalPoints.length - 1] - criticalPoints[0];

    for (let i = 1; i < criticalPoints.length; i++) {
        minDistance = Math.min(minDistance, criticalPoints[i] - criticalPoints[i - 1]);
    }

    return [minDistance, maxDistance];
};