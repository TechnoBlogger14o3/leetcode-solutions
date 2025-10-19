class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        def add_odd_indices(s):
            return ''.join(str((int(s[i]) + a) % 10) if i % 2 else s[i] for i in range(len(s)))

        def rotate(s, b):
            b %= len(s)
            return s[-b:] + s[:-b]

        seen = set()
        min_string = s
        queue = [s]

        while queue:
            current = queue.pop()
            if current in seen:
                continue
            seen.add(current)
            min_string = min(min_string, current)
            next_string = add_odd_indices(current)
            if next_string not in seen:
                queue.append(next_string)
            rotated_string = rotate(current, b)
            if rotated_string not in seen:
                queue.append(rotated_string)

        return min_string