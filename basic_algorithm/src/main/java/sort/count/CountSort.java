package sort.count;

import java.util.Arrays;

/**
 * 计数排序
 * 特点：对结果为固定范围的数据排序，例如：对一个公司的员工的年龄排序
 * 排序思想：针对结果集范围，创建一个数组k，长度为结果集范围。遍历待排序数组，把元素放入k中，
 * 创建一个与待排序数组等长的数组newArray，遍历k数组，把元素加入到newArray中
 *
 * 优化计数排序：稳定
 * 排序思想：针对结果集范围，创建一个数组k，长度为结果集范围。遍历待排序数组，把元素放入k中，
 * 创建一个累加数组m，存放每一位元素最后的位置，长度和k数组等长。
 * 倒序遍历原数组，查询遍历元素在m数组中的位置，放到k对应的位置，然后m数组的对应值-1
 * 因为每次放入都是最后一位元素，所以这个排序是稳定的
 */
public class CountSort {

    public static void main(String[] args) {

        int[] a = new int[]{8,2,3,5,5,2,1,0,7,8,3,9,1,9,0,6};
        sortOptimization(a);

    }

    /**
     * 自定义计数排序，不稳定
     */
    public static void sort(int[] array) {
        // 已知待排序数组的结果集的范围0~9
        int[] k =  new int[10];
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            k[value]++;
        }
        System.out.println(Arrays.toString(k));
        // 这里可以直接在for循环中定义i 和 j
        for (int i = 0, j =0; i < k.length ; i++) {
            while (k[i]-- > 0) {
                newArray[j++] = i;
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    /**
     * 优化计数排序：稳定
     */
    public static void sortOptimization(int[] array) {
        // 已知待排序数组的结果集的范围0~9
        int[] k = new int[10];
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            k[value]++;
        }
        System.out.println(Arrays.toString(k));
        for (int j = 1; j < k.length ; j++) {
            k[j] = k[j] + k[j-1];
        }
        System.out.println(Arrays.toString(k));
        for (int q = array.length -1; q >= 0 ; q--) {
            //newArray[k[array[q]]-- - 1] = array[q];     // k[array[q]]-- - 1  可以优化为： --k[array[q]]
            newArray[--k[array[q]]] = array[q];
        }
        System.out.println(Arrays.toString(newArray));
    }
}
