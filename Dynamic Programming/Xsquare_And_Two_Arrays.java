import java.math.BigInteger;
import java.util.*;

public class Xsquare_And_Two_Arrays {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        long[] ar1, ar2, l1, l2;
        int n, q, temp, l, r;

        n = in.nextInt();
        q = in.nextInt();
        ar1 = new long[n];
        ar2 = new long[n];
        l1 = new long[n];
        l2 = new long[n];
        for (int i = 0; i < n; i++)
            ar1[i] = in.nextLong();
        for (int i = 0; i < n; i++)
            ar2[i] = in.nextLong();
        l1[0] = ar1[0];
        l2[0] = ar2[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                l1[i] = l1[i - 1] + ar1[i];
                l2[i] = l2[i - 1] + ar2[i];
            } else {
                l1[i] = l1[i - 1] + ar2[i];
                l2[i] = l2[i - 1] + ar1[i];
            }
        }
        while (q-- > 0) {
            temp = in.nextInt();
            l = in.nextInt();
            r = in.nextInt();
            if (l == 1 && temp == 1)
                System.out.println(l1[r - 1]);
            else if (l == 1 && temp == 2)
                System.out.println(l2[r - 1]);
            else {
                if(temp==1) {
                    if (l % 2 != 0)
                        System.out.println(l1[r - 1] - l1[l - 2]);
                    else
                        System.out.println(l2[r - 1] - l2[l - 2]);
                }
                else{
                    if (l % 2 != 0)
                        System.out.println(l2[r - 1] - l2[l - 2]);
                    else
                        System.out.println(l1[r - 1] - l1[l - 2]);
                }
            }
        }
    }
}