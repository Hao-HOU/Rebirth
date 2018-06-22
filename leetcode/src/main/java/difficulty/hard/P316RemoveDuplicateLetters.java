package difficulty.hard;

import java.util.Stack;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/22 15:36
 */
public class P316RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        for (int i : stack) {
//            System.out.println(i);
//        }
    }

    // 题意理解错误
//    private static String removeDuplicateLetters(String s) {
//        int[] lettersIndex = new int[26];
//        int count = 0;
//        int i = 0;
//        while (count < 26 && i < s.length()) {
//            int current = s.charAt(i) - 'a';
//            if (lettersIndex[current] == 0) {
//                lettersIndex[current] = 1;
//                count++;
//            }
//            i++;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j < 26; j++ ) {
//            if (lettersIndex[j] == 1) {
//                sb.append((char)('a' + j));
//            }
//        }
//
//        return sb.toString();
//    }


    private static String removeDuplicateLetters(String s) {
        int[] lettersCount = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            lettersCount[c - 'a']++;
        }

        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            lettersCount[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && lettersCount[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
