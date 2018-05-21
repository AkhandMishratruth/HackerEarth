import java.util.*;
import java.io.*;
import java.lang.*;

class  I_think_its_easy {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        //in.nextLine();
        while(n-->0){
            String[] st = in.nextLine().split(" ");

            IndVal[] ar = new IndVal[st.length];

            for(int i = 0; i<ar.length;i++){
                ar[i] = new IndVal(i, st[i].length());
            }

            IndVal[] ans = sort(ar);

            for(IndVal i : ans)
                System.out.print(st[i.ind].trim()+" ");

            System.out.println();
        }
    }

    static IndVal[] sort(IndVal[] ar){
        if(ar.length == 1)
            return ar;

        if(ar.length == 2){
            if(ar[0].val>ar[1].val){
                IndVal t = ar[0];
                ar[0] = ar[1];
                ar[1] = t;
            }
            return ar;
        }

        IndVal[] a = new IndVal[ar.length/2];
        IndVal[] b = new IndVal[ar.length - (ar.length/2)];

        for(int i=0;i<a.length;i++)
            a[i] = ar[i];
        for(int i=0;i<b.length;i++)
            b[i] = ar[i+a.length];

        a = sort(a);
        b = sort(b);

        return merge(a,b);
    }

    static IndVal[] merge(IndVal[] a, IndVal[] b){
        int i=0, j=0, k=0;
        IndVal[] ans = new IndVal[a.length + b.length];

        while(i<a.length && j<b.length){
            if(a[i].val>b[j].val)
                ans[k++] = b[j++];
            else
                ans[k++] = a[i++];
        }

        while(i<a.length)
            ans[k++] = a[i++];
        while(j<b.length)
            ans[k++] = b[j++];

        return ans;
    }
}

class IndVal {
    int ind, val;

    public IndVal(int ind, int val) {
        this.ind = ind;
        this.val = val;
    }

}