package solutions.p0443_StringCompression;


public class P0443 {
    public static void main(String[] args) {

        P0443 s = new P0443();

        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        // System.out.println(s.compress(chars));
        //
        // chars = new char[]{'a'};
        // System.out.println(s.compress(chars));
        //
        // chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        // System.out.println(s.compress(chars));


        chars = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        System.out.println(s.compress(chars));
    }


    public int compress(char[] chars) {
        int ans = 0;
        int i = 0;
        int count = 0;

        while (i < chars.length) {
            char curr = chars[i];
            while (i < chars.length && chars[i] == curr) {
                i++;
                count++;
            }
            chars[ans++] = curr;

            if (count > 1) {
                char[] temp = String.valueOf(count).toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    chars[ans++] = temp[j];
                }
            }
            count = 0;
        }
        System.out.println(chars);
        return ans;

    }
}
