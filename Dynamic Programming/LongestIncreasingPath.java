import java.io.*;
import java.util.*;

public class LongestIncreasingPath {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        PrintWriter p = new PrintWriter(System.out);
        int t = in.nextInt(), n, m;
        int[][] ar, dp;
        while (t-->0){
            n = in.nextInt();
            m = in.nextInt();
            ar = new int[n][m];
            dp = new int[n][m];
            for(int i=0;i<n;i++)
                for(int j=0;j<m;j++) {
                    ar[i][j] = in.nextInt();
                }
            dp[0][0]=1;
            int max=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i<n-1 && ar[i][j]<ar[i+1][j] && dp[i][j]!=0)
                        dp[i+1][j]=Math.max(dp[i+1][j], 1 + dp[i][j]);
                    if(j<m-1 && ar[i][j]<ar[i][j+1] && dp[i][j]!=0)
                        dp[i][j+1]=Math.max(dp[i][j+1], 1 + dp[i][j]);
                    max = Math.max(max,dp[i][j]);
                    //System.out.print(dp[i][j]+" ");
                }
                //System.out.println();
            }
            p.println(max);
        }
        p.flush();
        p.close();
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