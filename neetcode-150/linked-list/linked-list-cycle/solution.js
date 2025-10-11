/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * Time Complexity: O(n) - Linear time
 * Space Complexity: O(1) - Only uses constant extra space
 */
var hasCycle = function(head) {
    if (!head || !head.next) {
        return false;
    }
    
    let slow = head;
    let fast = head;
    
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow === fast) {
            return true;
        }
    }
    
    return false;
};

// Alternative approach using Set
var hasCycleSet = function(head) {
    const visited = new Set();
    let current = head;
    
    while (current) {
        if (visited.has(current)) {
            return true;
        }
        visited.add(current);
        current = current.next;
    }
    
    return false;
};

// Alternative approach using marking
var hasCycleMarking = function(head) {
    let current = head;
    
    while (current) {
        if (current.val === 'VISITED') {
            return true;
        }
        current.val = 'VISITED';
        current = current.next;
    }
    
    return false;
};

// More concise version
var hasCycleConcise = function(head) {
    let slow = head, fast = head;
    
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) return true;
    }
    
    return false;
};

// Using arrow functions
var hasCycleArrow = function(head) {
    const detectCycle = (slow, fast) => {
        if (!fast || !fast.next) return false;
        
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow === fast) return true;
        return detectCycle(slow, fast);
    };
    
    return detectCycle(head, head);
};

// Using Map for visited tracking
var hasCycleMap = function(head) {
    const visited = new Map();
    let current = head;
    
    while (current) {
        if (visited.has(current)) {
            return true;
        }
        visited.set(current, true);
        current = current.next;
    }
    
    return false;
};
