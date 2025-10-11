/**
 * Time Complexity: O(k log n) - k tweets, n users
 * Space Complexity: O(n) - n users and tweets
 */
class Twitter {
    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollowers;
    private int timestamp;
    
    public Twitter() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        
        // Add user's own tweets
        if (userTweets.containsKey(userId)) {
            for (Tweet tweet : userTweets.get(userId)) {
                maxHeap.offer(tweet);
            }
        }
        
        // Add tweets from followed users
        if (userFollowers.containsKey(userId)) {
            for (int followeeId : userFollowers.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    for (Tweet tweet : userTweets.get(followeeId)) {
                        maxHeap.offer(tweet);
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().tweetId);
            count++;
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userFollowers.containsKey(followerId)) {
            userFollowers.put(followerId, new HashSet<>());
        }
        userFollowers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollowers.containsKey(followerId)) {
            userFollowers.get(followerId).remove(followeeId);
        }
    }
    
    private static class Tweet {
        int tweetId;
        int timestamp;
        
        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}

// Alternative approach using List + Sorting
class TwitterList {
    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollowers;
    private int timestamp;
    
    public TwitterList() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> allTweets = new ArrayList<>();
        
        // Add user's own tweets
        if (userTweets.containsKey(userId)) {
            allTweets.addAll(userTweets.get(userId));
        }
        
        // Add tweets from followed users
        if (userFollowers.containsKey(userId)) {
            for (int followeeId : userFollowers.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    allTweets.addAll(userTweets.get(followeeId));
                }
            }
        }
        
        // Sort by timestamp (most recent first)
        allTweets.sort((a, b) -> b.timestamp - a.timestamp);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i).tweetId);
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userFollowers.containsKey(followerId)) {
            userFollowers.put(followerId, new HashSet<>());
        }
        userFollowers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollowers.containsKey(followerId)) {
            userFollowers.get(followerId).remove(followeeId);
        }
    }
    
    private static class Tweet {
        int tweetId;
        int timestamp;
        
        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}

// Alternative approach using TreeMap
class TwitterTreeMap {
    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollowers;
    private int timestamp;
    
    public TwitterTreeMap() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        TreeMap<Integer, List<Tweet>> tweetMap = new TreeMap<>(Collections.reverseOrder());
        
        // Add user's own tweets
        if (userTweets.containsKey(userId)) {
            for (Tweet tweet : userTweets.get(userId)) {
                tweetMap.computeIfAbsent(tweet.timestamp, k -> new ArrayList<>()).add(tweet);
            }
        }
        
        // Add tweets from followed users
        if (userFollowers.containsKey(userId)) {
            for (int followeeId : userFollowers.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    for (Tweet tweet : userTweets.get(followeeId)) {
                        tweetMap.computeIfAbsent(tweet.timestamp, k -> new ArrayList<>()).add(tweet);
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (List<Tweet> tweets : tweetMap.values()) {
            for (Tweet tweet : tweets) {
                if (count >= 10) break;
                result.add(tweet.tweetId);
                count++;
            }
            if (count >= 10) break;
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!userFollowers.containsKey(followerId)) {
            userFollowers.put(followerId, new HashSet<>());
        }
        userFollowers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollowers.containsKey(followerId)) {
            userFollowers.get(followerId).remove(followeeId);
        }
    }
    
    private static class Tweet {
        int tweetId;
        int timestamp;
        
        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}
