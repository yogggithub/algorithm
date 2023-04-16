class Solution:
    def simplifyPath(self, path: str) -> str:
        #
        # Solution v1: Brute Force
        #
        # Runtime: 38 ms @ (beats) 38.74%
        # Memory Usage: 13.9 MB @ (beats) 28.25%
        #
        # ans = []
        # path = path.split("/")
        #
        # for p in path:
        #     # if there is a parent folder, go back
        #     # else do nothing
        #     if ans and p == "..":
        #         ans.pop()
        #     # append valid folder to result set
        #     # '.'  or ''('//') both mean stay current folder
        #     elif p not in [".", "..", ""]:
        #         ans.append(p)
        #
        # # add leading '/', and separate folder with '/'
        # return "/" + "/".join(ans)

        #
        # Solution v1.1: Brute Force
        # Performance improvement
        #
        # Runtime: 33 ms @ (beats) 73.24%
        # Memory Usage: 13.7 MB @ (beats) 97.52%
        #
        ans = []
        path = path.split("/")
        for p in path:
            if p == "":
                continue
            elif p == "..":
                if ans:
                    ans.pop()
            elif p != ".":
                ans.append(p)
        return "/" + "/".join(ans)


if __name__ == "__main__":
    solution = Solution()

    path = "/home/"
    print(f"return: {solution.simplifyPath(path)}")  # "/home"
    #
    # path = "/../"
    # print(f"return: {solution.simplifyPath(path)}")  # "/"
    #
    path = "/home//foo/"
    print(f"return: {solution.simplifyPath(path)}")  # "/home/foo"
    #
    # path = "/.../foo/"
    # print(f"return: {solution.simplifyPath(path)}")  # "/.../foo"

    path = "/a/./b/../../c/"
    print(f"return: {solution.simplifyPath(path)}")  # "/c"
