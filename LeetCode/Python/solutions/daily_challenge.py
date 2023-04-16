from typing import List


class Solution:
    def isValid(self, s: str) -> bool:
        mp = {
            "(": ")",
            "[": "]",
            "{": "}"
        }

        q = []
        for p in s:
            if p in mp.keys():
                q.append(p)
                continue

            if not q:
                return False

            t = q.pop()
            if p != mp.get(t):
                return False

        return not q


if __name__ == "__main__":
    solution = Solution()

    s = "()"
    print(f"return: {solution.isValid(s)}")  # True

    s = "()[]{}"
    print(f"return: {solution.isValid(s)}")  # True

    s = "(]"
    print(f"return: {solution.isValid(s)}")  # False
