class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        m = len(num1)
        n = len(num2)
        pos = [0] * (m + n)
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                temp = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
                x = i + j
                y = i + j + 1
                sum = temp + pos[y]
                pos[x] += sum // 10
                pos[y] = sum % 10

        res = ""
        for p in pos:
            if not (len(res) == 0 and p == 0):
                res += str(p)
        return res if len(res) != 0 else "0"
