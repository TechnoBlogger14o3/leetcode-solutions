# Design Twitter

## Problem Statement

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

- `Twitter()` Initializes your twitter object.
- `void postTweet(int userId, int tweetId)` Composes a new tweet with ID `tweetId` by the user `userId`. Each call to this function will be made with a unique `tweetId`.
- `List<Integer> getNewsFeed(int userId)` Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
- `void follow(int followerId, int followeeId)` The user with ID `followerId` started following the user with ID `followeeId`.
- `void unfollow(int followerId, int followeeId)` The user with ID `followerId` started unfollowing the user with ID `followeeId`.

## Examples

**Example 1:**
```
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]

Output
[null, null, [5], null, null, [6, 5], null, [5]]
```

## Approach

### Method 1: HashMap + Priority Queue (Recommended)
1. Use HashMap to store user tweets and followers
2. Use PriorityQueue to get most recent tweets
3. Merge tweets from followed users
4. Return top 10 tweets

**Time Complexity:** O(k log n) - k tweets, n users
**Space Complexity:** O(n) - n users and tweets

### Method 2: List + Sorting
1. Use List to store tweets
2. Sort by timestamp
3. Filter by followed users
4. Return top 10

**Time Complexity:** O(n log n) - Sorting
**Space Complexity:** O(n) - All tweets

## Algorithm

```
1. Store tweets in HashMap<userId, List<Tweet>>
2. Store followers in HashMap<userId, Set<Integer>>
3. For getNewsFeed:
   a. Get all followed users
   b. Collect tweets from all users
   c. Use PriorityQueue to get most recent
   d. Return top 10
```

## Key Insights

- **HashMap**: Store user data efficiently
- **PriorityQueue**: Get most recent tweets
- **Timestamp**: Order tweets by time
- **Merge**: Combine tweets from multiple users

## Alternative Approaches

1. **List + Sorting**: Use sorting for ordering
2. **TreeMap**: Use TreeMap for ordering
3. **Database**: Use database-like approach

## Edge Cases

- Empty news feed: Return empty list
- No followers: Return own tweets
- More than 10 tweets: Return top 10
- Unfollow non-existent user: Handle gracefully

## Applications

- Social media platforms
- Algorithm design patterns
- Interview preparation
- Data structure operations
- System design

## Optimization Opportunities

- **HashMap**: Most efficient storage
- **PriorityQueue**: Efficient ordering
- **Merge**: Combine tweets efficiently
- **Caching**: Cache news feed results
