import java.io.*;
import java.util.*;

public class Final_voyage {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int n, w, t = in.nextInt();
        int[][] ar;
        int[] wt, val;
        while (t-- > 0) {
            n = in.nextInt();
            w = in.nextInt();
            wt = new int[n];
            val = new int[n];
            for (int i = 0; i < n; i++)
                wt[i] = in.nextInt();
            for (int i = 0; i < n; i++)
                val[i] = in.nextInt();
            ar = new int[n + 1][w + 1];
            for (int i = 1; i < ar.length; i++)
                for (int j = 1; j < ar[0].length; j++) {
                    if (j < wt[i - 1]) {
                        ar[i][j] = ar[i - 1][j];
                    } else
                        ar[i][j] = Math.max(ar[i - 1][j], ar[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            System.out.println(ar[n][w]);
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