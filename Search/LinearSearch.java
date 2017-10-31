import java.util.*;
import java.io.*;

class LinearSearch {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), temp, ind = -1;
        for(int i = 1;i<=n;i++){
            temp = in.nextInt();
            if(temp==m)
                ind = i;
        }
        System.out.println(ind);
    }
}
