import java.util.*;
import java.io.*;

public class Roy_and_Ropes {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int max, n, t = in.nextInt();
        int[] l;
        int[] u;
        while (t-- > 0) {
            max = 0;
            n = in.nextInt();
            l = new int[n - 1];
            u = new int[n - 1];
            for (int i = 0; i < l.length; i++)
                l[i] = in.nextInt();
            for (int i = 0; i < u.length; i++)
                u[i] = in.nextInt();
            for (int i = 0; i < l.length; i++) {
                max = Math.max(Math.max(max, i + 2), i + 1 + Math.max(l[i], u[i]));
            }
            System.out.println(max);
        }
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}