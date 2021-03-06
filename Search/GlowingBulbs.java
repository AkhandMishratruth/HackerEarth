import java.util.*;
import java.io.*;

public class GlowingBulbs {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-->0){
            String st = in.next();
            LinkedList<Integer> lis = new LinkedList<Integer>();
            for(int i =0;i<st.length();i++)
                if(st.charAt(i)=='1')
                    lis.add(i+1);
            pr.println(binary(lis, in.nextLong()));
        }
        pr.flush();
        pr.close();
    }

    static long lessThandivisibleByAtleast(long x, LinkedList<Integer> lis){
        int lisSize = lis.size();
        long res=0;
        for(int i =1;i<Math.pow(2,lisSize);i++){
            long prod = 1, bitCount=0;
            for(int j=0;j<lisSize;j++){
                if(((i>>j)&1)==1) {
                    prod *= lis.get(j);
                    bitCount++;
                }
            }
            if(bitCount%2==1)
                res+=x/prod;
            else
                res-=x/prod;
        }
        return res;
    }

    static long binary(LinkedList<Integer> lis, long k){
        long l=0, r = 100000000000000000l, mid, res=0;
        //System.out.println("s");
        while (l<=r){
            mid = (l+r)/2;
            if(lessThandivisibleByAtleast(mid, lis)<k)
                l = mid+1;
            else {
                r = mid-1;
                res = mid;
            }
        }
        return res;
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