package difficulty.easy;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/23 13:09
 */
public class P009PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    //还有可以改进的地方
    //这个比较了全部的数字，其实可以只比较一般
    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int initial = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }

        return reverse == initial;
    }

    //比较数字的一半
    private static boolean isPalindromePro(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + (x % 10);
            x /= 10;
        }

        return x == reverseNum || x == (reverseNum / 10);
    }
}
