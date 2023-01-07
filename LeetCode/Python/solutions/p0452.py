from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        #
        # Solution v1: narrow the overlap interval
        #
        #
        points.sort(key=lambda p: p[0])
        # print(f"points => {points}")

        stack = []
        for s, e in points:
            if len(stack) > 0 and stack[-1][1] >= s:
                last_s, last_e = stack.pop()
                stack.append([max(last_s, s), min(last_e, e)])
            else:
                stack.append([s, e])

        return len(stack)

        #
        # Solution v2: find the latest maximum end point
        #
        #
        points = sorted(points, key=lambda p: p[1])
        ans = 0
        last_max = -float('inf')
        for start, end in points:
            if start > last_max:
                ans += 1
                last_max = end

        return ans


if __name__ == "__main__":
    solution = Solution()

    points = [[10, 16], [2, 8], [1, 6], [7, 12]]
    print(f"return: {solution.findMinArrowShots(points)}")
    points = [[1, 2], [3, 4], [5, 6], [7, 8]]
    print(f"return: {solution.findMinArrowShots(points)}")
    points = [[-1, 1], [0, 1], [2, 3], [1, 2]]
    print(f"return: {solution.findMinArrowShots(points)}")
