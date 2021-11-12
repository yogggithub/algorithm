package problems.p0020_ValidParentheses;

public class P0020 {
    public static void main(String[] args) {

        P0020 s = new P0020();
        solution solution = new solution();

        String str1 = "{[]}";
        System.out.println(s.isValid(str1));
        System.out.println(solution.isValid(str1));

        String str2 = "()[]{}";
        System.out.println(s.isValid(str2));
        System.out.println(solution.isValid(str2));

        String str3 = "([)]";
        System.out.println(s.isValid(str3));
        System.out.println(solution.isValid(str3));
    }


    public boolean isValid(String s) {

        // Brute Force

        // submission 3 (previous 2 have code error
        // can not resolve ()[]{} type
        // int temp = 0;
        // if (s.length() % 2 != 0) {
        //     temp++;
        // } else {
        //     int left = s.length() / 2 - 1;
        //     int right = s.length() / 2;
        //     while ( left >= 0 && right <= s.length() + 1 ){
        //         if (s.charAt(left) == '(' && s.charAt(right) == ')') {
        //         } else if (s.charAt(left) == '[' && s.charAt(right) == ']') {
        //         } else if (s.charAt(left) == '{' && s.charAt(right) == '}') {
        //         } else {
        //             temp++;
        //         }
        //         left--;
        //         right++;
        //     }
        // }
        // if (temp > 0) {
        //     return false;
        // } else {
        //     return true;
        // }


        // submission 4
        // 逻辑不对，不能提交

        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     map.put(s.toCharArray()[i], i);
        // }
        // Iterator iterator = map.keySet().iterator();

        // char[] chars = s.toCharArray();
        // int temp = 0;
        // System.out.println(chars.length);
        //
        // int frequencyYuanZ = 0, frequencyYuanY = 0, frequencyFangZ = 0,
        //         frequencyFangY = 0, frequencyHuaZ = 0, frequencyHuaY = 0;
        // for (int i = 0; i < chars.length; i++) {
        //     if (chars[i] == '(') {
        //         frequencyYuanZ++;
        //     } else if (chars[i] == ')') {
        //         frequencyYuanY++;
        //     } else if (chars[i] == '[') {
        //         frequencyFangZ++;
        //     } else if (chars[i] == ']') {
        //         frequencyFangY++;
        //     } else if (chars[i] == '{') {
        //         frequencyHuaZ++;
        //     } else if (chars[i] == '}') {
        //         frequencyHuaY++;
        //     }
        // }
        //
        // if (frequencyYuanZ == frequencyYuanY
        //         && frequencyFangZ == frequencyFangY
        //         && frequencyHuaZ == frequencyHuaY) {
        //     for (int i = 0; i < chars.length; i++) {
        //         if (chars[i] == '(') {
        //             int p1 = Arrays.binarySearch(chars, ')');
        //             if (p1 > i
        //                     && p1 < Arrays.binarySearch(chars, ']') && Arrays.binarySearch(chars, ']') > i
        //                     && p1 < Arrays.binarySearch(chars, '}') && Arrays.binarySearch(chars, '}') > i) {
        //                 chars[i] = '|';
        //             } else {
        //                 temp++;
        //             }
        //         } else if (chars[i] == '[') {
        //             int p2 = Arrays.binarySearch(chars, ']');
        //             if (p2 > i
        //                     && (p2 < Arrays.binarySearch(chars, ')') && Arrays.binarySearch(chars, ')') > i)
        //                     || (p2 < Arrays.binarySearch(chars, '}') && Arrays.binarySearch(chars, '}') > i)) {
        //                 chars[i] = '|';
        //             } else {
        //                 temp++;
        //             }
        //         } else if (chars[i] == '{') {
        //             int p3 = Arrays.binarySearch(chars, '}');
        //             if (p3 > i
        //                     && p3 < Arrays.binarySearch(chars, ')') && Arrays.binarySearch(chars, ')') > i
        //                     && p3 < Arrays.binarySearch(chars, ']') && Arrays.binarySearch(chars, ']') > i) {
        //                 chars[i] = '|';
        //             } else {
        //                 temp++;
        //             }
        //         }
        //
        //     }
        // } else {
        //     temp ++;
        // }
        //
        // if (temp == 0) {
        //     return true;
        // } else {
        //     return false;
        // }

        // submission 5
        // 看了solution的动画
        // 失败点：
        // 缺失一种符号的情况
        // --计数时需要回头看是否有其他类型的

        // char[] chars = s.toCharArray();
        // int frequencyYuanZ = 0,
        //         frequencyFangZ = 0,
        //         frequencyHuaZ = 0;
        // int temp = 0;
        //
        // for (int i = 0; i < chars.length; i++) {
        //     if (chars[i] == '(') {
        //         frequencyYuanZ++;
        //         int p1 = -1, p2 = -1, p3 = -1;
        //         for (int j = i + 1; j < chars.length; j++) {
        //             if (chars[j] == '(' && p1 < j) {
        //                 p1 = j;
        //             }
        //             if (chars[j] == '[' && p2 < j) {
        //                 p2 = j;
        //             }
        //             if (chars[j] == '{' && p3 < j) {
        //                 p3 = j;
        //             }
        //             if (p1 != -1) {
        //                 if (p1 < p2 && p2 != -1) {
        //                     temp++;
        //                 }
        //                 if (p1 < p3 && p3 != -1) {
        //                     temp++;
        //                 }
        //             }
        //         }
        //     } else if (chars[i] == ')') {
        //         int p11 = 0, p21 = 0, p31 = 0;
        //         for (int j = i; j >= 0; j--) {
        //             if (chars[j] == '(' && p11 < j) {
        //                 p11 = j;
        //             }
        //             if (chars[j] == ']' && p21 > j) {
        //                 p21 = j;
        //             }
        //             if (chars[j] == '}' && p31 > j) {
        //                 p31 = j;
        //             }
        //             if (p11 != -1) {
        //                 if (p11 > p21 && p21 != 0) {
        //                     temp++;
        //                 } else if (p11 > p31 && p31 != 0) {
        //                     temp++;
        //                 } else {
        //                     frequencyYuanZ--;
        //                 }
        //             }
        //             if (frequencyYuanZ < 0) {
        //                 temp++;
        //             }
        //         }
        //     } else if (chars[i] == '[') {
        //         frequencyFangZ++;
        //         int p4 = 0, p5 = 0, p6 = 0;
        //         for (int j = i + 1; j < chars.length; j++) {
        //             if (chars[j] == ']' && p4 > j) {
        //                 p4 = j;
        //             }
        //             if (chars[j] == ')' && p5 > j) {
        //                 p5 = j;
        //             }
        //             if (chars[j] == '}' && p6 > j) {
        //                 p6 = j;
        //             }
        //             if (p4 != 0) {
        //                 if (p4 > p5 && p5 != 0) {
        //                     temp++;
        //                 }
        //                 if (p4 > p6 && p6 != 0) {
        //                     temp++;
        //                 }
        //             }
        //         }
        //     } else if (chars[i] == ']') {
        //         frequencyFangZ--;
        //         if (frequencyFangZ < 0) {
        //             temp++;
        //         }
        //     } else if (chars[i] == '{') {
        //         frequencyHuaZ++;
        //         int p7 = 0, p8 = 0, p9 = 0;
        //         for (int j = i + 1; j < chars.length; j++) {
        //             if (chars[j] == '}' && p7 > j) {
        //                 p7 = j;
        //             }
        //             if (chars[j] == ')' && p8 > j) {
        //                 p8 = j;
        //             }
        //             if (chars[j] == ']' && p9 > j) {
        //                 p9 = j;
        //             }
        //             if (p7 != 0) {
        //                 if (p7 > p8 && p8 != 0) {
        //                     temp++;
        //                 }
        //                 if (p7 > p9 && p9 != 0) {
        //                     temp++;
        //                 }
        //             }
        //         }
        //     } else if (chars[i] == '}') {
        //         frequencyHuaZ--;
        //         if (frequencyHuaZ < 0) {
        //             temp++;
        //         }
        //     }
        // }
        //
        // if (frequencyYuanZ != 0
        //         || frequencyFangZ != 0
        //         || frequencyHuaZ != 0) {
        //     temp++;
        // }
        //
        // if (temp == 0) {
        //     return true;
        // } else {
        //     return false;
        // }

        // submission 6
        /*
         * 看了solution后的一种思路
         * 依照Stack的思路，用一个数组当缓存区
         * 左边符号装进去，右边符号就与数组中最末一位比较
         * 用一个变量来控制缓存数组的指针位置
         * 注意这个指针比要比较的元素大一位
         * 最后判断指针是否回到0
         *
         */

        char[] chars = s.toCharArray();
        char[] judge = new char[s.length()];
        int index = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('
                    || chars[i] == '['
                    || chars[i] == '{'){
                judge[index] = chars[i];
                index++;
            }

            if (index > 0){
                if (chars[i] == ')'){
                    if(judge[index - 1] == '('){
                        index --;
                    } else {
                        return false;
                    }
                } else if (chars[i] == ']'){
                    if(judge[index - 1] == '['){
                        index --;
                    } else {
                        return false;
                    }
                } else if (chars[i] == '}'){
                    if(judge[index - 1] == '{'){
                        index --;
                    } else {
                        return false;
                    }
                }
            } else{
                return false;
            }
        }

        if (index != 0){
            return false;
        } else {
            return true;
        }

        // Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Parentheses.
        // Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Valid Parentheses.
    }
}
