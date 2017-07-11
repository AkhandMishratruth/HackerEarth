import java.io.*;
import java.util.*;

public class Roy_and_Flower_Farm {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        dp[][] dp0 = new dp[101][10001];
        int t = in.nextInt(), N, W, va, wt;
        dp ans;
        while (t-- > 0) {
            N = in.nextInt();
            W = in.nextInt();
            ans=new dp();
            //ans.v = Long.MIN_VALUE;
            for (int i = 0; i <= N; i++)
                for (int j = 0; j <= W; j++)
                    dp0[i][j] = new dp();
            for (int i = 1; i <= N; i++) {
                va = in.nextInt();
                wt = in.nextInt();
                va = va - wt;
                for (int j = 1; j <= W; j++) {
                    if (j >= wt) {
                        if (dp0[i - 1][j - wt].v + va > dp0[i - 1][j].v) {
                            dp0[i][j].v = dp0[i - 1][j - wt].v + va;
                            dp0[i][j].lastwt = dp0[i - 1][j - wt].lastwt + wt;
                        } else if (dp0[i - 1][j - wt].v + va < dp0[i - 1][j].v) {
                            dp0[i][j].v = dp0[i - 1][j].v;
                            dp0[i][j].lastwt = dp0[i - 1][j].lastwt;
                        } else if (dp0[i - 1][j - wt].v + va == dp0[i - 1][j].v) {
                            if (dp0[i - 1][j].lastwt > dp0[i - 1][j - wt].lastwt) {
                                dp0[i][j].v = dp0[i - 1][j - wt].v + va;
                                dp0[i][j].lastwt = dp0[i - 1][j - wt].lastwt + wt;
                            } else {
                                dp0[i][j].v = dp0[i - 1][j].v;
                                dp0[i][j].lastwt = dp0[i - 1][j].lastwt;
                            }
                        }
                    }
                    else
                        dp0[i][j]=dp0[i - 1][j];

                    if (ans.v < dp0[i][j].v)
                        ans = dp0[i][j];
                }
            }
            ans.v += W;
            System.out.println(ans.lastwt + " " + ans.v);
            //System.out.println(dp0[N][W].lastwt + " " + dp0[N][W].v);
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
class dp {
    long v = 0;
    int lastwt = 0;
}