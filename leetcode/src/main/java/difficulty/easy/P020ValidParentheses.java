package difficulty.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/23 13:33
 */
public class P020ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(((((({{{{}}}}))))))"));
        System.out.println(isValidPro("(((((({{{{}}}}))))))"));
    }

    private static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || (map.get(c) != stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // Discuss区好的方案
    private static boolean isValidPro(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || (c != stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
