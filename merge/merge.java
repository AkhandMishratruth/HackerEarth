/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


public class merge {
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }

        Merge man = new Merge(A);
//        man.Ar=A;
        man = man.sorter();
        System.out.println(man.no);
    }
}
class Merge{
        int[] Ar;
        long no=0;

        public Merge(int[] A){
            Ar=A;
        }
        public Merge sorter(){

            if(Ar.length==1){
                return(this);
            }
            else{
                int[] Br = new int[Ar.length/2];
                int[] Cr = new int[Ar.length-(Ar.length/2)];

                for(int i = 0; i < Br.length; i++){
                    Br[i] = Ar[i];
                }
                for(int i = 0; i < Cr.length; i++){
                    Cr[i] = Ar[i + Br.length];
                }

                Merge B = new Merge(Br);
                B = B.sorter();
                Merge C = new Merge(Cr);
                C = C.sorter();
                Merge D = this.merger(B, C);

                return(D);
            }
        }
        public Merge merger(Merge B, Merge C){
            Merge Dr = new Merge(Ar);
            Dr.no = B.no + C.no;
            int i=0,j=0,k=0;
            while(i<B.Ar.length && j<C.Ar.length){
              if(B.Ar[i] <= C.Ar[j])
                  Dr.Ar[k] = B.Ar[i++];
              else{
                  Dr.Ar[k] = C.Ar[j++];
                  Dr.no += B.Ar.length - i ;
              }
              k++;
            }
            while(i<B.Ar.length && j>=C.Ar.length){
              Dr.Ar[k++] = B.Ar[i++];
            }
            while(i>=B.Ar.length && j < C.Ar.length){
              Dr.Ar[k++] = C.Ar[j++];
            }
//			System.out.println(Dr.no);
            return Dr;
        }
    }
