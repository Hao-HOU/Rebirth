package difficulty.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/22 17:18
 */
public class P139WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        System.out.println(wordBreak(s, words));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
