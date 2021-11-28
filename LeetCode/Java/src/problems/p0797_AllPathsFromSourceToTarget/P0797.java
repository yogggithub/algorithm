package problems.p0797_AllPathsFromSourceToTarget;

import java.util.*;

public class P0797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /*
         * (learn from Internet)
         * Solution v1: Backtracking
         */
        // List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> path = new ArrayList<>();
        // path.add(0);
        // allPathsSourceTarget(graph, ans, path, 0);
        // return ans;

        /*
         * (learn from Internet)
         * Solution v2: Memorization
         */
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        return allPathsSourceTarget(graph, 0, map);
    }

    /*
     * Solution v2: Memorization
     */
    private List<List<Integer>> allPathsSourceTarget(int[][] graph,
                                                     int current,
                                                     Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(current)) {
            return map.get(current);
        }

        List<List<Integer>> ans = new ArrayList<>();
        if (current == graph.length - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(current);
            ans.add(path);
        } else {
            for (int next : graph[current]) {
                List<List<Integer>> subPaths = allPathsSourceTarget(graph, next, map);
                for (List<Integer> path : subPaths) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(current);
                    ans.add(newPath);
                }
            }
        }

        map.put(current, ans);
        return ans;
    }

    /*
     * Solution v1: Backtracking
     */
    private void allPathsSourceTarget(int[][] graph,
                                      List<List<Integer>> paths,
                                      List<Integer> path,
                                      int current) {
        if (current == graph.length - 1) {
            // pay attention here
            // can not directly add path to answer
            // cause if do that way, the path will be modified
            // in future processing
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int next : graph[current]) {
            path.add(next);
            allPathsSourceTarget(graph, paths, path, next);
            // backtracking
            // if the app reach here, that means the node cannot reach the target
            // thus, need to delete this node from the result list

            // Classic backtracking template.
            // 1. Make a choice.
            // 2. Explore on that choice by recursing.
            // 3. Undo the choice -- this is where you decrement the length by undoing step 1.
            path.remove(path.size() - 1);
        }
    }
}
