import java.io.*;
import java.util.*;

public class Monk_at_the_Graph_Factory {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int n = in.nextInt(), e = in.nextInt();
        for(int i=1;i<n;i++){
            e+=in.nextInt()-1;
        }
        if(e==n-1)
            System.out.println("Yes");
        else
            System.out.println("No");
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