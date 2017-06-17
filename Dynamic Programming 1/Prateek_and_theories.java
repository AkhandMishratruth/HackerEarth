import java.math.BigInteger;
import java.util.*;

public class Prateek_and_theories {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, t = in.nextInt();
        long max;
        Theo[] ar;
        Theo[] set;
        while (t-- > 0) {
            max = Long.MIN_VALUE;
            n = in.nextInt();
            ar = new Theo[n];
            set = new Theo[n];
            for (int i = 0; i < n; i++)
                ar[i] = new Theo(in.nextLong(), in.nextLong());
            Arrays.sort(ar);
            for (int i = 0; i < ar.length; i++) {
                set[i] = new Theo(ar[i].t1, ar[i].t2);
                set[i].temp = 1;
            }
            for (int i = 1; i < set.length; i++)
                for (int j = 0; j < i; j++)
                    if ((set[j].t1 <= ar[i].t1 && ar[i].t1 <=set[j].t2) || (set[j].t2 >= ar[i].t2 && ar[i].t2 >= set[j].t1)) {
                        set[i].temp = Math.max(set[j].temp + 1, set[i].temp);
                        set[i].t1 = Math.max(ar[i].t1, set[j].t1);
                        set[i].t2 = Math.min(ar[i].t2, set[j].t2);
                    }

            for (int i = 0; i < set.length; i++)
                if (max < set[i].temp)
                    max = set[i].temp;
            System.out.println(max);
        }
    }
}
class Theo implements Comparable<Theo> {
    long t1, t2;
    long temp;

    Theo(long r1, long h1) {
        t1 = r1;
        t2 = h1-1;
    }

    @Override
    public int compareTo(Theo o) {
        return Long.compare(this.t1, o.t1);
    }
}