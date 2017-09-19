import java.util.*;
import java.io.*;

public class  NextLuckyNumber {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-->0){
            String st = in.next();
            char[] prin = luck(st);
            for(int i=0;i<prin.length;i++)
                p.print(prin[i]);
            p.println();
        }
        ArrayList<Integer> a = new ArrayList<Integer>();

        p.flush();
        p.close();
    }
    static char[] luck(String st){
        int n = st.length();
        char[] val = {'3','3','3','5','5','5','3','3','3','3'};
        char[] toRet = new char[n];
        for(int i=n-1;i>=0;i--) {
            if(st.charAt(i)!='5' && st.charAt(i)!='3'){
                toRet[i]=val[Integer.parseInt(String.valueOf(st.charAt(i)))];
            }
            else if (Character.compare(st.charAt(i), '3') == 0) {
                if (i < n - 1) {
                    if (Character.compare(st.charAt(i + 1), '5') < 0) {
                        toRet[i] = '3';
                    } else if (Character.compare(st.charAt(i + 1), '5') == 0) {
                        if (toRet[i + 1] == '3')
                            toRet[i] = '5';
                        else
                            toRet[i] = '3';
                    } else {
                        toRet[i] = '5';
                    }
                } else {
                    toRet[i] = '5';
                }
            } else if (Character.compare(st.charAt(i), '5') == 0) {
                if (i < n - 1) {
                    if (Character.compare(st.charAt(i + 1), '5') < 0) {
                        toRet[i] = '5';
                    } else if (Character.compare(st.charAt(i + 1), '5') == 0) {
                        if (toRet[i + 1] == '3')
                            toRet[i] = '3';
                        else
                            toRet[i] = '5';
                    } else {
                        toRet[i] = '3';
                    }
                } else {
                    toRet[i] = '3';
                }
            }
        }
//        for(char i:toRet)
//        System.out.print(i);
//        System.out.println();
        if(Character.compare(st.charAt(0),'5')<0)
            return toRet;
        else if(n!=1 && Character.compare(st.charAt(0),'5')==0 && Character.compare(st.charAt(1),toRet[1])<=0)
            return toRet;
        toRet = new char[n+1];
        Arrays.fill(toRet,'3');
        return toRet;
    }
    static boolean isPrime(int n){
        if(n<=1)
            return false;
        if(n<=3)
            return true;
        if(n%2 ==0 || n%3==0)
            return false;
        for(int i=5;i*i<n;i+=6)
            if(n%i==0 || n%(i+2)==0)
                return false;
        return true;
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