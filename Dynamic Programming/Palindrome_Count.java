import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Palindrome_Count {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        String sub1, sub2, s = in.next();
        StringBuilder str;
        StringBuilder rev;
        /*
        str.append("asf");
        System.out.println(str);
        System.out.println(str.reverse());
        System.out.println(str);*/
        int sum = 0;
        for (int i = 1; i <= s.length(); i++) {
            sub1 = s.substring(0, i);
            for (int j = 0; j < sub1.length(); j++) {
                sub2 = sub1.substring(j);
                str= new StringBuilder(sub2);
                rev =new StringBuilder(sub2);
                rev.reverse();
                if (str.toString().equals(rev.toString())){
                    sum++;
                    //System.out.println(sub2);
                }
            }
        }
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