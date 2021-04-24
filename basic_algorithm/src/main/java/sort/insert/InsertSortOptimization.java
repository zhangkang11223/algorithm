package sort.insert;


/**
 * 插入排序优化：把找要插入的数和原始数组中的元素对比，遇到比他大的数直接，让这个数右移一位，
 * 找得到第一个比他小或者相等的数，记录下该数的下标，把要插入的数放在这里
 */
public class InsertSortOptimization {
    public static void main(String[] args) {
        int[] ints = {9,6,1,3,5};
        sort(ints);
    }

    public static void sort(int[] ints) {
        for (int i = 1; i< ints.length; i++) {
            int tempRight = ints[i];
            int leftIndex = 0;
            for (int j = i-1; j >= 0; j--)  {
                if (ints[j] > tempRight) {
                    ints[j+1] = ints[j];
                    leftIndex = j;
                } else {
                    leftIndex = j +1;
                    break;
                }
            }
            ints[leftIndex] = tempRight;
        }
    }
}
