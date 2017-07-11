import java.math.BigInteger;
import java.util.*;

public class Samu_and_Shopping {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n, t = in.nextInt();
        int[][] price, memo;
        while (t-- > 0) {
            n = in.nextInt();
            price = new int[n][3];
            memo = new int[n][3];
            for (int i = 0; i < n; i++) {
                price[i][0] = in.nextInt();
                price[i][1] = in.nextInt();
                price[i][2] = in.nextInt();
            }
            memo[0][0] = price[0][0];
            memo[0][1] = price[0][1];
            memo[0][2] = price[0][2];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0)
                        memo[i][j] = price[i][j] + Math.min(memo[i - 1][1], memo[i - 1][2]);
                    else if (j == 1)
                        memo[i][j] = price[i][j] + Math.min(memo[i - 1][0], memo[i - 1][2]);
                    else
                        memo[i][j] = price[i][j] + Math.min(memo[i - 1][1], memo[i - 1][0]);
                }
            }
            System.out.println(Math.min(memo[n - 1][0], Math.min(memo[n - 1][1], memo[n - 1][2])));
        }
    }
}