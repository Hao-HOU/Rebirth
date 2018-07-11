package difficulty.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/6/24 14:10
 */
public class P539MinimumTimeDifference {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("01:01");
        timePoints.add("02:01");
        System.out.println(findMinDifference(timePoints));
    }

    private static int findMinDifferencePro(List<String> timePoints) {
        int DAY_MINUTES = 60 * 24;
        int[] minutes = new int[DAY_MINUTES];
        for (String time : timePoints) {
            if (minutes[getMinutesInt(time)] != 0) {
                return 0;
            }
            minutes[getMinutesInt(time)] = 1;
        }

        int min = DAY_MINUTES;
        boolean flag = true;
        int first = 0;
        int last = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < DAY_MINUTES; i++) {
            while (i < DAY_MINUTES && minutes[i] == 0) {
                i++;
            }
            if (flag) {
                first = i;
                flag = false;
            }
            if (i < DAY_MINUTES && minutes[i] != 0) {
                last = i;
            }
        }
        min = Math.min(min, (Math.min(last - first, first + DAY_MINUTES - last)));

        for (int i = 0; i < DAY_MINUTES; i++) {
            if (pre < 0) {
                while (i < DAY_MINUTES && minutes[i] == 0) {
                    i++;
                }
                pre = i;
                i++;
            }
            while (i < DAY_MINUTES && minutes[i] == 0) {
                i++;
            }
            if (i < DAY_MINUTES) {
                cur = i;
                min = Math.min(min, cur - pre);
                pre = cur;
            }
        }

        return min;
    }

    // time -> Hour:Minutes -> "23:59"
    private static int getMinutesInt(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }
    // 全部排序后，两两取差值，返回最小的，耗时严重
    // 思考！！！ 排序后两两取差值是不对的！
    private static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 60 * 24) {
            return 0;
        }
        Collections.sort(timePoints);
        String[] s = timePoints.get(0).split(":");
        int h = Integer.parseInt(s[0]) + 24;
        int min = diff(timePoints.get(timePoints.size() - 1), h + ":" + s[1]);

        // 并不需要两两取差值，只需要相邻的取差值！
//        for (int i = 0; i < timePoints.size(); i++) {
//            for (int j = i + 1; j < timePoints.size(); j++) {
//                if (diff(timePoints.get(i), timePoints.get(j)) < min) {
//                    min = diff(timePoints.get(i), timePoints.get(j));
//                }
//            }
//        }

        for (int i = 1; i < timePoints.size(); i++) {
            min = Math.min(min, diff(timePoints.get(i - 1), timePoints.get(i)));
        }

        return min;
    }

    private static int diff(String s1, String s2) {
        String[] arr1 = s1.split(":");
        String[] arr2 = s2.split(":");

        return 60 * (Integer.parseInt(arr2[0]) - Integer.parseInt(arr1[0]))
                + (Integer.parseInt(arr2[1]) - Integer.parseInt(arr1[1]));
    }
}
