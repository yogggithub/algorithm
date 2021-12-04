from typing import Optional

from Python.auxiliary.ListNode import ListNode


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:

        #
        # Solution v1: Iterative
        #
        # Runtime: 36 ms @ (beats) 79.64%
        # Memory Usage: 14.3 MB @ (beats) 32.96%
        #
        # if list1 and not list2:
        #     return list1
        # elif not list1 and list2:
        #     return list2
        #
        # ans = temp = ListNode()
        # while list1 or list2:
        #     temp.next = ListNode()
        #     temp = temp.next
        #     if list1 and not list2:
        #         temp.val = list1.val
        #         list1 = list1.next
        #     elif not list1 and list2:
        #         temp.val = list2.val
        #         list2 = list2.next
        #     else:
        #         if list1.val <= list2.val:
        #             temp.val = list1.val
        #             list1 = list1.next
        #         else:
        #             temp.val = list2.val
        #             list2 = list2.next
        # return ans.next

        #
        # Solution v2: Recursive
        #
        # Runtime: 52 ms @ (beats) 20.18%
        # Memory Usage: 14.4 MB @ (beats) 32.96%
        #

        if list1 and not list2:
            return list1
        elif not list1 and list2:
            return list2
        elif not list1 and not list2:
            return None

        ans = ListNode()

        if list1.val <= list2.val:
            ans.val = list1.val
            ans.next = self.mergeTwoLists(list1.next, list2)
        else:
            ans.val = list2.val
            ans.next = self.mergeTwoLists(list1, list2.next)

        return ans


def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    #
    # (learn from Internet)
    # Solution v1.2: Iterative

    # base case
    if (not list1) and (not list2):
        return list1 or list2
    if not list1:
        return list2
    if not list2:
        return list1

    l1, l2 = list1, list2

    l3 = dummy = ListNode(-1)

    while l1 and l2:
        l1_val, l2_val = l1.val, l2.val

        if l1_val < l2_val:
            dummy.next = l1
            l1 = l1.next
        else:
            dummy.next = l2
            l2 = l2.next

        dummy = dummy.next

    dummy.next = l1 or l2
    return l3.next
    #
    # (learn from Internet)
    # Solution v2.2: Recursive
    #
    if list1 and list2:
        if list1.val > list2.val:
            # swap here
            list1, list2 = list2, list1
        list1.next = self.mergeTwoLists(list1.next, list2)
    return list1 or list2
