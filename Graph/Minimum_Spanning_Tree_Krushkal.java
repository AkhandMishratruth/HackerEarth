import java.io.*;
import java.util.*;

public class Minimum_Spanning_Tree_Krushkal {
    static Edge[] edge;
    static int[] root;
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt(), e = in.nextInt();
        edge = new Edge[e];
        root = new int[e+1];
        long cost =0;
        for(int i=1;i<root.length;i++)
            root[i] = i;
        for(int i=0;i<e;i++)
            edge[i] = new Edge(in.nextInt(),in.nextInt(),in.nextInt());
        Arrays.sort(edge);
        for(int i=0;i<edge.length;i++){
            if(Root(edge[i].fir)!=Root(edge[i].se)){
                cost += edge[i].wt;
                union(edge[i].fir,edge[i].se);
            }
        }
        System.out.println(cost);
    }
    static void union(int a, int b){
        int p=Root(a);
        int q=Root(b);
        root[p]=root[q];
    }

    static int Root(int x){
        while(root[x]!=x){
            root[x]=root[root[x]];
            x=root[x];
        }
        return x;
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
class Edge implements Comparable<Edge>{
    int fir, se, wt;
    Edge(int f, int s, int w){
        fir = f;
        se = s;
        wt = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.wt, o.wt);
    }
}