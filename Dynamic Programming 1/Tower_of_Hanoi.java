import java.math.BigInteger;
import java.util.*;

public class Tower_of_Hanoi {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, t = in.nextInt();
        long max;
        Tower[] ar;
        long[] set;
        while (t-- > 0) {
            max = Long.MIN_VALUE;
            n = in.nextInt();
            ar = new Tower[n];
            set = new long[n];
            for (int i = 0; i < n; i++)
                ar[i] = new Tower(in.nextLong(), in.nextLong());
            Arrays.sort(ar);
            for (int i = 0; i < ar.length; i++)
                set[i] = ar[i].h;
            for (int i = 1; i < set.length; i++)
                for (int j = 0; j < i; j++)
                    if (ar[j].h < ar[i].h && set[i] < set[j] + ar[i].h && ar[j].r < ar[i].r)
                        set[i] = set[j] + ar[i].h;

            for (int i = 0; i < set.length; i++)
                if (max < set[i])
                    max = set[i];
            System.out.println(max);
        }
    }
}
class Tower implements Comparable<Tower> {
    long r, h;

    Tower(long r1, long h1) {
        r = r1;
        h = h1;
    }

    @Override
    public int compareTo(Tower o) {
        return Long.compare(this.r, o.r);
    }
}