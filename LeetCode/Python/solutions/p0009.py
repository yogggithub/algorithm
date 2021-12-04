class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        else:
            y = x
            n = 0
            while y // 10 > 0:
                n = n * 10 + y % 10
                y /= 10
            n = n * 10 + y
            print(n)
            return n == x
