package difficulty.medium;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/1 10:08
 */
public class P647PalindromicSubstrings {
    public static void main(String[] args) {

    }

    private static int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = s.length();
        int ans = 0;

        for (int center = 0; center <= 2 * l - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < l && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }

        return ans;
    }
}
