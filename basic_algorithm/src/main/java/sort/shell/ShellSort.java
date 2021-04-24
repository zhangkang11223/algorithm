package sort.shell;

import java.util.Arrays;

/**
 *  外层循环：从gap位置（跳过第一个gap的长度）开始，挨着依次往后循环
 *  内层循环：当前值，和距离它一个gap之前的元素比较，每次向前一个gap的距离
 */
public class ShellSort {
    public static void main(String[] args) {
        int [] ints = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        sort(ints);
    }

    public static void sort(int[] ints) {
        int h = 1;
        while (h <= ints.length /3) {
            h = 3* h +1;
        }
        for (int gap = h ; gap > 0 ; gap /= 2 ) {  // int做完除法的结果会省略小数部分
            for (int i = gap; i< ints.length; i++) {
                int tempRight = ints[i];
                int leftIndex = 0;
                for (int j = i-gap; j >= 0; j -= gap)  {
                    if (ints[j] > tempRight) {
                        ints[j+gap] = ints[j];
                        leftIndex = j;
                    } else {
                        leftIndex = j +gap;
                        break;
                    }
                }
                ints[leftIndex] = tempRight;
            }
            //System.out.println(Arrays.toString(ints));
        }
    }
}
