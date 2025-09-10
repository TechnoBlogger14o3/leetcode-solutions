class Solution:
    def minimumTeachings(self, n: int, languages: List[List[int]], friendships: List[List[int]]) -> int:
        m = len(languages)
        can_communicate = [set() for _ in range(m)]
        
        for u, v in friendships:
            can_communicate[u - 1].update(languages[u - 1])
            can_communicate[v - 1].update(languages[v - 1])
        
        # Create a set of users who need to learn a new language
        users_to_teach = set()
        
        for u, v in friendships:
            if not (can_communicate[u - 1] & can_communicate[v - 1]):
                users_to_teach.add(u - 1)
                users_to_teach.add(v - 1)
        
        if not users_to_teach:
            return 0
        
        # Count the number of users needing to learn each language
        language_count = [0] * (n + 1)
        
        for user in users_to_teach:
            for lang in languages[user]:
                language_count[lang] += 1
        
        # The minimum number of users to teach is the maximum count of users needing a specific language
        return len(users_to_teach) - max(language_count)