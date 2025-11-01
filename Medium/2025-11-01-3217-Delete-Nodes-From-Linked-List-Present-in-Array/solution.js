class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

var deleteNodes = function(head, nums) {
    const numSet = new Set(nums);
    let dummy = new ListNode(0);
    let current = dummy;

    while (head) {
        if (!numSet.has(head.val)) {
            current.next = head;
            current = current.next;
        }
        head = head.next;
    }
    
    current.next = null; // Terminate the new list
    return dummy.next; // Return the modified list
};