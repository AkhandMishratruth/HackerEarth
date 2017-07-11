import java.util.*;
import java.io.*;

public class Tablets {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        long sum = 0;
        int j, n = in.nextInt();
        long[] ar;
        long[] dp;
        ar = new long[n];
        dp = new long[n];
        for (int i = 0; i < n; i++)
            ar[i] = in.nextLong();
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (ar[i] > ar[i - 1] && dp[i] <= dp[i - 1])
                dp[i] = dp[i - 1] + 1;
            else {
                j = i - 1;
                while (j >= 0 && ar[j] > ar[j + 1] && dp[j] <= dp[j + 1]) {
                    dp[j] = dp[j + 1] + 1;
                    j--;
                }
            }
        }

        for (int i = 0; i < n; i++)
            sum += dp[i];
        dp=null;
        ar=null;
        System.out.println(sum);
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