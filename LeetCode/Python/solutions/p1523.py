class Solution:
    def countOdds(self, low: int, high: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 26 ms @ (beats) 91.41%
        # Memory Usage: 13.8 MB @ (beats) 50.4%
        #

        # ans = int((high - low) / 2)
        # if low % 2 != 0:
        #     ans += 1
        # if high % 2 != 0:
        #     ans += 1
        # return ans

        #
        # Solution v2:
        #
        return (high - low) // 2 + (high % 2 or low % 2)


if __name__ == "__main__":
    solution = Solution()

    low = 3
    high = 7
    print(f"return: {solution.countOdds(low, high)}")  # 3

    low = 8
    high = 10
    print(f"return: {solution.countOdds(low, high)}")  # 1
