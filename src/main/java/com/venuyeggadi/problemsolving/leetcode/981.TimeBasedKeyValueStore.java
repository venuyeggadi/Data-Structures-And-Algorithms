package com.venuyeggadi.problemsolving.leetcode;

import java.util.*;

/**
 * Map and Bruteforce
 *
 * Time:
 *      set: O(1)
 *      get: O(n)
 * Space: O(m * n)
 *
 *     where m -> total number of unique keys
 *          n - average number of values per key
 */
class TimeMap_Solution1 {
    private Map<String, List<TimeMapNode>> store;

    public TimeMap_Solution1() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key))
            store.put(key, new ArrayList<TimeMapNode>());
        store.get(key).add(new TimeMapNode(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeMapNode> values = store.get(key);
        if (values == null)
            return "";

        for (int i = values.size() - 1; i >= 0; --i) {
            var node = values.get(i);
            if (node.timestamp <= timestamp)
                return node.value;
        }

        return "";
    }
}

class TimeMapNode {
    public String value;
    public int timestamp;
    public TimeMapNode(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}


/**
 * Time:
 *      set: O(log n)
 *      get: O(log n)
 *  Space: O(m * n)
 */
class TimeMap_Solution2 {
    private Map<String, TreeMap<Integer, String>> store;

    public TimeMap_Solution2() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeMap<>());
        store.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (store.get(key) == null)
            return "";

        Map.Entry<Integer, String> resultEntry = store.get(key).floorEntry(timestamp);

        if (resultEntry == null)
            return "";

        return resultEntry.getValue();
    }
}


/**
 * Map and Binary Search
 *
 * Time:
 *      set: O(1)
 *      get: O(log n)
 * Space: O(m * n)
 */
class TimeMap_Solution3 {
    private Map<String, List<TimeMapNode>> store;

    public TimeMap_Solution3() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key))
            store.put(key, new ArrayList<TimeMapNode>());
        store.get(key).add(new TimeMapNode(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeMapNode> values = store.get(key);
        if (values == null)
            return "";

        int l = 0, r = values.size() - 1;
        String ans = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;
            var midNode = values.get(mid);
            if (midNode.timestamp <= timestamp) {
                ans = midNode.value;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return ans;
    }
}

