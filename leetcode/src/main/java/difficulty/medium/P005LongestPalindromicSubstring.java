package difficulty.medium;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/1 11:56
 */
public class P005LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int ans = Integer.MIN_VALUE;
        int li = 0;
        int ri = 0;
        int length = s.length();
        for (int center = 0; center < 2 * length - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            int count = 0;

            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                if (left == right) {
                    count++;
                } else {
                    count += 2;
                }
                if (ans < count) {
                    ans = count;
                    li = left;
                    ri = right;
                }
                left--;
                right++;
            }

        }
        return s.substring(li, ri+1);
    }
}
