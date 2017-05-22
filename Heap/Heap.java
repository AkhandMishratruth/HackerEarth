
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


public class Heap {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = in.nextInt();
            Arrays.sort(ar);
            if(i>=2){
                System.out.print(ar[N-1]+" "+ar[N-2]+" "+ar[N-3]);
            }
            else
                System.out.print("-1");
        }
        System.out.println();
    }
}