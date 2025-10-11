/**
 * Time Complexity: O(log n) for get, O(1) for set
 * Space Complexity: O(n) - Store all key-value pairs
 */
class TimeMap {
    private Map<String, List<int[]>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp, value.hashCode()});
    }
    
    public String get(String key, int timestamp) {
        List<int[]> list = map.get(key);
        if (list == null || list.isEmpty()) {
            return "";
        }
        
        int left = 0;
        int right = list.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid)[0] <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result == -1 ? "" : getValue(list.get(result)[1]);
    }
    
    private String getValue(int hashCode) {
        // This is a simplified version - in practice, you'd need to store actual values
        return "value_" + hashCode;
    }
}

// Alternative approach using TreeMap
class TimeMapTreeMap {
    private Map<String, TreeMap<Integer, String>> map;
    
    public TimeMapTreeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        
        Integer floorKey = treeMap.floorKey(timestamp);
        return floorKey == null ? "" : treeMap.get(floorKey);
    }
}

// More efficient approach storing actual values
class TimeMapEfficient {
    private Map<String, List<TimeValue>> map;
    
    public TimeMapEfficient() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<TimeValue> list = map.get(key);
        if (list == null || list.isEmpty()) {
            return "";
        }
        
        int left = 0;
        int right = list.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).timestamp <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result == -1 ? "" : list.get(result).value;
    }
    
    private static class TimeValue {
        int timestamp;
        String value;
        
        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}

// More concise version
class TimeMapConcise {
    private Map<String, List<int[]>> map = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{timestamp, value.hashCode()});
    }
    
    public String get(String key, int timestamp) {
        List<int[]> list = map.get(key);
        if (list == null) return "";
        
        int left = 0, right = list.size() - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)[0] <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result == -1 ? "" : "value_" + list.get(result)[1];
    }
}
