class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        #
        # Solution v1: recursive
        #
        # Runtime: 21 ms @ (beats) 98.66%
        # Memory Usage: 14 MB @ (beats) 14%
        #
        s_arr = s.split(" ")
        if len(s_arr) < len(pattern):
            return False
        elif len(s_arr) == len(pattern):
            temp = {}
            for i in range(len(pattern)):
                p = temp.get(pattern[i])
                if p:
                    if s_arr[i] != p:
                        return False
                else:
                    temp[pattern[i]] = s_arr[i]

            val = list(set(temp.values()))
            if len(val) < len(temp):
                return False

            return True
        else:
            if len(s_arr) % len(pattern) != 0:
                return False

            res = []
            for i in range(0, len(s_arr) - len(pattern) + 1):
                sub = " ".join(s_arr[i:(i + len(pattern))]).strip()
                res.append(self.wordPattern(pattern, sub))

            for r in res:
                if not r:
                    return False

            return True

        #
        # Solution v2: fail test when s longer than pattern
        #
        #
        s = s.split(' ')
        map = {}
        if len(s) != len(pattern) or len(set(s)) != len(set(pattern)):
            return False

        for i in range(len(pattern)):
            if pattern[i] in map and map[pattern[i]] != s[i]:
                return False
            map[pattern[i]] = s[i]

        return True


if __name__ == "__main__":
    solution = Solution()

    pattern = "abba"

    s = "dog dog dog dog"
    print(f"return: {solution.wordPattern(pattern, s)}")
    s = "dog cat cat dog goose"
    print(f"return: {solution.wordPattern(pattern, s)}")
