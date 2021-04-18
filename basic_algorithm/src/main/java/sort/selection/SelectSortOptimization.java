package sort.selection;

import java.util.Arrays;

/**
 * 选择排序优化： 每次遍历输出最小和最大值，遍历次数为：n/2
 * @author zhangkang
 * @version 1.0
 * @date 2021/4/17
 */
public class SelectSortOptimization {
    public static void main(String[] args) {
        int [] array = {5,3,6,8,1,7,9,4,2,23,45,12,44,0};
        sort(array);
    }

    public static void sort(int[] array) {
        for (int j = 0; j < array.length -j; j++) {
            int minPosition = j;
            int maxPosition = j;
            for (int i = j + 1; i < array.length -j ; i++) {
                if (array[minPosition] > array[i]) {
                    minPosition = i;
                }
                if (array[maxPosition] < array[i]) {
                    maxPosition = i;
                }
            }
            //System.out.println("min : " + array[minPosition]  + "  max : " + array[maxPosition] );
            int tempMin =  array[minPosition];
            int tempMax =  array[maxPosition];
            // 最大和最后一位互换, lastIndex最后一位下标
            int lastIndex = array.length -1 -j;
            boolean lastIsMin = tempMin == array[lastIndex];
            array[maxPosition] = array[lastIndex];
            array[lastIndex] = tempMax;
            // 如果最后一位是最小值，首位和最小值交换时，最小值的坐标改为，与最大值交还后的坐标位置，也就是maxPosition
            if (lastIsMin) {
                int test = array[j];
                array[j]  =  tempMin;
                array[maxPosition] = test;
            } else {
                // 第一位和最小互换
                array[minPosition] = array[j];
                array[j] = tempMin;
            }
            //System.out.println(Arrays.toString(array));
        }
    }
}
