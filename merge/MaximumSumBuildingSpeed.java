import java.util.*;
import java.io.*;
import java.lang.*;

public class  MaximumSumBuildingSpeed {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[2*n];
        for(int i=0;i<2*n;i++)
            ar[i] = in.nextInt();
        Arrays.sort(ar);
        long ans = 0;
        for(int i=0;i<ar.length;i=i+2) {
            ans += ar[i];
            //System.out.println(ar[i]);
        }
        System.out.println(ans);
    }
}