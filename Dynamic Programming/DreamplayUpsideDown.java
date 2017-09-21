import java.io.*;
import java.util.*;

public class DreamplayUpsideDown {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        int n = st.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=0;
        for(int l=2;l<=n;l++){
            for(int start =0;start<n-l+1;start++){
                int end = start+l-1;
                if(st.charAt(start)!=st.charAt(end) && l==2)
                    dp[start][end]=1;
                else if(st.charAt(start)==st.charAt(end))
                    dp[start][end]=dp[start+1][end-1];
                else
                    dp[start][end]=dp[start+1][end-1]+1;
                //System.out.println(start+" "+end);
            }
        }
        int[] pl = new int[n];
        int min=dp[0][n-1];
        for(int i=0;i<n-1;i++){
            min= Math.min(min, i+1+dp[i+1][n-1]);
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(min);
    }
    static int palinDrome(String st,int i, int j){
        int count=0;
        while(i<j) {
            if (st.charAt(i) != st.charAt(j))
                count++;
            i++;
            j--;
        }
        return count;
    }
}