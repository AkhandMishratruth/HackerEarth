import java.math.BigInteger;
import java.util.*;

public class win_the_game {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        double[] ar;
        int r, g;
        int t = in.nextInt();
        while (t-- > 0) {
            r = in.nextInt();
            g = in.nextInt();
            if (g == 0 || r == 0) {
                System.out.println("1.000000");
            }
            else if (g == 1)
                System.out.printf("%.6f\n", r * 1.0 / (r + g));
            else {
                ar = new double[g + 1];
                ar[0] = 1.0;
                ar[1] = r * 1.0 / (r + 1);
                for (int i = 2; i < ar.length; i++) {
                    ar[i] = r * 1.0 / (r + i) + 1.0 * ar[i - 2] * (i * i - i) / ((r + i) * (r + i - 1));
                }
                System.out.printf("%.6f\n", ar[g]);
            }
        }
    }
}