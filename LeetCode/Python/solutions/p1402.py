from typing import List


class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        #
        # Solution v1: Greedy
        #
        # Runtime: 43 ms @ (beats) 69.30%
        # Memory Usage: 13.9 MB @ (beats) 46.84%
        #
        satisfaction.sort(reverse=True)
        ans = 0
        curr_sati = 0
        for dish in satisfaction:
            curr_sati += dish
            if curr_sati < 0:
                break
            # this step is the core
            # accumulate addition will make sure
            # every dish be counted in correct times.
            ans += curr_sati

        return ans


if __name__ == "__main__":
    solution = Solution()

    satisfaction = [-1, -8, 0, 5, -9]
    print(f"return: {solution.maxSatisfaction(satisfaction)}")  # 14

    satisfaction = [4, 3, 2]
    print(f"return: {solution.maxSatisfaction(satisfaction)}")  # 20

    satisfaction = [-1, -4, -5]
    print(f"return: {solution.maxSatisfaction(satisfaction)}")  # 0
