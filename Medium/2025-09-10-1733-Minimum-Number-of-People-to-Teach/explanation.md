# Minimum Number of People to Teach (Medium)

**Problem ID:** 1733  
**Date:** 2025-09-10  
**Link:** https://leetcode.com/problems/minimum-number-of-people-to-teach/

## Approach

To solve the problem of determining the minimum number of people to teach a common language so that all friends can communicate, we can follow a structured approach:

### Problem Breakdown
1. **Graph Representation**: Model the users as nodes in a graph, where an edge exists between two nodes if there is a friendship between the corresponding users. This allows us to explore connected components of the graph where communication can take place.

2. **Language Knowledge**: Each user knows a set of languages. For two users to communicate, they must share at least one common language. Therefore, we need to analyze the languages known by each user when considering the friendships.

### Approach
1. **Graph Construction**: Create an adjacency list to represent the friendships among users. This will help in identifying connected components.

2. **Connected Components**: Use Depth-First Search (DFS) or Breadth-First Search (BFS) to find all connected components in the friendship graph. Each component represents a group of users who need to be able to communicate.

3. **Language Coverage**: For each connected component, determine the languages known by its users. The goal is to find the minimum number of users to teach a new language that would allow all users in the component to communicate.

4. **Teaching Strategy**:
   - For each component, if at least one user already knows a language that is spoken by any other user in that component, then no teaching is necessary for that language.
   - If no common language exists, we need to teach a language to the users. The optimal strategy is to teach the least number of users possible. This can be achieved by teaching the language that is known by the maximum number of users in that component.

5. **Count Users to Teach**: For each component, calculate how many users need to be taught a new language based on the above strategy. Sum these counts across all components to get the final answer.

### Data Structures
- **Adjacency List**: To represent friendships as a graph.
- **Sets/Lists**: To track languages known by users and to store the users in each connected component.

### Complexity
- **Time Complexity**: O(m + f), where m is the number of users and f is the number of friendships. This accounts for building the graph and traversing it to find connected components.
- **Space Complexity**: O(m + n) for storing the graph and the language knowledge.

### Conclusion
By leveraging graph traversal techniques and analyzing language knowledge within connected components, we can efficiently determine the minimum number of users to teach a language, ensuring all friends can communicate. The approach balances the need to explore friendships while minimizing the teaching effort.
