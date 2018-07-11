package str;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/11 16:07
 */
public class KMP {
    public static void main(String[] args) {
        String pat = "ABABAC";
        String txt = "BCBAABACAABABACAA";


        System.out.println("   text: " + txt);
        int offset = getIndexOfSubString(txt, pat);
        System.out.print("pattern: ");
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        System.out.println(pat);
    }

    public static int getIndexOfSubString(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }

        int si = 0;
        int mi = 0;
        int[] next = getNextArray(m);
        while (si < s.length() && mi < m.length()) {
            if (s.charAt(si) == m.charAt(mi)) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }

        return mi == m.length() ? (si - mi) : -1;
    }

    private static int[] getNextArray(String ms) {
        if (ms.length() == 1) {
            return new int[] {-1};
        }

        int[] next = new int[ms.length()];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms.charAt(pos - 1) == ms.charAt(cn)) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }

        return next;
    }
}
