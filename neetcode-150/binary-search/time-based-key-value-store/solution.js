/**
 * Time Complexity: O(log n) for get, O(1) for set
 * Space Complexity: O(n) - Store all key-value pairs
 */
var TimeMap = function() {
    this.map = new Map();
};

TimeMap.prototype.set = function(key, value, timestamp) {
    if (!this.map.has(key)) {
        this.map.set(key, []);
    }
    this.map.get(key).push([timestamp, value]);
};

TimeMap.prototype.get = function(key, timestamp) {
    const list = this.map.get(key);
    if (!list || list.length === 0) {
        return "";
    }
    
    let left = 0;
    let right = list.length - 1;
    let result = -1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        
        if (list[mid][0] <= timestamp) {
            result = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result === -1 ? "" : list[result][1];
};

// Alternative approach using Map with sorted arrays
var TimeMapSorted = function() {
    this.map = new Map();
};

TimeMapSorted.prototype.set = function(key, value, timestamp) {
    if (!this.map.has(key)) {
        this.map.set(key, []);
    }
    
    const list = this.map.get(key);
    // Insert in sorted order
    let left = 0, right = list.length;
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (list[mid][0] < timestamp) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    list.splice(left, 0, [timestamp, value]);
};

TimeMapSorted.prototype.get = function(key, timestamp) {
    const list = this.map.get(key);
    if (!list || list.length === 0) {
        return "";
    }
    
    let left = 0, right = list.length - 1, result = -1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (list[mid][0] <= timestamp) {
            result = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result === -1 ? "" : list[result][1];
};

// More concise version
var TimeMapConcise = function() {
    this.map = new Map();
};

TimeMapConcise.prototype.set = function(key, value, timestamp) {
    if (!this.map.has(key)) this.map.set(key, []);
    this.map.get(key).push([timestamp, value]);
};

TimeMapConcise.prototype.get = function(key, timestamp) {
    const list = this.map.get(key);
    if (!list) return "";
    
    let left = 0, right = list.length - 1, result = -1;
    
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        if (list[mid][0] <= timestamp) {
            result = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result === -1 ? "" : list[result][1];
};

// Using ES6 class syntax
class TimeMapES6 {
    constructor() {
        this.map = new Map();
    }
    
    set(key, value, timestamp) {
        if (!this.map.has(key)) {
            this.map.set(key, []);
        }
        this.map.get(key).push([timestamp, value]);
    }
    
    get(key, timestamp) {
        const list = this.map.get(key);
        if (!list || list.length === 0) {
            return "";
        }
        
        let left = 0, right = list.length - 1, result = -1;
        
        while (left <= right) {
            const mid = Math.floor(left + (right - left) / 2);
            if (list[mid][0] <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result === -1 ? "" : list[result][1];
    }
}
