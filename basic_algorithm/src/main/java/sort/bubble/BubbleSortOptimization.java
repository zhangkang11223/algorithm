package sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序优化1 : 添加外层循环标志位，如果进行了位置交换，则继续下次外循环。
 * 如果本次内循环没有位置交换，说明已经排序成功直接return, 最好时间复杂度为O(n)
 * 冒泡排序优化2 : 添加内层循环标志位，记录本次内循环中最后一次交换数据的位置，后面的数据都是排好序的，
 * 下次内循环的末尾就是本地标志位的地方
 */
public class BubbleSortOptimization {
    public static void main(String[] args) {

        int[] test = {1, 2, 3, 4, 5};
        // 普通的冒泡排序进行了4次
        BubbleSort.sort(test);
        System.out.println("================================");
        // 优化1冒泡排序
        BubbleSortOptimization.sort(test);
        System.out.println("================================");
        // 优化2冒泡排序
        BubbleSortOptimization.sortBestTimeComplexity(test);

    }

    public static void sortBestTimeComplexity(int[] test) {
        int end = test.length - 1;
        for (int i = test.length - 1; i > 0; i--) {
            boolean isChange = false;
            int tempPosition = 0;
            for (int j = 0; j < end; j++) {
                if (test[j] > test[j + 1]) {
                    int temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                    isChange = true;
                    tempPosition = j; //记录本次循环中最后一次交换数据的位置
                }
            }
            end = tempPosition;
            System.out.println(Arrays.toString(test));
            if (!isChange) {
                return;
            }
        }
    }

    public static void sort(int[] test) {
        for (int i = test.length - 1; i > 0; i--) {
            boolean isChange = false;
            for (int j = 0; j < i; j++) {
                if (test[j] > test[j + 1]) {
                    int temp = test[j];
                    test[j] = test[j + 1];
                    test[j + 1] = temp;
                    isChange = true;
                }
            }
            System.out.println(Arrays.toString(test));
            if (!isChange) {
                return;
            }
        }
    }
}
