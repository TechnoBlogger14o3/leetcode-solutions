/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

/**
 * Time Complexity: O(m+n) - Process all nodes
 * Space Complexity: O(1) - Only uses constant extra space
 */
var mergeTwoLists = function(list1, list2) {
    const dummy = new ListNode(0);
    let current = dummy;
    
    while (list1 && list2) {
        if (list1.val <= list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }
    
    // Link remaining nodes
    current.next = list1 || list2;
    
    return dummy.next;
};

// Alternative approach using recursive method
var mergeTwoListsRecursive = function(list1, list2) {
    if (!list1) return list2;
    if (!list2) return list1;
    
    if (list1.val <= list2.val) {
        list1.next = mergeTwoListsRecursive(list1.next, list2);
        return list1;
    } else {
        list2.next = mergeTwoListsRecursive(list1, list2.next);
        return list2;
    }
};

// Alternative approach without dummy node
var mergeTwoListsNoDummy = function(list1, list2) {
    if (!list1) return list2;
    if (!list2) return list1;
    
    const head = list1.val <= list2.val ? list1 : list2;
    let current = head;
    
    if (list1.val <= list2.val) {
        list1 = list1.next;
    } else {
        list2 = list2.next;
    }
    
    while (list1 && list2) {
        if (list1.val <= list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }
    
    current.next = list1 || list2;
    return head;
};

// More concise version
var mergeTwoListsConcise = function(list1, list2) {
    const dummy = new ListNode(0);
    let current = dummy;
    
    while (list1 && list2) {
        current.next = list1.val <= list2.val ? list1 : list2;
        if (list1.val <= list2.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        current = current.next;
    }
    
    current.next = list1 || list2;
    return dummy.next;
};

// Using arrow functions
var mergeTwoListsArrow = function(list1, list2) {
    const merge = (l1, l2) => {
        if (!l1) return l2;
        if (!l2) return l1;
        
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    };
    
    return merge(list1, list2);
};

// Using destructuring assignment
var mergeTwoListsDestructuring = function(list1, list2) {
    const dummy = new ListNode(0);
    let current = dummy;
    
    while (list1 && list2) {
        if (list1.val <= list2.val) {
            [current.next, list1] = [list1, list1.next];
        } else {
            [current.next, list2] = [list2, list2.next];
        }
        current = current.next;
    }
    
    current.next = list1 || list2;
    return dummy.next;
};
