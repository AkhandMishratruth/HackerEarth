import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class counting {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];

        TreeMap<Integer, Integer> tremap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            int temp = in.nextInt();
            if(tremap.containsKey(temp)){
              tremap.put(temp, tremap.get(temp)+1);
            }
            else{
              tremap.put(temp, 1);
            }
        }
        for(int ent : tremap.keySet()){
            System.out.print(ent+" "+tremap.get(ent));
            System.out.println();
        }
    }
}
