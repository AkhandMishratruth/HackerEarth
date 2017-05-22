import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class BubbleSort {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
          ar[i] = in.nextInt();
        }
        Bubble anss = new Bubble(ar);
        anss.sort();
        System.out.println(anss.ans);
    }
}
class Bubble{
  int[] Ar;
  int ans= 0;
  Bubble(int[] a){
    Ar = a;
  }
  void sort(){
    for(int i = 0; i < Ar.length-1; i++){
      for(int j = 0; j < Ar.length - i - 1; j++){
        if(Ar[j] > Ar[j+1]){
          int temp = Ar[j];
          Ar[j] = Ar[j+1];
          Ar[j+1] = temp;
          ans++;
        }
      }
    }
  }
}
