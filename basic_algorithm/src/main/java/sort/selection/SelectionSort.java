package sort.selection;

/**
 * 每次找得到数组中的最小值，与首位互换
 * 5,3,6,8,1,7,9,4,2
 * 第0次  1,3,6,8,5,7,9,4,2  minPosition 4
 * 第1次  1 2 6 8 5 7 9 4 3  minPosition 8
 * 第2次  1 2 3 8 5 7 9 4 6  minPosition 8
 * 第3次  1 2 3 4 5 7 9 8 6  minPosition 7
 * 第4次  1 2 3 4 5 7 9 8 6  minPosition 4
 * 第5次  1 2 3 4 5 6 9 8 7  minPosition 8
 * 第6次  1 2 3 4 5 6 7 8 9  minPosition 8
 * 第7次  1 2 3 4 5 6 7 8 9  minPosition 7
 * 第8次  1 2 3 4 5 6 7 8 9  minPosition 8
 */
public class SelectionSort {

    public static void main(String[] args) {
        int [] array = {5,3,6,8,1,7,9,4,2};
        sort(array);
    }

    static void sort(int[] array) {
        // 最后一次不用循环
        for (int j = 0; j <array.length -1 ; j++) {
            // 找到最小值
            int minPosition = j;
            // 从循环的下一位开始比较
            for (int i = j + 1; i < array.length; i++) {
                if (array[minPosition] > array[i]) {
                    minPosition = i;
                }
            }
            int temp = array[j];
            array[j] = array[minPosition];
            array[minPosition] =temp;
            //System.out.println("第"+(j+1)+"次排序，最小值位置: " + minPosition +",排序后为：" + Arrays.toString(array));
        }
    }
}
