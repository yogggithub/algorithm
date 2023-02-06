class Solution:
    def convert(self, s: str, numRows: int) -> str:
        #
        # Solution v1: Brute Force
        # Ignore the col, just focus on the row order
        #
        # Runtime: ms @ (beats) %
        # Memory Usage: MB @ (beats) %
        #

        if numRows == 1:
            return s

        ans = [""] * numRows

        r = 0
        d = 1  # 1 for going to bottom, -1 as going to top
        for i in range(len(s)):
            ans[r] += s[i]

            # when reach top/bottom, revert direction
            if r == numRows - 1:
                d = -1
            elif r == 0:
                d = 1

            r += d

        return "".join(ans)


if __name__ == "__main__":
    solution = Solution()

    s = "PAYPALISHIRING"
    numRows = 3
    print(f"return: {solution.convert(s, numRows)}")  # "PAHNAPLSIIGYIR"

    # s = "PAYPALISHIRING"
    # numRows = 4
    # print(f"return: {solution.convert(s, numRows)}")  # "PINALSIGYAHRPI"
    #
    # s = "A"
    # numRows = 1
    # print(f"return: {solution.convert(s, numRows)}")  # "A"
