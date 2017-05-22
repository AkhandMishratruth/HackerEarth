//imports for BufferedReader*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

//import for Scanner and other utility classes
import java.util.*;


public class Quicksort {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = in.nextInt();
        }
        Quick array = new Quick(ar);
        array.motu_sort(0, ar.length-1);
        for(int toprin : array.ar)
          System.out.print(toprin+" ");
    }
}

class Quick{
  int[] ar;
  Quick(int[] a){
    ar = a;
  }
  int partition(int l, int r){
    int randomNum = ThreadLocalRandom.current().nextInt(l, r + 1);
    this.swap(randomNum, l);
    int piv = ar[l];
    int i = l+1;
    for(int j= l+1; j<=r; j++){
      if(ar[j]<piv){
        this.swap(i,j);
        i++;
      }
    }
    this.swap(l,i-1);
    return i-1;
  }
  void swap(int i, int j){
      int temp = ar[i];
      ar[i] = ar[j];
      ar[j] = temp;
  }
  void motu_sort(int l, int r){
    if(l<r){
      int pivot = this.partition(l,r);
      motu_sort(l, pivot-1);
      motu_sort(pivot+1, r);
    }
  }
}
