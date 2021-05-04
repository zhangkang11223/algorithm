package sort.merge;

import java.util.Arrays;

/**
 * Java内部，Python内部都使用的归并排序
 * 排序思想：先将一个数组分为2个等长的数组，判断2个子数组中的数据是否有序。
 * 如果是无序的，则再将该数组进行分割，判断2个子数组中的数据是否有序
 * 当所有的子数组都是有序的后，从最底层的子数组开始，进行合并
 *
 * 合并规则：准备一个新的与2个子数组长度之和相等的数组
 * 比较2个已经拍好序的子数组的首位，找到较小的，放入新数组首位，该子数组的下标向后移动一位
 * 再次比较2个子数组的下标，找到较小的，放入新数组的第二位。依次类推...
 * 如果发现某子个数组的所有元素都放入了新数组，则把另一个数据剩余的元素一次性的放入新数组
 */
public class StandardMergeSort {
    public static void main(String[] args) {
        int [] array2 = {0,3,6,8,11,15,1,7};
        sort(array2, 0, array2.length-1);
        System.out.println(Arrays.toString(array2));
    }

    public static void sort(int[] array, int leftBound, int rightBound) {

        if (leftBound == rightBound) { // base case
            return;
        }
        // 分组
        int mid = leftBound + (rightBound - leftBound)/2;
        // 左排序
        sort(array, leftBound, mid);
        // 右排序
        sort(array, mid + 1, rightBound);
        // 归并
        merger(array, leftBound, mid +1, rightBound);
    }

    /**
     * 归并
     * @param array 待排序的数组
     * @param leftIndex 待排序数组的左下标
     * @param rightIndex 待排序数组的右下标
     * @param rightBound 右边界
     */
    private static void merger(int[] array, int leftIndex, int rightIndex, int rightBound) {
        // firstIndex 这个值用来temp数组拷贝使用
        int firstIndex = leftIndex;
        int[] temp = new int[rightBound - leftIndex + 1];
        int tempIndex = 0;
        int endLeft = rightIndex -1;
        while( leftIndex <= endLeft &&  rightIndex<= rightBound) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[tempIndex] = array[leftIndex];
                //System.out.println(tempIndex +"==="+temp[tempIndex]);
                leftIndex ++;
            } else {
                temp[tempIndex] = array[rightIndex];
                //System.out.println(tempIndex +"==="+temp[tempIndex]);
                rightIndex++;
            }
            tempIndex++;
        }

        while(leftIndex <= endLeft) {
            temp[tempIndex++] = array[leftIndex++];
        }
        while(rightIndex <= rightBound) {
            temp[tempIndex++] = array[rightIndex++];
        }
        for (int i = 0 ;i< temp.length; i++) {
            array[firstIndex + i] = temp[i];
        }
    }
}
