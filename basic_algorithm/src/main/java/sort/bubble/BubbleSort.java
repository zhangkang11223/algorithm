package sort.bubble;

import java.util.Arrays;

/**
 * 冒泡：从第一位开始，每次比较当前元素和它的右边的元素，按照从小到大进行交换位置，
 * 这样每次循环可以找到最大的一位，放在最末尾
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {9, 3, 1, 4, 6, 8, 7, 5, 2};

        sort(ints);
    }

    public static void sort(int[] ints) {
        //System.out.println(Arrays.toString(ints));
        for (int j = 0; j < ints.length -1; j++) {
            for (int i = 0; i <ints.length - j -1; i++) {
                if (ints[i] > ints[i+1] ) {
                    int leftInt = ints[i];
                    ints[i] = ints[i+1];
                    ints[i+1] = leftInt;
                }
            }
            System.out.println(Arrays.toString(ints));
        }
        //System.out.println(Arrays.toString(ints));
    }
}
