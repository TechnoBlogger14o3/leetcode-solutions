class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

var rotateRight = function(head, k) {
    if (!head || k === 0) return head;

    let length = 1;
    let tail = head;

    while (tail.next) {
        tail = tail.next;
        length++;
    }

    tail.next = head; // Make it a circular list
    k = k % length; // Normalize k

    let stepsToNewHead = length - k;
    let newTail = head;

    for (let i = 1; i < stepsToNewHead; i++) {
        newTail = newTail.next;
    }

    let newHead = newTail.next;
    newTail.next = null; // Break the circle

    return newHead;
};