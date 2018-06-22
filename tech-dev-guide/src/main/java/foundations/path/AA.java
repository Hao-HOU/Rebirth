package foundations.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/22 17:34
 */
public class AA {
    public static void main(String[] args) {
//        System.out.println(isSubsequence("abppplee", "abppplee"));
        String s = "abppplee";
        List<String> words = new ArrayList<>();
        words.add("able");
        words.add("ale");
        words.add("apple");
        words.add("bale");
        words.add("kangaroo");

        System.out.println(findLongestWordInString(s, words));
    }

    private static Comparator lengthComparator =
            (o1, o2) -> (Integer.compare(((String) o1).length(), ((String) o2).length()));

    private static String findLongestWordInString(String s, List<String> words) {
        words.sort(lengthComparator);

        Collections.reverse(words);

        for (String word : words) {
            if (isSubsequence(s, word)) {
                return word;
            }
        }

        return "无符合条件的单词";
    }

    private static boolean isSubsequence(String s, String word) {
        if (s.length() < word.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == word.length();
    }
}
