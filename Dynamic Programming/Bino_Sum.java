import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Bino_Sum {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        BigInteger[] ar = new BigInteger[1001];
        BigInteger[][] a = new BigInteger[1001][];
        ar[0] = BigInteger.ONE;
        ar[1] = BigInteger.ONE;
        BigInteger sum;
        for (int i = 2; i < ar.length; i++)
            ar[i] = ar[i - 1].multiply(BigInteger.valueOf(i));
        for (int i = 1; i < 1001; i++) {
            a[i] = new BigInteger[i + 1];
            a[i][1] = BigInteger.valueOf(i);
        }
        for (int i = 2; i < 1001; i++) {
            for (int j = 2; j <= i; j++) {
                if (j == i)
                    a[i][j] = BigInteger.ONE;
                else if (j < i / 2.0)
                    a[i][j] = a[i - 1][j].add(a[i - 1][j - 1]);
                else if (j > i / 2.0)
                    a[i][j] = a[i][i - j];
                else if (j == i / 2.0)
                    a[i][j] = (ar[i].divide(ar[j])).divide(ar[i - j]);
            }
        }
        int n, r, t = in.nextInt();
        while (t-- > 0) {
            sum = BigInteger.ZERO;
            n = in.nextInt();
            r = in.nextInt();
            //System.out.println(a[n][r]);
            for (int i = 1; i <= r; i++)
                sum = sum.add(a[n][i]);
            System.out.println((sum.add(BigInteger.ONE)).mod(BigInteger.valueOf(1000000007)));
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