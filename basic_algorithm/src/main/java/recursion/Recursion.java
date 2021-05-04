package recursion;

/**
 * @author zhangkang
 * @version 1.0
 * @date 2021/4/29
 */
public class Recursion {

    public static void main(String[] args) {
        int accumulate = Recursion.accumulate(10);
        System.out.println(" = " + accumulate);
    }

    public static int accumulate(int number) {
        if (1 == number) {
            System.out.print("1");
            return 1;
        }
        System.out.print(number+ " + ");
        return number + accumulate(number - 1);
    }
}
