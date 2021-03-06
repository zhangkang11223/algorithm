package recursion;

/**
 * 递归累加
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
