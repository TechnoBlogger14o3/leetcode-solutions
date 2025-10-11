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
var reverseList = function(head) {
    let prev = null;
    let current = head;
    
    while (current !== null) {
        const next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    
    return prev;
};

// Alternative approach using recursive method
var reverseListRecursive = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    
    const newHead = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    
    return newHead;
};

// Alternative approach using array
var reverseListArray = function(head) {
    if (head === null) return null;
    
    const nodes = [];
    let current = head;
    
    while (current !== null) {
        nodes.push(current);
        current = current.next;
    }
    
    for (let i = nodes.length - 1; i > 0; i--) {
        nodes[i].next = nodes[i - 1];
    }
    
    nodes[0].next = null;
    return nodes[nodes.length - 1];
};

// More concise version
var reverseListConcise = function(head) {
    let prev = null, current = head;
    
    while (current !== null) {
        [current.next, prev, current] = [prev, current, current.next];
    }
    
    return prev;
};

// Using arrow functions
var reverseListArrow = function(head) {
    const reverse = (prev, current) => {
        if (current === null) return prev;
        
        const next = current.next;
        current.next = prev;
        return reverse(current, next);
    };
    
    return reverse(null, head);
};

// Using destructuring assignment
var reverseListDestructuring = function(head) {
    let prev = null;
    let current = head;
    
    while (current !== null) {
        [current.next, prev, current] = [prev, current, current.next];
    }
    
    return prev;
};
