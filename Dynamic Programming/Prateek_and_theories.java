import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Prateek_and_theories {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int l, j, n, t = in.nextInt();
        long guest_in, max;
        long[] out, inn;
        while (t-- > 0) {
            n = in.nextInt();
            inn = new long[n];
            out = new long[n];
            for (int i = 0; i < n; i++) {
                inn[i] = in.nextLong();
                out[i] = in.nextLong()-1;
            }
            Arrays.sort(inn);
            Arrays.sort(out);
            l = 1;
            j = 0;
            guest_in = 1l;
            max = 1l;
            while (l < n && j < n) {
                if (inn[l] <= out[j]) {
                    guest_in++;
                    l++;
                    if (max < guest_in)
                        max = guest_in;
                } else {
                    guest_in--;
                    j++;
                }
            }
            System.out.println(max);
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