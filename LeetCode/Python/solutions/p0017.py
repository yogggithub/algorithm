from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mp = [
            [], # index 0 garbage
            [], # number 1 maps to nothing
            ["a", "b", "c"],
            ["d", "e", "f"],
            ["g", "h", "i"],
            ["j", "k", "l"],
            ["m", "n", "o"],
            ["p", "q", "r", "s"],
            ["t", "u", "v"],
            ["w", "x", "y", "z"]
        ]

        #
        # Solution v1: Brute Force
        #
        # Runtime: 29 ms @ (beats) 90.95%
        # Memory Usage: 13.9 MB @ (beats) 27.70%
        #

        def func(resp, digit):
            if resp:
                temp = []
                for s in resp:
                    for c in mp[digit]:
                        temp.append(f"{s}{c}")
                    print(temp)

                return temp
            else:
                return mp[digit]

        length = len(digits)
        if length == 0:
            return []
        elif length == 1:
            return mp[int(digits[0])]
        else:
            ans = []
            for d in digits:
                print("else")
                ans = func(ans, int(d))

            return ans


if __name__ == "__main__":
    solution = Solution()

    digits = "23"
    print(f"return: {solution.letterCombinations(digits)}")

    digits = ""
    print(f"return: {solution.letterCombinations(digits)}")
