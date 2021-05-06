package sort.checker;

import sort.bubble.BubbleSort;
import sort.insert.InsertSort;
import sort.insert.InsertSortOptimization;
import sort.merge.StandardMergeSort;
import sort.quick.QuickSort;
import sort.selection.SelectionSort;
import sort.shell.ShellSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数器
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
        QuickSort.sort(ints2, 0 ,ints2.length -1);
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
