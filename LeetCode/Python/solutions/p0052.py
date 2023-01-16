from typing import List


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:

        #
        # Solution v1: Brute Force
        #
        # Runtime: 82 ms @ (beats) 87.16%
        # Memory Usage: 17.3 MB @ (beats) 91.18%
        #

        ans = []

        for i in range(len(intervals)):
            if newInterval[1] < intervals[i][0]:
                ans.append(newInterval)
                return ans + intervals[i:]
            elif newInterval[0] > intervals[i][1]:
                ans.append(intervals[i])
            else:
                newInterval = [
                    min(intervals[i][0], newInterval[0]),
                    max(intervals[i][1], newInterval[1])
                ]
                print(newInterval)

        ans.append(newInterval)

        return ans


if __name__ == "__main__":
    solution = Solution()

    intervals = [[1, 3], [6, 9]]
    newInterval = [2, 5]
    print(f"return: {solution.insert(intervals, newInterval)}")  # [[1,5],[6,9]]

    intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    newInterval = [4, 8]
    print(f"return: {solution.insert(intervals, newInterval)}")  # [[1,2],[3,10],[12,16]]
