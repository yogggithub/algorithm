import collections


class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        #
        # Solution v1: Brute Force
        #
        # Idea:
        # 1. Ingore all leading 0
        # 2. Once hit a 1, increment 'ones'
        # 3. Afterward,
        # meet a 1, increment 'ones'
        # meet a 0, decrement 'ones' when it is positive
        #   Because during the process,
        #   I can not decided flip this 0 or a most recent 1 unless reaching the end
        #   but it definitely means a flip.
        #   so, here 'ones' stands for whether 1 is more than 0 or not
        ones, ans = 0, 0
        for num in s:
            if num == '1':
                ones += 1
            elif ones:
                ones -= 1
                ans += 1
        return ans


if __name__ == "__main__":
    solution = Solution()

    s = "00110"
    print(f"return: {solution.minFlipsMonoIncr(s)}")  # 1 -> 00111

    # s = "010110"
    # print(f"return: {solution.minFlipsMonoIncr(s)}")  # 2 -> 010110 / 000111
    #
    # s = "00011000"
    # print(f"return: {solution.minFlipsMonoIncr(s)}")  # 2 -> 00000000
    #
    # s = "01110"
    # print(f"return: {solution.minFlipsMonoIncr(s)}")  # 1 -> 01111 / 11110
    #
    # s = "10001"
    # print(f"return: {solution.minFlipsMonoIncr(s)}")  # 1 -> 01111 / 11110
