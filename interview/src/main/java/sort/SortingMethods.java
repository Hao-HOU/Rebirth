package sort;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/7/3 21:04
 */
public class SortingMethods {
    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 8, 1, 9, 3, 6, 7, 10, 15, 12};
        System.out.println("选择排序：");
        printSortedNums(selectionSort(nums));

        System.out.println("\n插入排序：");
        printSortedNums(insertionSort(nums));

        System.out.println("\n希尔排序：");
        printSortedNums(shellSort(nums));

        System.out.println("\n归并排序(自顶向下)：");
        printSortedNums(mergeSort(nums));
        System.out.println("\n归并排序(自底向上)：");
        printSortedNums(mergerSortBU(nums));

        System.out.println("\n快速排序：");
        printSortedNums(quickSort(nums));
    }


    private static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }

        return nums;
    }

    private static int[] insertionSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int tmp = nums[i];
            int j = i;
            while (j > 0 && tmp < nums[j - 1]) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = tmp;
        }

        return nums;
    }

    private static int[] shellSort(int[] nums) {
        int length = nums.length;
        int h = 1;//增量因子
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    int tmp = nums[j];
                    nums[j] = nums[j - h];
                    nums[j - h] = tmp;
                }
            }

            h /= 3;
        }

        return nums;
    }

    private static int[] aux = null;

    private static int[] mergerSortBU(int[] nums) {
        int l = nums.length;
        aux = new int[l];
        for (int sz = 1; sz < l; sz = sz + sz) {
            for (int lo = 0; lo < l - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, l - 1));
            }
        }

        return nums;
    }

    private static int[] mergeSort(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }


    private static void mergeSort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);//对左半边排序
        mergeSort(nums, mid + 1, hi);//对右半边排序
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, lo, mid, hi);//归并结果
        }
    }

    private static void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        //将a[lo...hi]复制到aux[lo...hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > hi) {
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    private static int[] quickSort(int[] nums) {

        //此处可以打乱 nums

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;//左扫描指针
        int j = hi + 1;//右扫描指针
        int v = nums[lo];//切分元素

        int tmp = 0;

        while (true) {
            while (nums[++i] < v) {
                if (i == hi) {
                    break;
                }
            }

            while (v < nums[--j]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;

        return j;

    }

    private static void printSortedNums(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
