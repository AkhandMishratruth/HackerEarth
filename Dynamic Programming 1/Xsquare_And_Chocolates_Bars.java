import java.math.BigInteger;
import java.util.*;

public class Xsquare_And_Chocolates_Bars {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int last,max,t=in.nextInt();
        String st;
        char[] ch;
        int[] ad;
        while(t-->0){
            max=0;
            st=in.next();
            ch=st.toCharArray();
            ad=new int[ch.length];
            for(int i=2;i<ch.length;i++){
                if(ch[i]!=ch[i-1] || ch[i]!=ch[i-2] || ch[i-1]!=ch[i-2]){
                    ad[i]=3;
                    if(i>=3)
                        ad[i]+=ad[i-3];
                    if(max<ad[i])
                        max=ad[i];
                }
            }
            System.out.println(ch.length-max);
        }
    }
}