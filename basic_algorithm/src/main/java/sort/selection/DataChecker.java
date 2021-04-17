package sort.selection;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数器
 * @author zhangkang
 * @version 1.0
 * @date 2021/4/17
 */
public class DataChecker {

    static int[] generateRandomArray(){
        Random random = new Random();
        int[] ints = new int[10000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(10000);
        }
        return ints;
    }

    static void check(){
        int[] ints = generateRandomArray();
        int[] ints2 = new int[ints.length];
        System.arraycopy(ints, 0,ints2,0,ints.length);
        Arrays.sort(ints);
        SelectionSort.sort(ints2);
        boolean same = true;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != ints2[i]) {
                same = false;
                break;
            }
        }
        System.out.println(same ? "true" : "false");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            check();
        }
    }
}
