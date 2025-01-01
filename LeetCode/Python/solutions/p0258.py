class Solution:
    def addDigits(self, num: int) -> int:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 48 ms @ (beats) 6.65%
        # Memory Usage: 16.3 MB @ (beats) 39.79%
        #
        # if num < 10:
        #     return num
        #
        # temp = 0
        # while num:
        #     temp += num % 10
        #     num //= 10
        #
        # return self.addDigits(temp)

        #
        # Solution v1.5: Iterative
        #
        # Runtime: 48 ms @ (beats) 6.65%
        # Memory Usage: 16.3 MB @ (beats) 39.79%
        #
        while num > 9:
            temp = 0
            while num:
                temp += num % 10
                num //= 10
            num = temp
        return num

        #
        # Solution v2: Convert to string
        #
        # Runtime: 40 ms @ (beats) 18%
        # Memory Usage: 13.8 MB @ (beats) 90.82%
        #
        num_str = str(num)

        while len(num_str) > 1:
            temp = 0
            for n in num_str:
                temp += int(n)
            num_str = str(temp)
        else:
            return int(num_str)


if __name__ == "__main__":
    solution = Solution()

    num = 38
    print(f"return: {solution.addDigits(num)}")  # 2

    num = 0
    print(f"return: {solution.addDigits(num)}")  # 0
