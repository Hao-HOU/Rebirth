package algs4;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/10 20:55
 */
public class KMP {
    public static void main(String[] args) {
        String pat = "ABABAC";
        String txt = "BCBAABACAABABACAA";

        KMP kmp = new KMP(pat);
        System.out.println("   text: " + txt);
        int offset = kmp.search(txt);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pat);

    }

    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        // 由模式字符串构造DFA
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            // 计算dfa[][j]
            for (int c = 0; c < R; c++) {
                // 赋值匹配失败情况下的值
                dfa[c][j] = dfa[c][X];
            }
            // 设置匹配成功情况下的值
            dfa[pat.charAt(j)][j] = j + 1;
            // 更新重启状态
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        // 在txt上模拟DFA的运行
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) {
            return i - M;
        } else {
            return N;
        }
    }
}
