import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created by vivek.vanga on 21/04/16.
 */
public class atoi {

    // assuming str is a valid integer. Otherwise the behavior will be unspecified.
    int run(String str) {
        int multiple = 1;
        str = str.trim();
        if(str.startsWith("+")) {
            str = str.substring(1);
        } else if(str.startsWith("-")) {
            str = str.substring(1);
            multiple = -1;
        }

        int i = 0;
        for(int iterator = 0; iterator < str.length() && str.substring(iterator,iterator+1).matches("[0-9]") ; iterator++) {
            try {
                i = Math.addExact(Math.multiplyExact(i,10),chartoi(str.charAt(iterator)));
            } catch (ArithmeticException e) {
                System.out.println("over flow");
                if(multiple >= 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return i * multiple;
    }

    int chartoi(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        atoi a = new atoi();
        System.out.println(a.run("123"));
        System.out.println(a.run("  -0012a42"));
        System.out.println(a.run("122345"));
        System.out.println(a.run("2147483648"));
        System.out.println("tests passed");
    }
}
