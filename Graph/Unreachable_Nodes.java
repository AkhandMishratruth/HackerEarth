import java.io.*;
import java.util.*;

public class Unreachable_Nodes {
    public static void main(String args[]) throws Exception {
        FastReader in = new FastReader();
        int v = in.nextInt(), e = in.nextInt();
        Graph TheGra = new Graph(v);
        for(int i=0;i<e;i++)
            TheGra.setEdge(in.nextInt(), in.nextInt());
        System.out.println(TheGra.nodesAtLev(in.nextInt())-1);
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
    boolean[] dist;

    Graph(int vertex) {
        gra = new HashMap<Integer, List<Integer>>();
        dist = new boolean[vertex + 1];
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
        Stack<Integer> q = new Stack<>();
        q.push(s);
        dist[s]=true;
        int temp;
        while (!q.isEmpty()) {
            temp = q.pop();
            //System.out.print(q.size()+" ");
            Iterator it = gra.get(temp).iterator();
            while (it.hasNext()) {
                temp = (Integer)it.next();
                if(dist[temp]==false) {
                    q.push(temp);
                    dist[temp] = true;
                }
            }
        }
        int toret = 0;
        for (boolean i : dist)
            if (i == false)
                toret++;
        return toret;
    }
}