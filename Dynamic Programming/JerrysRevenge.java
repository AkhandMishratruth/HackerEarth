import java.util.*;
import java.io.*;

public class  JerrysRevenge {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt(), m = in.nextInt();
        int[][] ar = new int[n][m];
        int[][] br = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                ar[i][j] = in.nextInt();
                br[i][j] = (ar[i][j] == 0 ? 1 : 0);
            }
        int[][] dp = new int[n][m];
        int[][] dp1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = ar[i][j];
                dp1[i][j] = br[i][j];
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                    dp1[i][j] += dp1[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                    dp1[i][j] += dp1[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] -= dp[i - 1][j - 1];
                    dp1[i][j] -= dp1[i - 1][j - 1];
                }
            }
        }
        int max = 0, m1, m2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int l=0;i+l<n && j+l<m;l++){
                    m1 = dp[i+l][j+l];
                    if(i>0)
                        m1-=dp[i-1][j+l];
                    if(j>0)
                        m1-=dp[i+l][j-1];
                    if(i>0 && j>0)
                        m1+=dp[i-1][j-1];
                    m1 = dp[n-1][m-1]-m1;
                    m2 = dp1[i+l][j+l];
                    if(i>0)
                        m2-=dp1[i-1][j+l];
                    if(j>0)
                        m2-=dp1[i+l][j-1];
                    if(i>0 && j>0)
                        m2+=dp1[i-1][j-1];
                    max  = Math.max(max,m2+m1);
                }
            }
        }
        p.println(max);
        p.flush();
        p.close();
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}