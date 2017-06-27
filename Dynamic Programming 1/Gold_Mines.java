import java.io.*;
import java.util.*;

public class Gold_Mines {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int r = in.nextInt(), c = in.nextInt();
        long[][] ar = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ar[i][j] = in.nextLong();
                if (i > 0)
                    ar[i][j] += ar[i - 1][j];
                if (j > 0)
                    ar[i][j] += ar[i][j - 1];
                if (i > 0 && j > 0)
                    ar[i][j] -= ar[i - 1][j - 1];
            }
        }
        int x1, x2, y1, y2, q = in.nextInt();
        while (q-- > 0) {
            x1 = in.nextInt() - 1;
            y1 = in.nextInt() - 1;
            x2 = in.nextInt() - 1;
            y2 = in.nextInt() - 1;
            if (x1 == 0 && y1 == 0)
                System.out.println(ar[x2][y2]);
            else if (x1 == 0)
                System.out.println(ar[x2][y2] - ar[x2][y1 - 1]);
            else if (y1 == 0)
                System.out.println(ar[x2][y2] - ar[x1 - 1][y2]);
            else
                System.out.println(ar[x2][y2] + ar[x1 - 1][y1 - 1] - ar[x1 - 1][y2] - ar[x2][y1 - 1]);
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