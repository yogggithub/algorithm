from typing import List, Optional

from Python.auxiliary.TreeNode import TreeNode


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 377 ms @ (beats) 7.37%
        # Memory Usage: 19.7 MB @ (beats) 64.82%
        #
        # if len(inorder) == 1:
        #     return TreeNode(inorder[0])
        #
        # def builder(in_order, in_left, in_right,
        #             post_order, post_left, post_right) -> Optional[TreeNode]:
        #     if in_left > in_right or post_left > post_right:
        #         return None
        #
        #     root = TreeNode(post_order[post_right])
        #
        #     i = in_left
        #
        #     for _ in range(i, len(in_order)):
        #         if in_order[i] == root.val:
        #             break
        #         i += 1
        #
        #     root.left = builder(in_order, in_left, i - 1,
        #                         post_order, post_left, post_left + i - in_left - 1)
        #
        #     root.right = builder(in_order, i + 1, in_right,
        #                          post_order, post_left + i - in_left, post_right - 1)
        #
        #     return root
        #
        # return builder(inorder, 0, len(inorder) - 1,
        #                postorder, 0, len(postorder) - 1)

        #
        # Solution v2: Algorithm improvement
        #
        # Runtime: 55 ms @ (beats) 92.57%
        # Memory Usage: 19 MB @ (beats) 70.3%
        #
        post_root = len(postorder) - 1

        val_index_map = dict(zip(inorder, range(len(inorder))))

        def builder(start, end):
            nonlocal post_root
            if start > end:
                return None

            root_val = postorder[post_root]
            root = TreeNode(root_val)
            in_root = val_index_map[root_val]

            post_root -= 1

            root.right = builder(in_root + 1, end)
            root.left = builder(start, in_root - 1)

            return root

        return builder(0, len(inorder) - 1)
