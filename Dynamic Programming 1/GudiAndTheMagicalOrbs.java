import java.io.*;
import java.util.*;

public class GudiAndTheMagicalOrbs {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int[][] ar;
        int[][][] dp;
        int t = in.nextInt(), r, c, orb;
        while(t-->0){
            r=in.nextInt();c=in.nextInt();orb=in.nextInt();
            ar=new int[r][c];
            dp= new int[r][c][orb+1];
            int ans;
            for(int i=0;i<ar.length;i++)
                for(int j=0;j<ar[0].length;j++)
                    ar[i][j]=in.nextInt();

            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    for(int k=1;k<dp[0][0].length;k++){
                        if(i==0 && j==0 && k>=ar[0][0])
                            dp[i][j][k]=ar[0][0];
                        else if(k>=ar[i][j]){
                            ans=-1;
                            if(i>0)
                                ans=Math.max(ans,dp[i-1][j][k-ar[i][j]]);
                            if(j>0)
                                ans=Math.max(ans,dp[i][j-1][k-ar[i][j]]);
                            if(j>0&&i>0)
                                ans=Math.max(ans,dp[i-1][j-1][k-ar[i][j]]);
                            if(ans<=0)
                                dp[i][j][k]=-1;
                            else
                                dp[i][j][k]=ans+ar[i][j];
                        }
                        else
                            dp[i][j][k]=-1;
                    }
                }
            }
            System.out.println(dp[r-1][c-1][orb]);
        }
    }/*
    static int solve(int r,int c, int k){
        if(r==0 && c==0){
            if(k>=ar[0][0])
                return ar[0][0];
            else
                return -1;
        }
        else if(dp[r][c][k]!=0)
            return dp[r][c][k];
        int ans=-1,t=k-ar[r][c];
        if(t<0) {
            dp[r][c][k]=-1;
            return -1;
        }
        else {
            if(r>0 && c>0)
                ans =Math.max(ans,solve(r-1,c-1,t));
            if(r>0)
                ans =Math.max(ans,solve(r-1,c,t));
            if(c>0)
                ans =Math.max(ans,solve(r,c-1,t));
            if(ans==-1)
                dp[r][c][k]=-1;
            else
                dp[r][c][k]=ans+ar[r][c];
            return dp[r][c][k];
        }

    }*/
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