package sort.insert;

import java.util.Arrays;

/**
 * 插入排序：从下标=1开始，把找要插入的数和原始数组中的元素对比，遇到比他大的数，交换2个元素的位置，
 * 直到遍历结束，再进行下一个数的插入
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = {9,6,1,3,5};
        System.out.println(Arrays.toString(ints));
        sort(ints);
    }

    public static void sort(int[] ints) {
        for (int i = 1; i< ints.length; i++) {
            // System.out.println(compareInt);
            for (int j = i-1; j >= 0; j--)  {
                if (ints[j] > ints[j+1]) {
                    int tempRight = ints[j+1];
                    ints[j+1] = ints[j];
                    ints[j] = tempRight;
                }
            }
           // System.out.println(Arrays.toString(ints));
        }
    }
}
