class Solution:
    def maximumBuilding(self, n: int, restrictions: List[List[int]]) -> int:
        restrictions.append([1, 0])
        restrictions.append([n, float('inf')])
        restrictions.sort()

        for i in range(1, len(restrictions)):
            left_id, left_height = restrictions[i - 1]
            right_id, right_height = restrictions[i]
            max_height = (right_height + (right_id - left_id)) // 2
            if max_height > left_height + (right_id - left_id):
                max_height = left_height + (right_id - left_id)
            restrictions[i][1] = max_height

        max_height = 0
        for i in range(len(restrictions) - 1):
            left_id, left_height = restrictions[i]
            right_id, right_height = restrictions[i + 1]
            max_height = max(max_height, (left_height + right_height + (right_id - left_id)) // 2)

        return max_height