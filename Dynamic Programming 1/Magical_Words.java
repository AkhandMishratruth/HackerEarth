import java.io.*;
import java.util.*;

public class Magical_Words {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        String s;
        long[][] dp;
        int t = in.nextInt(), j;
        char[] str;
        long sum;
        while (t-- > 0) {
            s = in.next();
            str = s.toCharArray();
            sum = 0l;
            dp = new long[str.length][str.length];
            for (int i = 0; i < str.length; i++)
                dp[i][i] = 1;

            for (int gap = 2; gap < str.length + 1; gap++) {
                for (int i = 0; i < str.length - gap + 1; i++) {
                    j = i + gap - 1;
                    if (str[i] == str[j] && gap == 2)
                        dp[i][j] = 2;
                    else if (str[i] == str[j] && dp[i + 1][j - 1] != 0)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                }
            }
            for (int i = 0; i < dp.length; i++)
                for (j = 0; j < dp[0].length; j++)
                    sum += dp[i][j] * dp[i][j];
            System.out.println(sum);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}