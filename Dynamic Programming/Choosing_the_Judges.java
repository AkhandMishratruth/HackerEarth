import java.math.BigInteger;
import java.util.*;

public class Choosing_the_Judges {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        long[] ar, score;
        int n, t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            n = in.nextInt();
            ar = new long[n];
            score = new long[n];
            for (int j = 0; j < n; j++)
                ar[j] = in.nextLong();
            score[0] = ar[0];
            if (score.length > 1) {
                score[1] = Math.max(ar[0], ar[1]);
                for (int j = 2; j < score.length; j++)
                    score[j] = Math.max(score[j - 1], score[j - 2] + ar[j]);
                System.out.printf("Case %d: %d\n", i, score[score.length - 1]);
            } else
                System.out.println("Case " + i + ": " + score[0]);
        }

    }
}