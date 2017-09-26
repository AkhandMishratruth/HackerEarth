import java.util.*;
import java.io.*;

public class MaximiseSum {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextLong();
        long[][] dp = new long[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=ar[i];
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        System.out.println(recusivefun(dp, ar, 0, n-1));
    }
    static long recusivefun(long[][] dp, long[] ar, int i, int j){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==j)
            return ar[i];
        long temp=-1;
        int n= ar.length;
        if(i<n-1 && i<j)
            temp = Math.max(temp, ar[i]+recusivefun(dp,ar,i+1,j));
        if(j>0 && i<j)
            temp = Math.max(temp, ar[j]+recusivefun(dp,ar,i,j-1));
        if(i<n-2 && i<j)
            temp = Math.max(temp, ar[i]*ar[i+1]+recusivefun(dp,ar,i+2,j));
        if(j>1 && i<j)
            temp = Math.max(temp, ar[j]*ar[j-1]+recusivefun(dp,ar,i,j-2));
        return dp[i][j]=temp;
    }
}