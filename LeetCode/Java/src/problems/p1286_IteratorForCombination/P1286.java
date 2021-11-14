package problems.p1286_IteratorForCombination;

import java.util.ArrayList;

public class P1286 {
    /*
     * Solution v1: Recursive
     *
     * Runtime: 18 ms @ (beats) 46.63%
     * Memory Usage: 41 MB @ (beats) 70.98%
     */
    //
    // // a list to store all result
    // Queue<String> result;
    // int currentLength;
    //
    // // String characters;
    // public CombinationIterator(String characters, int combinationLength) {
    //     this.result = new LinkedList<>();
    //     this.currentLength = combinationLength;
    //     buildCombination(characters, 0, "");
    //
    // }
    //
    // /*
    //  * Solution v1: Recursive
    //  */
    // private void buildCombination(String characters, int index, String combination) {
    //     // pay attention that must add to list first
    //     // cause the index may reach the end, but the string is valid.
    //
    //     // the string gets required length, add to the list
    //     if (combination.length() == this.currentLength) {
    //         this.result.add(combination);
    //         return;
    //     }
    //
    //     // reach the end, stop recursive
    //     if (index >= characters.length()) {
    //         return;
    //     }
    //
    //     for (int i = index; i < characters.length(); i++) {
    //         buildCombination(characters, i + 1, combination + characters.charAt(i));
    //     }
    // }
    //
    // public String next() {
    //     return this.result.poll();
    // }
    //
    // public boolean hasNext() {
    //     System.out.println(this.result.peek());
    //     return !this.result.isEmpty();
    // }

    /*
     * (learn from Internet)
     * Solution v3: bit icon
     */
    // idea
    // use 1/0 to mark each char be selected or not
    // take "abc", 2 as example
    // 1st: 110 = 6, means result is "ab"
    // 1st: 101 = 5, means result is "ac"
    // 1st: 011 = 3, means result is "bc"
    ArrayList<Integer> comb;
    int pointer;
    String str;

    // fake claration to avoid IDE warning
    public P1286(String characters, int combinationLength) {
    // public CombinationIterator(String characters, int combinationLength) {
        this.comb = new ArrayList<>();
        this.pointer = 0;
        this.str = characters;
        int n = characters.length();
        for (int i = (1 << n) - 1; i > 0; i--) {
            if (Integer.bitCount(i) == combinationLength) {
                comb.add(i);
            }
        }
    }

    public String next() {
        StringBuilder ans = new StringBuilder();
        int num = this.comb.get(this.pointer++);
        int index = str.length() - 1;
        while (num > 0) {
            if ((num & 1) > 0) {
                ans.insert(0, str.charAt(index));
            }
            num >>= 1;
            index--;
        }
        return ans.toString();
    }

    public boolean hasNext() {
        return this.pointer < this.comb.size();
    }
}
