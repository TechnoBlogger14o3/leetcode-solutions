class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

var pairSum = function(head) {
    let slow = head, fast = head;
    const stack = [];

    // Use a stack to store the first half of the linked list
    while (fast && fast.next) {
        stack.push(slow.val);
        slow = slow.next;
        fast = fast.next.next;
    }

    let maxTwinSum = 0;
    // Calculate the twin sums
    while (slow) {
        const twinSum = stack.pop() + slow.val;
        maxTwinSum = Math.max(maxTwinSum, twinSum);
        slow = slow.next;
    }

    return maxTwinSum;
};