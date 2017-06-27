import java.io.*;
import java.util.*;

public class Gudi_and_the_Magical_Orbs {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int t = in.nextInt(), r, c, orb;
        int[][] ar, max;
        int[] three = new int[3];
        while (t-- > 0) {
            r = in.nextInt();
            c = in.nextInt();
            orb = in.nextInt();
            ar = new int[r][c];
            max = new int[r][c];
            for (int i = 0; i < ar.length; i++)
                for (int j = 0; j < ar[0].length; j++)
                    ar[i][j] = in.nextInt();
            max[r - 1][c - 1] = orb;
            for (int i = ar.length - 1; i >= 0; i--) {
                for (int j = ar[0].length - 1; j >= 0; j--) {
                    if (j > 0)
                        max[i][j - 1] = Math.max(max[i][j - 1], max[i][j] - ar[i][j]);
                    if (i > 0)
                        max[i - 1][j] = Math.max(max[i - 1][j], max[i][j] - ar[i][j]);
                    if (i > 0 && j > 0)
                        max[i - 1][j - 1] = Math.max(max[i - 1][j - 1], max[i][j] - ar[i][j]);
                }
            }
            /*
            for(int l=0;l<ar.length;l++){
                for(int k=0;k<ar[0].length;k++)
                    System.out.print(max[l][k]+" ");
                System.out.println();
            }
            System.out.println();*/
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[0].length; j++)
                    System.out.print(max[i][j] + " ");
                System.out.println();
            }
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[0].length; j++) {
                    if (i == 0 && j == 0)
                        ar[i][j] = ar[i][j];
                    else if (i == 0)
                        ar[i][j] = ar[i][j - 1] + ar[i][j];
                    else if (j == 0)
                        ar[i][j] = ar[i - 1][j] + ar[i][j];
                    else {
                        three[0] = ar[i][j] + ar[i][j - 1];
                        three[1] = ar[i][j] + ar[i - 1][j];
                        three[2] = ar[i][j] + ar[i - 1][j - 1];
                        Arrays.sort(three);
                        if (three[2] < max[i][j])
                            ar[i][j] = three[2];
                        else if (three[1] < max[i][j])
                            ar[i][j] = three[1];
                        else
                            ar[i][j] = three[0];
                    }
                    if (ar[i][j] > max[i][j])
                        ar[i][j] = 600;
                }
            }
            if (ar[r - 1][c - 1] == 600)
                System.out.println("-1");
            else
                System.out.println(ar[r - 1][c - 1]);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}