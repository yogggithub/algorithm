from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        path = []

        self.trasve(0, s, path, ans)

        return ans

    def trasve(self, idx, s, path, ans):
        if idx == len(s):
            ans.append(path[:])
            return

        for i in range(idx, len(s)):
            if self.is_palindro(s, idx, i):
                path.append(s[idx: i + 1])
                self.trasve(i + 1, s, path, ans)
                path.pop()

    def is_palindro(self, string, s, e):
        while s <= e:
            if string[s] != string[e]:
                return False
            s += 1
            e -= 1
        return True


if __name__ == "__main__":
    solution = Solution()

    # s = "aab"
    # print(f"return: {solution.partition(s)}")  # [["a","a","b"],["aa","b"]]

    s = "xxxyyy"
    print(f"return: {solution.partition(s)}")  # [["a","a","b"],["aa","b"]]
