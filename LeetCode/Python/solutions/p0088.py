from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        #
        # Solution v1: Three pointers
        #
        # Runtime: 36 ms @ (beats) 74.62%
        # Memory Usage: 14.4 MB @ (beats) 33.07%
        #
        l = m + n - 1
        while l >= 0:
            if m > 0 and n > 0:
                if nums1[m - 1] >= nums2[n - 1]:
                    nums1[l] = nums1[m - 1]
                    m -= 1
                else:
                    nums1[l] = nums2[n - 1]
                    n -= 1
            elif m > 0:
                nums1[l] = nums1[m - 1]
                m -= 1
            else:
                nums1[l] = nums2[n - 1]
                n -= 1
