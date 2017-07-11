import java.io.*;
import java.util.*;

public class Edge_Existance {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt(), e = in.nextInt();
        Graph TheGra = new Graph(v);
        for(int i=0;i<e;i++)
            TheGra.setEdge(in.nextInt(), in.nextInt());
        int s,d,q = in.nextInt();
        while(q-- >0){
            s=in.nextInt();d=in.nextInt();
            if(TheGra.gra.get(s).contains(d))
                System.out.println("YES");
            else
                System.out.println("NO");
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
class Graph {
    Map<Integer, List<Integer>> gra;

    Graph(int vertex) {
        gra = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= vertex; i++)
            gra.put(i, new LinkedList<Integer>());
    }

    void setEdge(int s, int d) {
        List<Integer> th = gra.get(s);
        th.add(d);
        th = gra.get(d);
        th.add(s);
    }
}