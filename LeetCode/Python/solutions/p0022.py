from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        def helper(left, right, curr):

            if len(curr) == n * 2:
                ans.append(curr)

            if left < n:
                helper(left + 1, right, curr+ "(")

            if left > right:
                helper(left, right + 1, curr + ")")

        helper(0, 0, "")

        return ans

if __name__ == "__main__":
    solution = Solution()

    n = 3
    print(f"return: {solution.generateParenthesis(n)}")

    n = 1
    print(f"return: {solution.generateParenthesis(n)}")
