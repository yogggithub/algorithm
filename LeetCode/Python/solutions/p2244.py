from typing import List
from collections import Counter


class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        #
        # Solution v1: brute force
        #
        # Runtime: 2325ms @ (beats) 40.82%
        # Memory Usage: 28.6 MB @ (beats) 23.93%
        #
        if len(tasks) == 1:
            return -1

        temp = sorted(tasks)

        lvl = temp[0]

        count = 0
        counts = []
        for t in temp:
            if t == lvl:
                count += 1
            else:
                counts.append(count)
                lvl = t
                count = 1
            # print(f"ele: {t}, lvl={lvl}, count={count}")

        counts.append(count)
        # print(f"r={counts}")

        ans = 0
        for c in counts:
            if c == 1:
                return -1

            if c == 2 or c == 3:
                ans += 1
            else:
                ans += int(c / 3)
                if c % 3 != 0:
                    ans += 1
            # print(f"ans={ans}")

        return ans

        #
        # Solution v2: built-in Counter() function
        #
        #
        freqs = Counter(tasks)
        res = 0
        for task, freq in freqs.items():
            if freq == 1:
                return -1
            # // operator round the division to nearest integer
            # hence plus a 2 to make sure the reminder to be counted in
            res += (freq + 2) // 3

            # alternative method:
            res += math.ceil(freq / 3)
        return res

if __name__ == "__main__":
    tasks = [9,9,9,11,11,22,22,22,22,55,55]
    solution = Solution()
    solution.minimumRounds(tasks)
