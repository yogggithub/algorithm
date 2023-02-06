from collections import defaultdict
from typing import List


class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        dp = [0] * (max(ages) + 1)

        age_score = sorted(zip(scores, ages))

        print(age_score)

        for score, age in age_score:
            dp[age] = score + max(dp[:(age + 1)])

        print(dp)

        return max(dp)


if __name__ == "__main__":
    solution = Solution()

    # scores = [1, 3, 5, 10, 15]
    # ages = [1, 2, 3, 4, 5]
    # print(f"return: {solution.bestTeamScore(scores, ages)}")  # 34

    scores = [4, 5, 6, 5]
    ages = [2, 1, 2, 1]
    print(f"return: {solution.bestTeamScore(scores, ages)}")  # 16

