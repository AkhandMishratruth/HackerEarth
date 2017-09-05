import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class NumberR {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String st;
        while (n-- > 0) {
            st = in.next();
            int len = st.length();
            int[] ar = new int[len];
            for (int i = 0; i < len; i++)
                ar[i] = st.charAt(i) == 'R' ? -1 : 1;
            int sum = 0, max_sum = 0, cur_l = 0, cur_r = 0, max_l = 0, max_r = 0;
            for (int i = 0; i < len; i++) {
                sum += ar[i];
                cur_r = i;
                if (sum < 0) {
                    sum = 0;
                    cur_l = i + 1;
                }
                if (max_sum < sum) {
                    max_sum = sum;
                    max_l = cur_l;
                    max_r = cur_r;
                }
            }
            //System.out.println(max_l + " " + max_r);
            int pri = 0;
            for (int i = 0; i < len; i++) {
                //System.out.println(ar[i]);
                if (i < max_l || i > max_r)
                    pri += (ar[i] == -1 ? 1 : 0);
                else {
                    pri += (ar[i] == -1 ? 0 : 1);
                }
            }
            System.out.println(pri);
        }
    }
}