import java.math.BigInteger;
import java.util.*;

public class Xsquare_And_Coin_Collection {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int j, n, k, t = in.nextInt();
        long max;
        long[] ar, sta;
        while (t-- > 0) {
            max = -1l;
            j = -1;
            n = in.nextInt();
            k = in.nextInt();
            ar = new long[n];
            Arrays.fill(ar, -1l);
            sta = new long[n];
            for (int i = 0; i < n; i++)
                sta[i] = in.nextInt();
            for (int i = 0; i < n; i++) {
                if (sta[i] <= k) {
                    if (j == i - 1 && j != -1)
                        ar[i] = ar[i - 1] + sta[i];
                    else
                        ar[i] = sta[i];
                    j = i;
                }
            }
            for (int i = 0; i < ar.length; i++)
                if (max < ar[i])
                    max = ar[i];
            System.out.println(max);
        }
    }
}