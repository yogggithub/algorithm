from typing import List


class Solution:
    def compress(self, chars: List[str]) -> int:
        #
        # Solution v1: Brute Force
        #
        # Wrong Answer
        # chars has to modified in-place

        # ans = ""
        # count = 0
        # for i in range(len(chars)):
        #     curr = chars[i]
        #
        #     if ans and curr == ans[-1]:
        #         count += 1
        #         continue
        #
        #     ans += curr
        #     if count > 1:
        #         ans += str(count)
        #
        #     count = 1
        #
        # if count > 1:
        #     ans += str(count)
        #
        # l = len(ans)
        #
        # chars = list(ans) + chars[l + 1:]
        #
        # return l

        #
        # Solution v2: Brute Force
        #
        # Runtime: 57 ms @ (beats) 86.52%
        # Memory Usage: 13.9 MB @ (beats) 96.79%
        #
        ans = 0

        i = 0
        while i < len(chars):
            curr = chars[i]

            chars[ans] = curr
            ans += 1

            count = 0
            while i < len(chars) and chars[i] == curr:
                count += 1
                i += 1

            if count > 1:
                for c in str(count):
                    chars[ans] = c
                    ans += 1
        # print(chars)
        return ans


if __name__ == "__main__":
    solution = Solution()

    chars = ["a", "a", "b", "b", "c", "c", "c"]
    print(f"return: {solution.compress(chars)}")  # 6

    chars = ["a"]
    print(f"return: {solution.compress(chars)}")  # 1

    chars = ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"]
    print(f"return: {solution.compress(chars)}")  # 4

    chars = ["a", "a", "b", "b"]
    print(f"return: {solution.compress(chars)}")  # 6
