from typing import List


class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 307 ms @ (beats) 77.55%
        # Memory Usage: 15.3 MB @ (beats) 11.71%
        #

        k_str = f"{k}"

        i = len(num) - 1
        j = len(k_str) - 1

        ans = [0] * (max(i, j) + 2)

        k = len(ans) - 1
        surplus = 0
        while k >= 0:
            x = 0
            y = 0
            if i >= 0:
                x = int(num[i])
            if j >= 0:
                y = int(k_str[j])

            temp = x + y + surplus

            ans[k] = temp % 10

            surplus = temp // 10

            i -= 1
            j -= 1
            k -= 1

        if ans[0] == 0:
            ans = ans[1:]

        return ans


if __name__ == "__main__":
    solution = Solution()

    num = [1, 2, 0, 0]
    k = 34
    print(f"return: {solution.addToArrayForm(num, k)}")  # [1,2,3,4]

    num = [2, 7, 4]
    k = 181
    print(f"return: {solution.addToArrayForm(num, k)}")  # [4,5,5]

    num = [2, 1, 5]
    k = 806
    print(f"return: {solution.addToArrayForm(num, k)}")  # [1,0,2,1]
