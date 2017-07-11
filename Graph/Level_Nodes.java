import java.io.*;
import java.util.*;

public class Level_Nodes {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt();
        Graph TheGra = new Graph(v);
        for(int i=0;i<v-1;i++)
            TheGra.setEdge(in.nextInt(), in.nextInt());
        System.out.println(TheGra.nodesAtLev(in.nextInt()));
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
    int[] dist;

    Graph(int vertex) {
        gra = new HashMap<Integer, List<Integer>>();
        dist = new int[vertex + 1];
        for (int i = 1; i <= vertex; i++)
            gra.put(i, new LinkedList<Integer>());
    }

    void setEdge(int s, int d) {
        List<Integer> th = gra.get(s);
        th.add(d);
        th = gra.get(d);
        th.add(s);
    }

    int nodesAtLev(int s) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(1);
        dist[1]=1;
        int temp1, temp2;
        while (!q.isEmpty()) {
            temp1 = q.removeFirst();
            //System.out.print(q.size()+" ");
            Iterator it = gra.get(temp1).iterator();
            while (it.hasNext()) {
                temp2 = (Integer)it.next();
                if(dist[temp2]==0) {
                    q.add(temp2);
                    dist[temp2] = dist[temp1] + 1;
                }
            }
        }
        int toret = 0;
        for (int i : dist)
            if (i == s)
                toret++;
        return toret;
    }
}