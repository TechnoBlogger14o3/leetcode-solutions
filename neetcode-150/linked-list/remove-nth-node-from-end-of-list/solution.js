/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

/**
 * Time Complexity: O(n) - Single pass through list
 * Space Complexity: O(1) - Only uses constant extra space
 */
var removeNthFromEnd = function(head, n) {
    const dummy = new ListNode(0);
    dummy.next = head;
    
    let first = dummy;
    let second = dummy;
    
    // Move first pointer n steps ahead
    for (let i = 0; i <= n; i++) {
        first = first.next;
    }
    
    // Move both pointers until first reaches end
    while (first !== null) {
        first = first.next;
        second = second.next;
    }
    
    // Remove node after second pointer
    second.next = second.next.next;
    
    return dummy.next;
};

// Alternative approach using two passes
var removeNthFromEndTwoPass = function(head, n) {
    const dummy = new ListNode(0);
    dummy.next = head;
    
    // First pass: count total nodes
    let count = 0;
    let current = head;
    while (current !== null) {
        count++;
        current = current.next;
    }
    
    // Second pass: remove (count - n)th node
    current = dummy;
    for (let i = 0; i < count - n; i++) {
        current = current.next;
    }
    
    current.next = current.next.next;
    return dummy.next;
};

// Alternative approach without dummy node
var removeNthFromEndNoDummy = function(head, n) {
    let first = head;
    let second = head;
    
    // Move first pointer n steps ahead
    for (let i = 0; i < n; i++) {
        first = first.next;
    }
    
    // If first is null, remove head
    if (first === null) {
        return head.next;
    }
    
    // Move both pointers until first reaches end
    while (first.next !== null) {
        first = first.next;
        second = second.next;
    }
    
    // Remove node after second pointer
    second.next = second.next.next;
    
    return head;
};

// More concise version
var removeNthFromEndConcise = function(head, n) {
    const dummy = new ListNode(0);
    dummy.next = head;
    
    let first = dummy, second = dummy;
    
    for (let i = 0; i <= n; i++) {
        first = first.next;
    }
    
    while (first !== null) {
        first = first.next;
        second = second.next;
    }
    
    second.next = second.next.next;
    return dummy.next;
};

// Using array approach
var removeNthFromEndArray = function(head, n) {
    const nodes = [];
    let current = head;
    
    while (current !== null) {
        nodes.push(current);
        current = current.next;
    }
    
    const indexToRemove = nodes.length - n;
    
    if (indexToRemove === 0) {
        return head.next;
    }
    
    nodes[indexToRemove - 1].next = nodes[indexToRemove].next;
    return head;
};

// Using arrow functions
var removeNthFromEndArrow = function(head, n) {
    const dummy = new ListNode(0);
    dummy.next = head;
    
    const movePointers = (first, second) => {
        for (let i = 0; i <= n; i++) {
            first = first.next;
        }
        
        while (first !== null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    };
    
    return movePointers(dummy, dummy);
};
