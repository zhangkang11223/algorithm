package sort.quick;

import java.util.Arrays;

/**
 * 单轴快排：选取待排序数组的最后一位元素作为轴。以轴为中点，对当前数组进行分区，
 *         保证轴左边都是比他小的数据，轴的右边都是比他大的数。然后再分别对左右子数组进行递归排序。
 * 分组方法：从左往右找到第一个比中轴大的元素，从右往左找到第一个比中轴小/相等的元素，交换这2个元素
 *         最后交换轴与右边分组的第一个元素。
 * 双轴快排：选择2个数组作为轴，保证左边的轴小于右边。对待排序的数据进行划分。
 *         分为3个部分：小于第一个轴，2个轴  之间，3大于第二个轴。
 */
public class QuickSort {
    public static void main(String[] args) {
        //            0  1  2  3  4  5  6  7  8
        int[] ints = {7, 3, 2, 10, 8, 1, 9, 5, 4, 6};
        sort(ints, 0 , ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public static void sort(int[] array, int leftBound, int rightBound) {
        if (rightBound <= leftBound) {
            return;
        }
        int mid = partition(array, leftBound, rightBound);
        // System.out.println(mid);
        // 左排序
        //System.out.println("leftBound = " + leftBound + "  mid -1 = " + (mid -1) );
        sort(array, leftBound, mid -1);
        // 右排序
        // System.out.println("aaaa" + Arrays.toString(array));
        // System.out.println("rightBound = " + rightBound + "  mid +1 = " + (mid +1) );
        sort(array, mid + 1, rightBound);
    }


    public static int partition(int[] array, int leftBound, int rightBound) {
        int leftIndex = leftBound;
        int rightIndex = rightBound -1;
        int pivot = array[rightBound];
        while(leftIndex <= rightIndex) {
            while (leftIndex <= rightIndex &&  array[leftIndex] <= pivot) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex &&  array[rightIndex] > pivot) {
                rightIndex--;
            }
            // 交换左右指针
            if (leftIndex < rightIndex) {
                //System.out.print("左 = " + array[leftIndex] + " 右 = " + array[rightIndex]);
                int rightTemp = array[rightIndex];
                array[rightIndex] = array[leftIndex];
                array[leftIndex] = rightTemp;
                //System.out.println(Arrays.toString(array));
            }
        }
        //中轴交换
        int firstRight = array[leftIndex];
        array[leftIndex] = pivot;
        array[rightBound] = firstRight;
        //System.out.println(Arrays.toString(array));
        return leftIndex;
    }
}